package com.example.jackf.contactapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class contactInfoPage extends AppCompatActivity {
    Button btn_Call, btn_Text, btn_Edit;

    EditText et_pictureNum, et_Age, et_name, et_phone, et_Email,et_Address1, et_Address2, et_Relationship, et_Description;

    int position;

    private static final int REQUEST_CALL =1;
    private Person p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info_page);
        btn_Call = findViewById(R.id.btn_Call);
        btn_Text = findViewById(R.id.btn_Text);
        btn_Edit = findViewById(R.id.btn_Edit);

        et_pictureNum = findViewById(R.id.et_pictureNum);
        et_name = findViewById(R.id.et_name);
        et_Age = findViewById(R.id.et_Age);
        et_phone = findViewById(R.id.et_phone);
        et_Email = findViewById(R.id.et_Email);
        et_Address1 = findViewById(R.id.et_Address1);
        et_Address2 = findViewById(R.id.et_Address2);
        et_Relationship = findViewById(R.id.et_Relationship);
        et_Description = findViewById(R.id.et_URL);

        //listen for incoming data
        Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent !=null){
            position = incomingIntent.getInt("position");
            p = (Person) global.getGlobalList().getLists().get(position);
            //fill the form
            et_pictureNum.setText(Integer.toString(p.getPictureNum()));
            et_name.setText(p.getName());
            et_Age.setText(Integer.toString(p.getAge()));
            et_phone.setText(p.getPhone());
            et_Email.setText(p.getEmail());
            et_Address1.setText(p.getAddress1());
            et_Address2.setText(p.getAddress2());
            et_Relationship.setText(p.getRelationship());
            et_Description.setText(p.getDescription());
        }

        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToEditPage = new Intent(v.getContext(), NewContact.class);
                goToEditPage.putExtra("position", position);

                startActivity(goToEditPage);
            }
        });

        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

        btn_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composeMmsMessage(p.getPhone(), "Hello!! ");
            }
        });

    }

    public void composeMmsMessage(String phone, String message) {
        phone = p.getPhone();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phone));  // This ensures only SMS apps respond
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void makePhoneCall(){
        String number = p.getPhone();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(contactInfoPage.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(contactInfoPage.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(contactInfoPage.this, "No phone number found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

}

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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class contactInfoBusiness extends AppCompatActivity {

    Button btn_Edit, btn_Email, btn_Call;

    EditText et_pictureNum, et_name, et_phone, et_Email,et_Address1, et_URL;
    TextView tv_Open, tv_Close;
    CheckBox cb_Mon, cb_Tue, cb_Wed, cb_Thur, cb_Fri, cb_Sat, cb_Sun;
    ImageView iv_Picture;

    int position;

    boolean[] incomingdaysofWeekOpen;

    private static final int REQUEST_CALL =1;
    private BusinessContact b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info_business);

        et_pictureNum = findViewById(R.id.et_pictureNum);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_Email = findViewById(R.id.et_Email);
        et_Address1 = findViewById(R.id.et_Address1);
        et_URL = findViewById(R.id.et_URL);
        tv_Open = findViewById(R.id.tv_Open);
        tv_Close = findViewById(R.id.tv_Close);

        Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent !=null){
            position = incomingIntent.getInt("position");
            b = (BusinessContact) global.getGlobalList().getLists().get(position);

            et_pictureNum.setText(Integer.toString(b.getPictureNum()));
            et_name.setText(b.getName());
            et_phone.setText(b.getPhone());
            et_Email.setText(b.getEmail());
            et_Address1.setText(b.getAddress1());
            tv_Open.setText(b.getOpening());
            tv_Close.setText(b.getClosing());
            et_URL.setText(b.getUrl());
            cb_Sun = findViewById(R.id.cb_Sun);
            cb_Mon = findViewById(R.id.cb_Mon);
            cb_Tue = findViewById(R.id.cb_Tue);
            cb_Wed = findViewById(R.id.cb_Wed);
            cb_Thur = findViewById(R.id.cb_Thur);
            cb_Fri = findViewById(R.id.cb_Fri);
            cb_Sat = findViewById(R.id.cb_Sat);

            incomingdaysofWeekOpen = b.getDaysofWeekOpen();
            if(incomingdaysofWeekOpen[0] = true){
                cb_Sun.setChecked(true);
            }else if(incomingdaysofWeekOpen[0] = false){
                cb_Sun.setChecked(false);
            }
            if(incomingdaysofWeekOpen[1] = true){
                cb_Mon.setChecked(true);
            }else if(incomingdaysofWeekOpen[1] = false){
                cb_Mon.setChecked(false);
            }
            if(incomingdaysofWeekOpen[2] = true){
                cb_Tue.setChecked(true);
            }else if(incomingdaysofWeekOpen[2] = false){
                cb_Tue.setChecked(false);
            }
            if(incomingdaysofWeekOpen[3] = true){
                cb_Wed.setChecked(true);
            }else if(incomingdaysofWeekOpen[3] = false){
                cb_Wed.setChecked(false);
            }
            if(incomingdaysofWeekOpen[4] = true){
                cb_Thur.setChecked(true);
            }else if(incomingdaysofWeekOpen[4] = false){
                cb_Thur.setChecked(false);
            }
            if(incomingdaysofWeekOpen[5] = true){
                cb_Fri.setChecked(true);
            }else if(incomingdaysofWeekOpen[5] = false){
                cb_Fri.setChecked(false);
            }
            if(incomingdaysofWeekOpen[6] = true){
                cb_Sat.setChecked(true);
            }else if(incomingdaysofWeekOpen[6] = false){
                cb_Sat.setChecked(false);
            }

        }

        btn_Edit = findViewById(R.id.btn_Edit);
        btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToEditPage = new Intent(v.getContext(), NewBusinessContact.class);
                goToEditPage.putExtra("position", position);

                startActivity(goToEditPage);
            }
        });

        btn_Email = findViewById(R.id.btn_Email);
        btn_Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String [] addresses = new String [1];
                addresses[0] = b.getEmail();

                sendEmail(addresses, "Hello from jack");
            }
        });

        btn_Call = findViewById(R.id.btn_Call);
        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_Call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        makePhoneCall();
                    }
                });

            }
        });

    }

    public void sendEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void makePhoneCall(){
        String number = b.getPhone();
        if(number.trim().length() > 0){
            if(ContextCompat.checkSelfPermission(contactInfoBusiness.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(contactInfoBusiness.this, new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }else{
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toast.makeText(contactInfoBusiness.this, "Enter a phone number!", Toast.LENGTH_SHORT).show();
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

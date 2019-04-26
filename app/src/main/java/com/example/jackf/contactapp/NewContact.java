package com.example.jackf.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContact extends AppCompatActivity {
    Button btn_save, btn_delete;
    EditText et_name, et_age, et_phone,
    et_email, et_address1, et_address2, et_relationship,
    et_contactDescription, et_pictureNum;


    int positionToEdit = -1;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        et_pictureNum = findViewById(R.id.et_pictureNum);
        et_name = findViewById(R.id.et_name);
        et_age = findViewById(R.id.et_age);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_address1 = findViewById(R.id.et_address1);
        et_address2 = findViewById(R.id.et_address2);
        et_relationship = findViewById(R.id.et_relationship);
        et_contactDescription = findViewById(R.id.et_URL);

        //listen for incoming data
        final Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent !=null){
            position = incomingIntent.getInt("position");
            Person p = (Person) global.getGlobalList().getLists().get(position);



            //fill the form
            et_pictureNum.setText(Integer.toString(p.getPictureNum()));
            et_name.setText(p.getName());
            et_age.setText(Integer.toString(p.getAge()));
            et_phone.setText(p.getPhone());
            et_email.setText(p.getEmail());
            et_address1.setText(p.getAddress1());
            et_address2.setText(p.getAddress2());
            et_relationship.setText(p.getRelationship());
            et_contactDescription.setText(p.getDescription());
        }

        btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get strings from et_view objects
                int newpictureNum = Integer.parseInt(et_pictureNum.getText().toString());
                String newname = et_name.getText().toString();
                int newage = Integer.parseInt(et_age.getText().toString());
                String newphone = et_phone.getText().toString();
                String newemail = et_email.getText().toString();
                String newaddress1 = et_address1.getText().toString();
                String newaddress2 = et_address2.getText().toString();
                String newrelationship = et_relationship.getText().toString();
                String newdescription = et_contactDescription.getText().toString();
                if(global.getGlobalList().getLists().contains(position)){
                    global.getGlobalList().deleteOne(global.getGlobalList().get(position));
                }

                Person p = new Person(newpictureNum, newname, newage, newphone, newemail, newaddress1, newaddress2, newrelationship, newdescription);
                global.getGlobalList().addOne(p);
                //DataService ds = new DataService(v.getContext());
                //ds.writeList((AddressBook) global.getGlobalList().getLists(), "contacts,txt");

                Intent backToMainPage = new Intent(v.getContext(), MainActivity.class);
                backToMainPage.putExtra("name", p.getName());
                backToMainPage.putExtra("position", positionToEdit);
                startActivity(backToMainPage);
            }
        });

        btn_delete=findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainPage = new Intent(v.getContext(), MainActivity.class);
                global.getGlobalList().deleteOne(global.getGlobalList().getLists().get(position));
                startActivity(backToMainPage);
            }
        });


    }

}

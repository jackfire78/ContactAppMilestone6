package com.example.jackf.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NewBusinessContact extends AppCompatActivity {

    Button btn_save, btn_delete;
    EditText et_pictureNum, et_name, et_phone, et_email,
    et_address1, et_address2, et_businessOpen, et_businessClose,
    et_businessURL;
    CheckBox cb_sunday, cb_monday, cb_tuesday, cb_wednesday,
    cb_thursday, cb_friday, cb_saturday;


    int positionToEdit = -1;
    int position;

    boolean[] daysofWeekOpen = new boolean[8];
    boolean[] incomingdaysofWeekOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_business_contact);

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_email = findViewById(R.id.et_email);
        et_address1 = findViewById(R.id.et_address1);
        et_address2 = findViewById(R.id.et_address2);
        et_businessOpen = findViewById(R.id.et_businessOpen);
        et_businessClose = findViewById(R.id.et_businessClose);
        et_businessURL = findViewById(R.id.et_URL);
        cb_sunday = findViewById(R.id.cb_sunday);
        cb_monday = findViewById(R.id.cb_monday);
        cb_tuesday = findViewById(R.id.cb_tuesday);
        cb_wednesday = findViewById(R.id.cb_wednesday);
        cb_thursday = findViewById(R.id.cb_thursday);
        cb_friday = findViewById(R.id.cb_friday);
        cb_saturday = findViewById(R.id.cb_saturday);
        et_pictureNum = findViewById(R.id.et_pictureNum);

        //listen for incoming data
        Bundle incomingIntent = getIntent().getExtras();
        if(incomingIntent !=null){
            position = incomingIntent.getInt("position");
            BusinessContact b = (BusinessContact) global.getGlobalList().getLists().get(position);
            //fill in the form
            et_name.setText(b.getName());
            et_phone.setText(b.getPhone());
            et_email.setText(b.getEmail());
            et_address1.setText(b.getAddress1());
            et_address2.setText(b.getAddrsss2());
            et_businessOpen.setText(b.getOpening());
            et_businessClose.setText(b.getClosing());
            et_businessURL.setText(b.getUrl());
            et_pictureNum.setText(b.getPictureNum());
            incomingdaysofWeekOpen = b.getDaysofWeekOpen();
            if(incomingdaysofWeekOpen[0] = true){
                cb_sunday.setChecked(true);
            }else if(incomingdaysofWeekOpen[0] = false){
                cb_sunday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[1] = true){
                cb_monday.setChecked(true);
            }else if(incomingdaysofWeekOpen[1] = false){
                cb_monday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[2] = true){
                cb_tuesday.setChecked(true);
            }else if(incomingdaysofWeekOpen[2] = false){
                cb_tuesday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[3] = true){
                cb_wednesday.setChecked(true);
            }else if(incomingdaysofWeekOpen[3] = false){
                cb_wednesday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[4] = true){
                cb_thursday.setChecked(true);
            }else if(incomingdaysofWeekOpen[4] = false){
                cb_thursday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[5] = true){
                cb_friday.setChecked(true);
            }else if(incomingdaysofWeekOpen[5] = false){
                cb_friday.setChecked(false);
            }
            if(incomingdaysofWeekOpen[6] = true){
                cb_saturday.setChecked(true);
            }else if(incomingdaysofWeekOpen[6] = false){
                cb_saturday.setChecked(false);
            }

        }

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get strings from et_view objects
                String newname = et_name.getText().toString();
                String newphone = et_phone.getText().toString();
                String newemail = et_email.getText().toString();
                String newaddress1 = et_address1.getText().toString();
                String newaddress2 = et_address2.getText().toString();
                String newopen = et_businessOpen.getText().toString();
                String newclose = et_businessClose.getText().toString();
                String newurl = et_businessURL.getText().toString();
                if(cb_sunday.isChecked()){
                    daysofWeekOpen[0] = true;
                }else{
                    daysofWeekOpen[0] = false;
                }
                if(cb_monday.isChecked()){
                    daysofWeekOpen[1] = true;
                }else{
                    daysofWeekOpen[1] = false;
                }
                if(cb_tuesday.isChecked()){
                    daysofWeekOpen[2] = true;
                }else{
                    daysofWeekOpen[2] = false;
                }
                if(cb_wednesday.isChecked()){
                    daysofWeekOpen[3] = true;
                }else{
                    daysofWeekOpen[3] = false;
                }
                if(cb_thursday.isChecked()){
                    daysofWeekOpen[4] = true;
                }else{
                    daysofWeekOpen[4] = false;
                }
                if(cb_friday.isChecked()){
                    daysofWeekOpen[5] = true;
                }else{
                    daysofWeekOpen[5] = false;
                }
                if(cb_saturday.isChecked()){
                    daysofWeekOpen[6] = true;
                }else{
                    daysofWeekOpen[6] = false;
                }
                boolean[] newDaysofTheWeek = daysofWeekOpen;
                int newpictureNum = Integer.parseInt(et_pictureNum.getText().toString());

                global.getGlobalList().deleteOne(global.getGlobalList().get(position));

                BusinessContact b = new BusinessContact(newname, newaddress1, newaddress2, newphone, newpictureNum, newemail, newopen,newclose,newDaysofTheWeek , newurl);
                global.getGlobalList().addOne(b);
                //DataService ds = new DataService(v.getContext());
                //ds.writeList((AddressBook) global.getGlobalList(), "contacts,txt");

                Intent backToMainPage = new Intent(v.getContext(), MainActivity.class);
                backToMainPage.putExtra("name", b.getName());
                backToMainPage.putExtra("position", position);
                startActivity(backToMainPage);
            }
        });

        btn_delete =findViewById(R.id.btn_delete);
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

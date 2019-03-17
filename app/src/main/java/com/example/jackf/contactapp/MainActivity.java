package com.example.jackf.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    Button btn_newpersonContact;
    Button btn_newbusinessContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_newpersonContact = findViewById(R.id.btn_newpersonContact);
        btn_newbusinessContact = findViewById(R.id.btn_newbusinessContact);

        btn_newbusinessContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNewContactPage = new Intent(v.getContext(), NewBusinessContact.class);
                startActivity(goToNewContactPage);
            }
        });
        btn_newpersonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToNewContactPage = new Intent(v.getContext(), NewContact.class);
                startActivity(goToNewContactPage);
            }
        });

    }
}

package com.example.jackf.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class contactInfoPage extends AppCompatActivity {
    Button btn_Call, btn_Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info_page);
        btn_Call = findViewById(R.id.btn_Call);
        btn_Text =findViewById(R.id.btn_Text);


    }

}

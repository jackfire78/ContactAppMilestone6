package com.example.jackf.contactapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewContact extends AppCompatActivity {
    Button btn_save, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        btn_save=findViewById(R.id.btn_save);
        btn_delete=findViewById(R.id.btn_delete);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainPage = new Intent(v.getContext(), MainActivity.class);
                startActivity(backToMainPage);
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToMainPage = new Intent(v.getContext(), MainActivity.class);
                startActivity(backToMainPage);
            }
        });

    }

}

package com.example.jackf.contactapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    Button btn_newpersonContact, btn_newbusinessContact, btn_Search;
    ListView lv_Contacts;
    Adapter adapter;
    AddressBook addressBook;
    //search method here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DataService ds = new DataService(this);
        //global.getGlobalList() = ds.readList("contacts.txt");

        btn_newpersonContact = findViewById(R.id.btn_newpersonContact);
        btn_newbusinessContact = findViewById(R.id.btn_newbusinessContact);

        lv_Contacts = findViewById(R.id.lv_Contacts);
        //global.getGlobalList().getLists() = (AddressBook)ds.readList("contacts.txt");

        adapter = new Adapter(MainActivity.this, global.getGlobalList());
        lv_Contacts.setAdapter(adapter);
        adapter.notifyDataSetChanged();

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

        lv_Contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });

        btn_Search = findViewById(R.id.btn_Search);
        btn_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSearchPage = new Intent(getApplicationContext(), Search.class);

                startActivity(toSearchPage);
            }
        });

    }


    public void editPerson(int position){
        BaseContact p = global.getGlobalList().getLists().get(position);
        if(p instanceof Person){
            Intent toInfoPage = new Intent(getApplicationContext(), contactInfoPage.class);
            //send position of person
            toInfoPage.putExtra("position", position);

            startActivity(toInfoPage);
        }else if(p instanceof BusinessContact){
            Intent toInfoPage = new Intent(getApplicationContext(), contactInfoBusiness.class);
            //send position of person
            toInfoPage.putExtra("position", position);

            startActivity(toInfoPage);
        }
    }


}

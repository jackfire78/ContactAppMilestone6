package com.example.jackf.contactapp;

import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Search extends AppCompatActivity {

    AddressBook addressBook;

    Button btn_searchSubmit;
    EditText et_search;
    ListView lv_searchContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        et_search = findViewById(R.id.et_search);
        btn_searchSubmit = findViewById(R.id.btn_searchSubmit);
        lv_searchContacts = findViewById(R.id.lv_searchContacts);

        addressBook =  global.getGlobalList();

        btn_searchSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String search = et_search.getText().toString();
                AddressBook results = addressBook.searchFor(search);
                Adapter adapter = new Adapter(Search.this, results);
                lv_searchContacts.setAdapter(adapter);

                //this goes through the list and searches every contact with the "search" string
               // for (int i = 0; i < results.getLists().size(); i++){
                 //   searchContact(search, i);
               // }
                adapter.notifyDataSetChanged();
            }
        });

        lv_searchContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editPerson(position);
            }
        });
    }

   /* public BaseContact searchContact(String search, int i){
        //sets this int to what has been returned by the search function in the addressBook
        int searchPosition = addressBook.searchFor(search, i);
        //error checking
        if (searchPosition != -1){
            //populating the new addressbook with search results form the original addressbook
            global.getGlobalList().addOne(addressBook.getLists().get(searchPosition));
            return addressBook.getLists().get(searchPosition);
        }else{
            return null;
        }
    } */

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


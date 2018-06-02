package com.example.akhilphotodot.sqlite_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper dbh;
    Button search,AddNew,update,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbh=new DataBaseHelper(this);
        search=(Button)findViewById(R.id.Search);
        AddNew=(Button)findViewById(R.id.AddNew);
        update=(Button)findViewById(R.id.Update);
        delete=(Button)findViewById(R.id.Delete);
        AddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addintent=new Intent(MainActivity.this,AddNewContact.class);
                startActivity(addintent);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchintent=new Intent(MainActivity.this,SearchContact.class);
                startActivity(searchintent);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateintent=new Intent(MainActivity.this,UpdateContact.class);
                startActivity(updateintent);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delintent=new Intent(MainActivity.this,DeleteContact.class);
                startActivity(delintent);
            }
        });


    }
}

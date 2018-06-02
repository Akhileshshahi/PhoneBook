package com.example.akhilphotodot.sqlite_example;

import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class SearchContact extends AppCompatActivity {

    TextView setname,setno,setmailid;
    ImageButton back;
    EditText name;
    ImageButton search;
    DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_contact);
        search=(ImageButton)findViewById(R.id.search);
        name=(EditText)findViewById(R.id.searchname);
        back=(ImageButton)findViewById(R.id.searchback);
        setname=(TextView)findViewById(R.id.searchedname);
        setno=(TextView)findViewById(R.id.searchedpno);
        setmailid=(TextView)findViewById(R.id.searchedmailid);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                dbh=new DataBaseHelper(SearchContact.this);
                String user_name=name.getText().toString();
                Cursor cur=dbh.getData(user_name);
                int i=0;


                    while (cur.moveToNext()) {
                        setname.setText(cur.getString(1));
                        setmailid.setText(cur.getString(3));
                        setno.setText(cur.getString(2));
                        Toast.makeText(SearchContact.this, "Found", Toast.LENGTH_LONG).show();
                        i++;
                    }

                if(i==0)
                {
                    Toast.makeText(SearchContact.this,"Not Found",Toast.LENGTH_SHORT).show();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(SearchContact.this,MainActivity.class);
                startActivity(backintent);
            }
        });

    }
}

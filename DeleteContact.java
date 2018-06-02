package com.example.akhilphotodot.sqlite_example;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class DeleteContact extends AppCompatActivity {

    ImageButton back;
    EditText name;
    Button del;
    DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_contact);
        back=(ImageButton)findViewById(R.id.deleteback);
        name=(EditText)findViewById(R.id.deletename);
        del=(Button)findViewById(R.id.delbutton);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbh=new DataBaseHelper(DeleteContact.this);
                String user_name=name.getText().toString();
                try
                {
                    dbh.delDate(user_name);
                            final String success_message = "Successfuly Deleted";
                            Toast.makeText(DeleteContact.this, success_message, Toast.LENGTH_SHORT).show();

                }
                catch(Exception e)
                {
                   // Intent backintent=new Intent(DeleteContact.this,MainActivity.class);
                    //Toast.makeText(DeleteContact.this,"Error Occured: Unsuccessfuly Deleted", Toast.LENGTH_SHORT).show();
                    //startActivity(backintent);
                    e.printStackTrace();
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(DeleteContact.this,MainActivity.class);
                startActivity(backintent);
            }
        });


    }
}

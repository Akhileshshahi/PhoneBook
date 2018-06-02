package com.example.akhilphotodot.sqlite_example;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddNewContact extends AppCompatActivity {

    EditText name;
    EditText phonenumber;
    EditText mailid;
    Button save;
    ImageButton back;
    private DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_contact);
        name=(EditText)findViewById(R.id.name);
        phonenumber=(EditText)findViewById(R.id.phonenumber);
        mailid=(EditText)findViewById(R.id.mailid);
        save=(Button)findViewById(R.id.save);
        back=(ImageButton)findViewById(R.id.back);
        dbh= new DataBaseHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(AddNewContact.this,MainActivity.class);
                startActivity(backintent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String user_name=name.getText().toString();
                String phone= String.valueOf(phonenumber.getText());
                String mail=mailid.getText().toString();
                if(user_name.equals("")||phone.equals("")||mail.equals(""))
                {
                    Toast.makeText(AddNewContact.this,"There is no entry",Toast.LENGTH_LONG).show();
                    Intent errorback=new Intent(AddNewContact.this,MainActivity.class);
                    startActivity(errorback);
                }
                else {
                    final String errormessage;
                    errormessage = "Hey ! " + user_name + " Contact Number Saved";
                    try {
                        Boolean result = dbh.insertData(user_name, phone, mail);
                        if (result) {
                            final String success_message = "Hey ! " + user_name + " Contact Number Saved";
                            Toast.makeText(AddNewContact.this, success_message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(AddNewContact.this, errormessage, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}

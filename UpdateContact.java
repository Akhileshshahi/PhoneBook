package com.example.akhilphotodot.sqlite_example;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UpdateContact extends AppCompatActivity {

    EditText name;
    EditText phonenumber;
    EditText mailid;
    Button save;
    ImageButton back;
    private DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        name=(EditText)findViewById(R.id.upadtename);
        phonenumber=(EditText)findViewById(R.id.updatephonenumber);
        mailid=(EditText)findViewById(R.id.updatemailid);
        save=(Button)findViewById(R.id.updatesave);
        back=(ImageButton)findViewById(R.id.updateback);
        dbh= new DataBaseHelper(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backintent=new Intent(UpdateContact.this,MainActivity.class);
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
                    Toast.makeText(UpdateContact.this,"There is no entry",Toast.LENGTH_LONG).show();
                    Intent errorback=new Intent(UpdateContact.this,MainActivity.class);
                    startActivity(errorback);
                }
                else {
                    final String errormessage;
                    errormessage = "May Be there is no contact or system error";
                    try {
                        boolean result = dbh.upDate(user_name, phone, mail);
                        if (result) {
                            final String success_message = "Hey ! " + user_name + " Contact Has Been updated";
                            Toast.makeText(UpdateContact.this, success_message, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(UpdateContact.this, errormessage, Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
    }


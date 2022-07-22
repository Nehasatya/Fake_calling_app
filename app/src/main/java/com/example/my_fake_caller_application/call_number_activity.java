package com.example.my_fake_caller_application;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class call_number_activity extends AppCompatActivity {

    ImageButton contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_number_activity);



        contacts=(ImageButton) findViewById(R.id.contacts);


        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(call_number_activity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(call_number_activity.this,new String[] {Manifest.permission.READ_CONTACTS}, 1);
                }
                else{

                    Intent display_contacts = new Intent(call_number_activity.this, com.example.my_fake_caller_application.display_contacts.class);
                    startActivity(display_contacts);
                }

            }
        });

        //get number
        EditText get_number = (EditText)findViewById(R.id.get_number);

        //get time
        ImageButton set_time = (ImageButton) findViewById((R.id.set_time1));
        set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check number is valid
                if(get_number.length()<10)
                {
                    Toast.makeText(call_number_activity.this,"Enter valid number!!",Toast.LENGTH_LONG).show();
                    return;
                }
                    //if so save in sqlite and start next activity


                    Intent get_time = new Intent(call_number_activity.this,call_timer_setting.class);
                    startActivity(get_time);
            }
        });


    }
}
package com.example.my_fake_caller_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton add_call= (ImageButton) findViewById(R.id.call_button);
        add_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent call_number_dialog = new Intent(MainActivity.this,call_number_activity.class);
                startActivity(call_number_dialog);
            }
        });
        ImageButton delete_call=(ImageButton) findViewById(R.id.delete_call);

    }
}
package com.example.my_fake_caller_application;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class call_timer_setting extends AppCompatActivity {

    AlarmManager alarmm;
    EditText edit_text;
    int time;
    ImageButton set_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_timer_setting);

        alarmm=(AlarmManager)getSystemService(ALARM_SERVICE);
        edit_text = (EditText) findViewById(R.id.time_set);
        set_time = (ImageButton) findViewById(R.id.set_button);
        String time_in_string=edit_text.getText().toString();
        try {
            time = Integer.parseInt(time_in_string);
        }
        catch (NumberFormatException e)
        {
            //just handling exception
        }
        long tigger_time = System.currentTimeMillis() + (time * 1000);

        set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(call_timer_setting.this, "CALL SET", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(call_timer_setting.this,MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(call_timer_setting.this,100,intent,0);

                alarmm.set(AlarmManager.RTC_WAKEUP,tigger_time,pendingIntent);
            }
        });



    }
}

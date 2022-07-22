package com.example.my_fake_caller_application;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {
   Intent make_call;
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb= notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1,nb.build());



    }
}

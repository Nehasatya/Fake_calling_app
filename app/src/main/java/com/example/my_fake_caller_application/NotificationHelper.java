package com.example.my_fake_caller_application;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

    public static final String channelID = "channelID";
    public static final String channelName = "Channel Name";
    PendingIntent pendingIntent1;
    PendingIntent pendingIntent2;

    private NotificationManager notificationManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }

    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);

    }

    public NotificationManager getManager() {
        if (notificationManager == null) {
           notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }

        Intent intent1 = new Intent(NotificationHelper.this,call_activity.class);
        intent1.putExtra("yes",true);
        intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
        |Intent.FLAG_ACTIVITY_NEW_TASK);
        pendingIntent1 = PendingIntent.getActivity(NotificationHelper.this,12,intent1,PendingIntent.FLAG_ONE_SHOT);


        Intent intent2 = new Intent(NotificationHelper.this,MainActivity.class);
        intent2.putExtra("No",false);
        intent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP
                |Intent.FLAG_ACTIVITY_NEW_TASK);
        pendingIntent2 = PendingIntent.getActivity(NotificationHelper.this,12,intent1,PendingIntent.FLAG_ONE_SHOT);



        return notificationManager;

    }

    public NotificationCompat.Builder getChannelNotification()
    {
        NotificationCompat.Builder nb = new NotificationCompat.Builder(getApplicationContext(),channelID)
                .setContentTitle("Call From")
                .setContentText("Calling")
                .setSmallIcon(R.drawable.ic_baseline_call_24)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_baseline_call_24))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(Settings.System.DEFAULT_RINGTONE_URI);

        nb.addAction(R.drawable.ic_launcher_foreground,"Attend",pendingIntent1);
        nb.addAction(R.drawable.ic_launcher_foreground,"Reject",pendingIntent2);

        return nb;


    }

}


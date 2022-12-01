package com.example.myapp;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.nio.channels.Channel;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        maneger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    NOTI_CHANNEL_ID
                    , "channel_name"
                    , NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("descrpi");
            maneger.createNotificationChannel(channel);
        }
    }

    NotificationManager maneger;
    private final String NOTI_CHANNEL_ID = "" ;
    private final int NOTI_ID = 10;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null){
            String data = intent.getStringExtra("data");
            Log.d("[myservise]", "data");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForeground(NOTI_ID, getNotification());

        }else  {
            maneger.notify(NOTI_ID, getNotification());
        }
        return START_REDELIVER_INTENT;

    }

    private Notification getNotification(){
        Intent intent = new Intent(this, NextActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
        return new NotificationCompat.Builder(this, NOTI_CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("title")
                .setContentText("서비스 실행중")
                .setContentIntent(pendingIntent)
                .setAutoCancel(false)
                .setOngoing(true)
                .build();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        maneger.cancel(NOTI_ID);
    }
}
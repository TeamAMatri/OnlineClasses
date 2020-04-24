package com.example.notificationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton tb;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb = findViewById(R.id.tb);
        sendNotification();
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tb.isChecked()){
                    createNotification();
                }
            }
        });

    }

    private void createNotification() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"Aitam");
        Intent i = new Intent(this,MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,1,i,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentTitle("Notification");
        builder.setContentText("This is to notify i am an notification");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setAutoCancel(false);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_launcher_foreground,"HELLO",pi);
        nm.notify(0,builder.build());
    }
    private void sendNotification(){
        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel nc= new NotificationChannel("Aitam","Android",NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.setLightColor(Color.RED);
            nc.enableVibration(true);
            nc.setDescription("This is a notification");
            nm.createNotificationChannel(nc);
        }

    }
}

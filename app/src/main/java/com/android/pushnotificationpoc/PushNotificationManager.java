package com.android.pushnotificationpoc;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;


/**
 * Created by webonise on 28/3/18.
 */

public class PushNotificationManager {
    private static PushNotificationManager instance;

    public static PushNotificationManager getInstance() {
        if(instance == null) {
            instance = new PushNotificationManager();
        }
        return instance;
    }

    private PushNotificationManager() {
        //empty constructor
    }

   public void sendNotification(String title){

       NotificationCompat.Builder notification_builder;
       NotificationManager notification_manager = (NotificationManager) MainApplication.getAppContext()
               .getSystemService(Context.NOTIFICATION_SERVICE);
       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           String chanel_id = "3000";
           CharSequence name = "Channel Name";
           String description = "Chanel Description";
           int importance = NotificationManager.IMPORTANCE_LOW;
           NotificationChannel mChannel = new NotificationChannel(chanel_id, name, importance);
           mChannel.setDescription(description);
           mChannel.enableLights(true);
           mChannel.setLightColor(Color.BLUE);
           notification_manager.createNotificationChannel(mChannel);
           notification_builder = new NotificationCompat.Builder(MainApplication.getAppContext(), chanel_id);
       } else {
           notification_builder = new NotificationCompat.Builder(MainApplication.getAppContext());
       }

       notification_builder.setSmallIcon(R.drawable.notification_circle_cyan)
               .setContentTitle(title)
               .setContentText(title)
               .setPriority(NotificationCompat.PRIORITY_DEFAULT);
       NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainApplication.getAppContext());

       // notificationId is a unique int for each notification that you must define
       notificationManager.notify((int) Math.random(), notification_builder.build());

   }
}

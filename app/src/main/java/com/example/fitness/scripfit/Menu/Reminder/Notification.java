package com.example.fitness.scripfit.Menu.Reminder;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class Notification extends BroadcastReceiver {
    private AlarmManager alarmMgr = null;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;

    @Override
    public void onReceive(Context context, Intent intent) {


//        mNotificationManager = (NotificationManager)
//                context.getSystemService(Context.NOTIFICATION_SERVICE);
//
//        Intent intent = new Intent(context, NotificationActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        // If you use intent extras, remember to call PendingIntent.getActivity() with the flag
//        // PendingIntent.FLAG_UPDATE_CURRENT, otherwise the same extras will be reused for every
//        // notification.
//        PendingIntent contentIntent = PendingIntent.getActivity(context, deviceId.hashCode(), intent,
//                PendingIntent.FLAG_UPDATE_CURRENT);
//
//        NotificationCompat.Builder mBuilder =
//                new NotificationCompat.Builder(context)
//                        .setSmallIcon(getNotificationIcon())
//                        .setContentTitle(title)
//                        .setStyle(new NotificationCompat.BigTextStyle()
//                                .bigText(msg))
//                        .setContentText(msg);
//
//        mBuilder.setContentIntent(contentIntent);
//        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());

    }
}

package com.developer.manishpatiyal.homie;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Manish Patiyal on 8/31/2017.
 */
public class BootReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        // Your code to execute when Boot Completd
        Toast.makeText(context, "Booting Completed", Toast.LENGTH_LONG).show();
        setAlarm(context);
    }

    void setAlarm(Context alarmContext) {
        PendingIntent pi = PendingIntent.getService(alarmContext.getApplicationContext(), 0,
                new Intent(alarmContext.getApplicationContext(), DashboardActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager am = (AlarmManager) alarmContext.getApplicationContext().getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 60);
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
        Toast.makeText(alarmContext, "Start Alarm", Toast.LENGTH_LONG).show();


       /* Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 13); // For 1 PM or 2 PM
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        PendingIntent pi = PendingIntent.getService(alarmContext.getApplicationContext(), 0,
                new Intent(alarmContext.getApplicationContext(), DashboardActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) alarmContext.getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY, pi);*/
    }
}

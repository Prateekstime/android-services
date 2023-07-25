package com.example.day24;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "On Create Triggered");
        Toast.makeText(this, "ONStsrt commsnd", Toast.LENGTH_SHORT);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("service", "On Start  Triggered");

        Toast.makeText(this, "ONStsrt commsnd", Toast.LENGTH_SHORT);


        for (int i = 0; i<1000;i++) {
            Log.e("number","count"+i);
        }
        return START_STICKY;
//        return null;



    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
package com.example.powerreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter filter = new IntentFilter();

        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver(mReceiver, filter);
    }

    //Dynamic receivers should be unregistered when the activity/app is destroyed to save resources, prevent leaks etc.
    @Override
    protected void onDestroy() {

        this.unregisterReceiver(mReceiver);
        super.onDestroy();
    }
}
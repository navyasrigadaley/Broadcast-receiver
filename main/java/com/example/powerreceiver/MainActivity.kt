package com.example.powerreceiver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.IntentFilter
import android.view.View
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MainActivity : AppCompatActivity() {
    private val mReceiver = CustomReceiver()
    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val filter = IntentFilter()
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
       // filter.addAction(Intent.ACTION_CUSTOM_BROADCAST)
        this.registerReceiver(mReceiver, filter);
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(mReceiver, IntentFilter(ACTION_CUSTOM_BROADCAST))
    }
    override fun onDestroy() {
        //Unregister the receiver
        unregisterReceiver(mReceiver)
        super.onDestroy()
        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(mReceiver);

    }

    fun sendCustomBroadcast(view: View) {
        val customBroadcastIntent = Intent(ACTION_CUSTOM_BROADCAST)
        LocalBroadcastManager.getInstance(this).sendBroadcast(customBroadcastIntent);

    }

}
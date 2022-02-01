package com.example.powerreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomReceiver : BroadcastReceiver() {

    private val ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST"


    override fun onReceive(context: Context?, intent: Intent) {

        val intentAction = intent.action
        var toastMessage = "unknown intent action"
        if (intentAction != null) {

            when (intentAction) {
                Intent.ACTION_POWER_CONNECTED -> toastMessage = "Power connected!"
                Intent.ACTION_POWER_DISCONNECTED -> toastMessage = "Power disconnected!"
                ACTION_CUSTOM_BROADCAST -> toastMessage = "Custom Broadcast received"
               // Intent.ACTION_CUSTOM_BROADCAST-> toastMessage = "Custom Broadcast Received";
               // break;

            }

            //Display the toast.
        }
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();


    }

}
package com.example.k2ohashi.testapp.Ui.Activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by k2ohashi on 17/05/11.
 */
public class ReceivedActivity extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "called ReceivedActivity", Toast.LENGTH_SHORT).show();
    }
}

package com.example.ordersystem.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetWorkReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network[] networks = connMgr.getAllNetworks();
        StringBuilder sb = new StringBuilder();
        for (Network network : networks) {
            NetworkInfo networkInfo = connMgr.getNetworkInfo(network);
            if (!networkInfo.isConnected()) {
                sb.append(networkInfo.getTypeName()).append(" connect is ").append(networkInfo.isConnected());
            }
        }
        if (!sb.toString().isEmpty()) {
            Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}


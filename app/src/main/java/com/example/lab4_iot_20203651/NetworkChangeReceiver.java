package com.example.lab4_iot_20203651;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* Clase generada con ChatGPT para actualizar el botón en función de si hay internet o no. Modificada por mí para que use
* las actividades correspondientes y un poco de la lógica para que mande bien la confirmación*/
public class NetworkChangeReceiver extends BroadcastReceiver {

    private MainActivity mainActivity;

    public NetworkChangeReceiver(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("NetworkChangeReceiver", "ahora si");

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();

        mainActivity.actualizarEstadoBoton(tieneInternet);
    }
}

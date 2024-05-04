package com.example.lab4_iot_20203651;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private NetworkChangeReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button botonApi = findViewById(R.id.botonApi);
        botonApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppActivity.class);
                startActivity(intent);
            }
        });

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver(this);
        registerReceiver(receiver, filter);

        verificarConexionInternet();
    }

    private void verificarConexionInternet() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        boolean tieneInternet = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        Log.d("msg-test", "Internet: " + tieneInternet);

        Button botonApi = findViewById(R.id.botonApi);
        if (!tieneInternet) {
            botonApi.setEnabled(false);
            mostrarDialogoSinConexion();
        } else {
            botonApi.setEnabled(true);
        }
    }

    public void actualizarEstadoBoton(boolean tieneInternet) {
        Button botonApi = findViewById(R.id.botonApi);
        botonApi.setEnabled(tieneInternet);
    }

    /* Esto viene de ChatGPT, pero fue modificado por mí, el prompt fue "Dame un ejemplo de como implementar
     * un dialog, por mi parte se modificó los titulos, los textos, el intent de ACTION_SETTINGS  */
    private void mostrarDialogoSinConexion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sin conexión a Internet")
                .setMessage("No se pudo establecer una conexión con internet")
                .setPositiveButton("Configuración", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
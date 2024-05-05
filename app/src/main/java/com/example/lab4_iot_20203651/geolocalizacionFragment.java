package com.example.lab4_iot_20203651;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab4_iot_20203651.interfaces.GeoApiService;
import com.example.lab4_iot_20203651.objetos.Geolocalizacion;
import com.example.lab4_iot_20203651.objetos.ListAdapterGeolo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class geolocalizacionFragment extends Fragment {

    private static final String API_KEY = "8dd6fc3be19ceb8601c2c3e811c16cf1";
    private EditText editTextCiudad;

    List<Geolocalizacion> elements;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_geolocalizacion, container, false);
        editTextCiudad = view.findViewById(R.id.editTextCiudad);
        Button buttonBuscar = view.findViewById(R.id.buttonBuscar);

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDetallesGeolocalizacion();
            }
        });

        return view;
    }

    private void obtenerDetallesGeolocalizacion() {
        String ciudad = editTextCiudad.getText().toString();
        Log.d("ciudad",ciudad);

        GeoApiService geoApiService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GeoApiService.class);

        geoApiService.getGeolocalizaciondetalis(ciudad, API_KEY).enqueue(new Callback<List<Geolocalizacion>>() {
            @Override
            public void onResponse(@NonNull Call<List<Geolocalizacion>> call, @NonNull Response<List<Geolocalizacion>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("msg_yeih", "Recibimos bien");
                    List<Geolocalizacion> geos = response.body();
                } else {
                    Log.e("msg-error", "Error al realizar la llamada a la API: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Geolocalizacion>> call, Throwable t) {
                Log.e("msg-error", "Error al realizar la llamada a la API", t);
            }
        });

    }
}







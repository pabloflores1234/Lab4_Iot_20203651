package com.example.lab4_iot_20203651;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab4_iot_20203651.interfaces.GeoApiService;
import com.example.lab4_iot_20203651.objetos.Geolocalizacion;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class geolocalizacionFragment extends Fragment {

    private static final String API_KEY = "8dd6fc3be19ceb8601c2c3e811c16cf1";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_geolocalizacion, container, false);
        EditText editTextCiudad = view.findViewById(R.id.editTextCiudad);


        GeoApiService geoApiService = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GeoApiService.class);

        geoApiService.getGeolocalizaciondetalis(editTextCiudad,API_KEY).enqueue(new Callback<Geolocalizacion>() {
            @Override
            public void onResponse(Call<Geolocalizacion> call, Response<Geolocalizacion> response) {

            }

            @Override
            public void onFailure(Call<Geolocalizacion> call, Throwable t) {

            }
        });


        return view;
    }
}


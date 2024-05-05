package com.example.lab4_iot_20203651.interfaces;



import com.example.lab4_iot_20203651.objetos.Geolocalizacion;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import java.util.List; // Importa la clase List

public interface GeoApiService {

    @GET("/geo/1.0/direct")
    Call<List<Geolocalizacion>> getGeolocalizaciondetalis(@Query("q") String ciudad, @Query("appid") String key);

}

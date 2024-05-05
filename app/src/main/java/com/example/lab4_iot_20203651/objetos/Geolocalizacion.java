package com.example.lab4_iot_20203651.objetos;




import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Geolocalizacion implements Serializable{


    @SerializedName("nameCiudad")
    private String nameCiudad;

    @SerializedName("latitud")
    private String latitud;
    @SerializedName("longitud")
    private String longitud;

    @SerializedName("country")
    private String country;

    @SerializedName("state")
    private String state;


    @SerializedName("localNames")
    private Map<String, String> localNames;

    public String getNameCiudad() {
        return nameCiudad;
    }

    public void setNameCiudad(String nameCiudad) {
        this.nameCiudad = nameCiudad;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Map<String, String> getLocalNames() {
        return localNames;
    }

    public void setLocalNames(Map<String, String> localNames) {
        this.localNames = localNames;
    }





}

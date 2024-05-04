package com.example.lab4_iot_20203651.objetos;




import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

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


    @SerializedName("datos")
    private List<Datos> datos;

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

    public List<Datos> getDatos() {
        return datos;
    }

    public void setDatos(List<Datos> datos) {
        this.datos = datos;
    }
}

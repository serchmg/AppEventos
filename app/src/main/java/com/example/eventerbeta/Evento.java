package com.example.eventerbeta;

/**
 * Created by Serch on 6/21/2017.
 */

public class Evento {

    int imagenEvento;
    String nombreEvento;
    String fecha;

    public Evento(int imagenEvento, String nombreEvento, String fecha) {
        this.imagenEvento = imagenEvento;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
    }

    public int getImagenEvento() {
        return imagenEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setImagenEvento(int imagenEvento) {
        this.imagenEvento = imagenEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


}

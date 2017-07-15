package com.example.eventerbeta;

import android.widget.TextView;

/**
 * Created by Serch on 6/23/2017.
 */

class EventoDetailed {
    String imagenEvento;
    String nombreEvento;
    String fechaEvento;
    String organizer;
    boolean favorito;
    boolean destacado;
    int categoria1;
    int categoria2;

    public EventoDetailed(String imagenEvento, String nombreEvento, String fechaEvento, String organizer,
                          boolean favorito, boolean destacado, int categoria1,
                          int categoria2) {
        this.imagenEvento = imagenEvento;
        this.nombreEvento = nombreEvento;
        this.organizer = organizer;
        this.fechaEvento = fechaEvento;
        this.favorito = favorito;
        this.destacado = destacado;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
    }

    public void setImagenEvento(String imagenEvento) {
        this.imagenEvento = imagenEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public void setCategoria1(int categoria1) {
        this.categoria1 = categoria1;
    }

    public void setCategoria2(int categoria2) {
        this.categoria2 = categoria2;
    }

    public String getImagenEvento() {
        return imagenEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public int getCategoria1() {
        return categoria1;
    }

    public int getCategoria2() {
        return categoria2;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }
}

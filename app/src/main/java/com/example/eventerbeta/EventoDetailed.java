package com.example.eventerbeta;

/**
 * Created by Serch on 6/23/2017.
 */

class EventoDetailed {
    int imagenEvento;
    String nombreEvento;
    String fechaEvento;
    boolean favorito;
    boolean destacado;
    String categoria1;
    String categoria2;

    public EventoDetailed(int imagenEvento, String nombreEvento, String fechaEvento,
                          boolean favorito, boolean destacado, String categoria1,
                          String categoria2) {
        this.imagenEvento = imagenEvento;
        this.nombreEvento = nombreEvento;
        this.fechaEvento = fechaEvento;
        this.favorito = favorito;
        this.destacado = destacado;
        this.categoria1 = categoria1;
        this.categoria2 = categoria2;
    }

    public void setImagenEvento(int imagenEvento) {
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

    public void setCategoria1(String categoria1) {
        this.categoria1 = categoria1;
    }

    public void setCategoria2(String categoria2) {
        this.categoria2 = categoria2;
    }

    public int getImagenEvento() {
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

    public String getCategoria1() {
        return categoria1;
    }

    public String getCategoria2() {
        return categoria2;
    }
}

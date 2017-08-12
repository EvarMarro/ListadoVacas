package com.example.evar.listadovacas;

import android.graphics.drawable.Drawable;

/**
 * Created by Evar on 08/08/2017.
 */

public class Vaca {
    protected Drawable foto;
    protected String nombre;
    protected String info;
    protected long id;

    public Vaca(Drawable foto, String nombre, String info){
        this.foto = foto;
        this.nombre = nombre;
        this.info = info;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

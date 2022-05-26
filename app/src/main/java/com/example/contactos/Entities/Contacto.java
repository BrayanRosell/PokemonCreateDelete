package com.example.contactos.Entities;

public class Contacto {
    public int Id;
    public String Nombre;
    public String Tipo;
    public String Region;
    public String Imagen;
    public Contacto() {
    }
    public Contacto(int id, String nombre, String tipo, String region, String imagen) {
        Id = id;
        Nombre = nombre;
        Tipo = tipo;
        Region = region;
        Imagen = imagen;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

}

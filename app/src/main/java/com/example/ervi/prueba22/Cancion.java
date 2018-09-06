package com.example.ervi.prueba22;

public class Cancion {
    private String Nombre;
    private double Duracion;

    public Cancion() {
    }

    public Cancion(String nombre, double duracion) {
        this.Nombre = nombre;
        this.Duracion = duracion;
    }
    public String GetNombre()
    {
        return Nombre;
    }
    public double GetDuracion()
    {
        return Duracion;
    }


    public void SetNombre(String nombre)
    {
        this.Nombre = nombre;
    }

    public void SetDuracion(double duracion)
    {
        this.Duracion = duracion;
    }

}

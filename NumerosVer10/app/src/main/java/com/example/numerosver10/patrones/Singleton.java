package com.example.numerosver10.patrones;

import android.util.Log;

public class Singleton {
    private static Singleton juego;
    private static int vidas;
    private static int puntuacion;
    private static String solucion;


    private Singleton(){
        int vidas=0;
        String solucion="";
    }

    public static Singleton getInstancia(){
        if (juego==null){
            juego = new Singleton();
        }
        return juego;
    }

    public void juegoNuevo(){
        vidas=3;
        puntuacion=0;
        Log.d("Tag", "Juego Nuevo Diviertete, Vidas= "+vidas);
    }

    public void restarVidas(){
        vidas=vidas-1;
    }

    public static int getVidas() {
        return vidas;
    }

    public static String getSolucion() {
        return solucion;
    }

    public static void setSolucion(String solucion) {
        Singleton.solucion = solucion;
    }

    public static int getPuntuacion() {
        return puntuacion;
    }

    public static void masPuntuacion() {
        puntuacion=puntuacion+1;
    }
}

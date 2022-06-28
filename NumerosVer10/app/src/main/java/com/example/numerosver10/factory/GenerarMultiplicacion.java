package com.example.numerosver10.factory;

import com.example.numerosver10.patrones.Singleton;

import java.util.Random;

public class GenerarMultiplicacion {
    Singleton single = Singleton.getInstancia();
    public GenerarMultiplicacion() {
    }

    public String problemaMultiplicacion(){

        Random r = new Random();
        String cadena;
        int resultado;
        int num1;
        int num2;

        num1= r.nextInt(11 - 1) + 1;


        num2=r.nextInt(11 - 1) + 1;


        resultado=num1*num2;

        cadena=num1+" X "+num2+" = ?";

        single.setSolucion(Integer.toString(resultado));

        return cadena;

    }
}

package com.example.numerosver10.factory;

import android.content.Intent;

import com.example.numerosver10.patrones.Singleton;

import java.util.Random;

public class GenerarSuma {
    Singleton single = Singleton.getInstancia();
    public GenerarSuma() {
    }

    public String problemaSuma(){
        Random r = new Random();
        String cadena;
        int resultado;
        int num1;
        int num2;

        num1= r.nextInt(11 - 1) + 1;

        do {
         num2=r.nextInt(11 - 1) + 1;
        }while (num2>num1);

        resultado=num1+num2;

        cadena=num1+" + "+num2+" = ?";

        single.setSolucion(Integer.toString(resultado));

        return cadena;
    }
}

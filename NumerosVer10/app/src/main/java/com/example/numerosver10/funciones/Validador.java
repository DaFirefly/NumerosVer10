package com.example.numerosver10.funciones;

import com.example.numerosver10.patrones.Singleton;

public class Validador {

    public Validador() {
    }

    public boolean validarRespuesta(String resp){
        Singleton single = Singleton.getInstancia();

        if(resp.equals(single.getSolucion())){return true;}
        else
        return false;
    }
}

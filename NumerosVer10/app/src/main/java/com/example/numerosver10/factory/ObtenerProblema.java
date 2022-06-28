package com.example.numerosver10.factory;

import java.util.Random;

public class ObtenerProblema {

    private GenerarSuma sum = new GenerarSuma();
    private GenerarResta res = new GenerarResta();
    private GenerarMultiplicacion mul = new GenerarMultiplicacion();

    public ObtenerProblema() {
    }

    public String dameUnProblema(){
        String cadena;
        Random r = new Random();
        int dado = 0;
        dado = r.nextInt(4-1)+1;
        //dado = r.nextInt(2-1)+1;


        if (dado==1){cadena=sum.problemaSuma();return cadena;}
        else if (dado==2){cadena= res.problemaResta();return cadena;}
        else if (dado==3){cadena= mul.problemaMultiplicacion();return cadena;}
        else
        return "0";
    }
}

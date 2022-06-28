package com.example.numerosver10.patrones;

import com.example.numerosver10.factory.ObtenerProblema;
import com.example.numerosver10.funciones.Validador;

public class Fachada {
    private Singleton single;
    private ObtenerProblema prob;
    private Validador valida;

    public Fachada(){
        //Instanciar las clases
        single = Singleton.getInstancia();
        prob= new ObtenerProblema();
        valida = new Validador();
    }

    public void juegoNuevo(){
        single.juegoNuevo();
    }
    public void aumentarPunto(){single.masPuntuacion();}
    public String tenerpuntos(){return Integer.toString(single.getPuntuacion());}
    public void restarvida(){single.restarVidas();}
    public int obtenerVidas(){return single.getVidas();}

    public String obtenerProblema(){
        String problema;

        problema=prob.dameUnProblema();
        return  problema;

    }

    public boolean validarRespuesta(String respuesta){
        boolean veredicto;
        veredicto = valida.validarRespuesta(respuesta);
        return veredicto;
    }
}

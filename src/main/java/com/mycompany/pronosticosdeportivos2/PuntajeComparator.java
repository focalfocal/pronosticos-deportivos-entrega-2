package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
//import java.util.Collections;  
import java.util.Comparator; // para sort de ArrayList

/**
 *
 * @author jul
 */
public class PuntajeComparator implements Comparator<ArrayList<Object>> {

    @Override //To sort an ArrayList using Comparator we need to override the compare() method provided by comparator interface
    
    public int compare(ArrayList<Object> datosParticipante1, ArrayList<Object> datosParticipante2) {

        int puntaje1 = (int) datosParticipante1.get(1); //uso casteo (int) porque el puntaje esta como Object
        int puntaje2 = (int) datosParticipante2.get(1);

        return Integer.compare(puntaje1, puntaje2);
    }
    
}

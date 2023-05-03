package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;

/**
 * Pronosticos Deportivos - Entrega 1
 * @author dd
 * Java 11 (LTS)
 * Suposiciones:
 * - Se supone que el orden en que se indican los dos equipos en un partido es el mismo tanto para los resultados de ese partido como para el pronóstico (condición local-visitante). 
 * - En la siguiente etapa tendré en cuenta una cantidad fija de partidos por ronda. En esta etapa supongo que cada archivo completo corresponde a una ronda.
 */
public class PronosticosDeportivos2 {
    
    enum ResultadoEnum{
        GANADO,
        EMPATADO,
        PERDIDO
    }
    
    //En Netbeans, los valores de los argumentos se colocan en File---Project Properties --- Categories: Run ---- Arguments  y van separados por espacios
    public static void main(String[] args) {
        
        //Crea objeto ronda con todos los partidos jugados, leidos de archivo
        Ronda ronda = new Ronda("1", args[0]);
        
        //Crea objeto pronosticos con todos los ponosticos, leidos de archivo
        Pronosticos pronosticos = new Pronosticos("Mariana", args[1]);
          
        //Determina el puntaje correspondiente a esta ronda y estos pronosticos de una ronda
        int puntos = ronda.evaluarPronosticos (pronosticos);
        
        System.out.println("Participante: " + pronosticos.getParticipante());
        System.out.println("Puntos: " + puntos);
    }
}

package com.mycompany.pronosticosdeportivos2;

/**
 * Pronosticos Deportivos - Entrega 2
 * @author dd
 * Java 11 (LTS)
 * Suposiciones / bases:
 * - Se supone que el orden en que se indican los dos equipos en un partido es el mismo tanto para los resultados de ese partido como para el pronóstico (condición local-visitante). 
 * - Los archivos de resultados y pronósticos incluyen varias rondas. También incluyen las columnas de fase (par etapa 3), pero no se utilizan aquí todavía.
 *
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
        Rondas ronda = new Rondas(args[0]);
        
        //Crea objeto Participantes con todos los pronosticos, leidos de archivo
        Participantes participantes = new Participantes(args[1], ronda);
        
        participantes.evaluarPronosticosParticipantes();
        
        participantes.imprimirParticipantesYpuntajes();
         
    }
}

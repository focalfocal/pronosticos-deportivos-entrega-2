package com.mycompany.pronosticosdeportivos1;

import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class Pronosticos {
    
    private String participante;
    private ArrayList<UnPronostico> pronosticos;
    
    Pronosticos (String participante, String ruta){
        this.participante = participante;
        this.pronosticos = new ArrayList();
        //lee contenido del archivo hacia this.pronosticos
        this.leerPronosticos(ruta);
    }
            
    //Se supone que el orden de los distintos items en cada resultado de partidos y de pronósticos es fijo y no variará nunca y que la primera fila son titulos.
    public void leerPronosticos(String ruta){
        
        LectorArchivos lectorArchivos = new LectorArchivos();
        
        ArrayList<String[]> renglonesParseados;
        renglonesParseados = lectorArchivos.leerArchivo(ruta);

        for (String[] i : renglonesParseados){
            
            //para etapa 2: los equipos se crean solo en ronda 1. En rondas siguientes, se obtienen y buscan los existentes para crear el partido.

            UnPronostico unPronostico = new UnPronostico(i[0], i[4], i[1], i[2], i[3]);

            this.pronosticos.add(unPronostico);
        }
        
    }

    

    /**
     * @return the participante
     */
    public String getParticipante() {
        return participante;
    }

    /**
     * @param participante the participante to set
     */
    public void setParticipante(String participante) {
        this.participante = participante;
    }

    /**
     * @return the pronosticos
     */
    public ArrayList<UnPronostico> getPronosticos() {
        return pronosticos;
    }

    /**
     * @param pronosticos the pronosticos to set
     */
    public void setPronosticos(ArrayList<UnPronostico> pronosticos) {
        this.pronosticos = pronosticos;
    }

}

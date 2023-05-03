package com.mycompany.pronosticosdeportivos1;

import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class Ronda {
    
    private String numero;
    private ArrayList<PartidoJugado> partidos;
    
    Ronda (String numero, String ruta){
        this.numero = numero;
        this.partidos = new ArrayList();
        //lee contenido del archivo hacia this.partidos
        this.leerRonda(ruta);
    }
            
    //Se supone que el orden de los distintos items en cada resultado de partidos y de pronósticos es fijo y no variará nunca y que la primera fila son titulos.
    public void leerRonda(String ruta){
        
        LectorArchivos lectorArchivos = new LectorArchivos();
        
        ArrayList<String[]> renglonesParseados;
        renglonesParseados = lectorArchivos.leerArchivo(ruta);
        
        Equipo equipo1;
        Equipo equipo2;
        
        for (String[] i : renglonesParseados){
            //Nota para etapa 2: los equipos se crean solo en ronda 1. En rondas siguientes, se obtienen y buscan los existentes para crear el partido.
            
            equipo1 = new Equipo(i[0], i[1], i[2]);
            equipo2 = new Equipo(i[5], i[6], i[7]);
            
            PartidoJugado partidoJugado = new PartidoJugado(equipo1,equipo2,Integer.parseInt(i[3]),Integer.parseInt(i[4]));
            
            this.partidos.add(partidoJugado);
        }
        
    }

    //Dado un pronostico, determina cual es el partido jugado en esta ronda cuyos equipos coinciden
    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico){
        
        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaEquipos();
        
        for (PartidoJugado partido : this.partidos ){
 
            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
                return partido;
            }
        }
        
        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
        System.exit(1);
        return new PartidoJugado(); //formalidad para cumplir sintaxis de metodo.
    } 
    
    public int evaluarPronosticos (Pronosticos pronosticos){
        int puntaje = 0;
        
        for (UnPronostico unPronostico : pronosticos.getPronosticos()){
            
            //determina cual es el partido jugado correspondiente a este pronostico de un partido
            PartidoJugado partidoJugadoCorresp = this.determinarPartJugadoCorrespondiente(unPronostico); 
            
            //determina puntaje correspondiente a este pronostico
            //System.out.println("puntos un partido: " + partidoJugadoCorresp.evalPronUnPartido(unPronostico)); 
            
            puntaje += partidoJugadoCorresp.evalPronUnPartido(unPronostico);
        }
        return puntaje;
    }
    
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the partidos
     */
    public ArrayList<PartidoJugado> getPartidos() {
        return partidos;
    }

    /**
     * @param partidos the partidos to set
     */
    public void setPartidos(ArrayList<PartidoJugado> partidos) {
        this.partidos = partidos;
    }
}

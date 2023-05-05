/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class Participantes {
    
    private ArrayList<UnParticipante> participantes;
    
    public Participantes (String ruta) {
        participantes = new ArrayList(); //inicializa para poder recorrer con for, aun vacio.
            //lee contenido del archivo de pronosticos. En Etapa 1 estaba en clase Pronosticos
        this.leerPronosticos(ruta);
    }
        
        
        //Se supone que el orden de los distintos campos (columnas) en cada resultado de partidos y de pronósticos es fijo y no variará nunca y que la primera fila son titulos.
    public void leerPronosticos(String ruta){
        
        LectorArchivos lectorArchivos = new LectorArchivos();
        
        ArrayList<String[]> renglonesParseados;
        //lee todos los pronosticos de todos los participantes
        renglonesParseados = lectorArchivos.leerArchivo(ruta);

        String idParticipante;
        String nombreParticipante;
        UnParticipante participante;
        UnPronostico pronostico;
        
        //crea objetos en base a los datos leidos
        //Los partidos son creados antes, cuando se leyeron los resultados de partidos jugados
        
        for (String[] i : renglonesParseados){
            
            //Con los datos leidos de un participante en un renglon, lo obtiene o lo crea si no existe.
            idParticipante = i[0];
            nombreParticipante = i[1];
            
            participante = obtenerOcrearParticipante( idParticipante, nombreParticipante );
            
            pronostico = new UnPronostico( i[4], i[6], i[10], i[7], i[8], i[9] );

            //Se agrega el pronostico a los del participante
            participante.agregarPronostico( pronostico );
        }
        
    }
    
    public UnParticipante obtenerOcrearParticipante( String idParticipante, String nombreParticipante ){
        //no puedo usar ArrayList.contains(idParticipante) porque los elementos en el atributo participantes son de tipo participante, no String id.

        //chequea si existe un participante con esa id
        for ( UnParticipante i : this.participantes){
            if ( i.getId().equals( idParticipante )){
                return i;
            }           
        }
        
        //si no existe, lo crea, lo agrega a participantes y lo retorna
        UnParticipante nuevoParticipante = new UnParticipante( idParticipante, nombreParticipante );
        this.participantes.add( nuevoParticipante );
        System.out.println("nuevo participante: " + nombreParticipante);
        return nuevoParticipante;
    }
    
//    private boolean existeParticipante( String idParticipante ){
//        //no puedo usar ArrayList.contains(idParticipante) porque los elementos en el atributo participantes son de tipo participante, no String id.
//        boolean existe = false;
//        
//        for ( UnParticipante i : this.participantes){
//            if ( i.getId().equals( idParticipante )){
//                existe = true;
//                break;
//            }           
//        }
//        
//        return existe;
//    }

    /**
     * @return the participantes
     */
    public ArrayList<UnParticipante> getParticipantes() {
        return participantes;
    }

    /**
     * @param participantes the participantes to set
     */
    public void setParticipantes(ArrayList<UnParticipante> participantes) {
        this.participantes = participantes;
    }

    
}

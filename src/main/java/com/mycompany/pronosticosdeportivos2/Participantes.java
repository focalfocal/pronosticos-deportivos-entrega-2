package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
import java.util.Collections; // para sort de ArrayList

/**
 *
 * @author jul
 */
public class Participantes {
    
    private ArrayList<UnParticipante> participantes;
    private Rondas ronda;
    private ArrayList<ArrayList<Object>> participantesYpuntajes; //auxiliar para acumular y ordenar informacion a imprimir
    
    public Participantes (String ruta, Rondas ronda) {
        participantes = new ArrayList(); //inicializa para poder recorrer con for, aun vacio.
            //lee contenido del archivo de pronosticos. En Etapa 1 estaba en clase Pronosticos
        this.leerPronosticos(ruta);
        
        this.ronda = ronda;
        //participantesYpuntajes se inicializa cada vez que se usa su metodo asociado
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

        return nuevoParticipante;
    }
    
    public void evaluarPronosticosParticipantes (){
        
        for (UnParticipante unParticipante : this.participantes){

            unParticipante.evaluarPronosticos(this.ronda);
        }
    }
    
    public void imprimirParticipantesYpuntajes (){
        
        //acumula los datos para ordenarlos antes de imprimirlos
        
        //borra lo que hubiera anteriormente, e inicializa para poder agregar elementos
        this.participantesYpuntajes = new ArrayList<>();
        
        for (UnParticipante unParticipante : this.participantes){

            unParticipante.agregarPuntaje (participantesYpuntajes);
        }
        
        //ordena
        Collections.sort(participantesYpuntajes, new PuntajeComparator());
        
        //imprime
        for (UnParticipante unParticipante : this.participantes){

            unParticipante.imprimirDatos (participantesYpuntajes);
        }
    } 
    
    
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

    /**
     * @return the participantesYpuntajes
     */
    public ArrayList<ArrayList<Object>> getParticipantesYpuntajes() {
        return participantesYpuntajes;
    }

    /**
     * @param participantesYpuntajes the participantesYpuntajes to set
     */
    public void setParticipantesYpuntajes(ArrayList<ArrayList<Object>> participantesYpuntajes) {
        this.participantesYpuntajes = participantesYpuntajes;
    }

    
}

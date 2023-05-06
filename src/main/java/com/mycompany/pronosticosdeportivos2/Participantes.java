package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
import java.util.Collections; // para sort de ArrayList
import java.util.Comparator; // para sort de ArrayList

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
        //System.out.println("nuevo participante: " + nombreParticipante);
        return nuevoParticipante;
    }
    
    public void evaluarPronosticosParticipantes (){
        
        for (UnParticipante unParticipante : this.participantes){
            //evaluarPronosticosUnParticipante ( unParticipante );
            unParticipante.evaluarPronosticos(this.ronda);
        }
    }
    
    public void imprimirParticipantesYpuntajes (){
        
        //acumula los datos para ordenarlos antes de imprimirlos
        //String[][] participantesYpuntajes = new String();
        
        //borra lo que hubiera anteriormente, e inicializa para poder agregar elementos
        this.participantesYpuntajes = new ArrayList<>();
        
        for (UnParticipante unParticipante : this.participantes){
            //evaluarPronosticosUnParticipante ( unParticipante );
            unParticipante.agregarPuntaje (participantesYpuntajes);
        }
        
        //ordena
        //Collections.sort(participantesYpuntajes, puntajeComparator);
        Collections.sort(participantesYpuntajes, new PuntajeComparator());
        
        //imprime
        for (UnParticipante unParticipante : this.participantes){
            //evaluarPronosticosUnParticipante ( unParticipante );
            unParticipante.imprimirDatos (participantesYpuntajes);
        }
    } 
    
//    Comparator<ArrayList<Object>> puntajeComparator = new Comparator<ArrayList<Object>>() {
//        @Override //To sort an ArrayList using Comparator we need to override the compare() method provided by comparator interface
//        public int compare(ArrayList<Object> datosParticipante1, ArrayList<Object> datosParticipante2) {
//
//            int puntaje1 = (int) datosParticipante1.get(1); //uso (int) porque el puntaje est
//            int puntaje2 = (int) datosParticipante2.get(1);
//
//            return Integer.compare(puntaje1, puntaje2);
//        }
//    };
    
    //public int evaluarPronosticos (Pronosticos pronosticos){
//    public int evaluarPronosticosUnParticipante (UnParticipante unParticipante){
//        
//        int puntaje = 0;
//        int acertados = 0;
//        
//        //unPronostico es el de un solo partido
//        //for (UnPronostico unPronostico : pronosticos.getPronosticos()){
//        for (UnPronostico unPronostico : unParticipante.){
//            
//            //determina cual es el partido jugado correspondiente a este pronostico de un partido
//            PartidoJugado partidoJugadoCorresp = this.determinarPartJugadoCorrespondiente(unPronostico); 
//            
//            //determina puntaje correspondiente a este pronostico
//            //System.out.println("puntos un partido: " + partidoJugadoCorresp.evalPronUnPartido(unPronostico)); 
//            
//            puntaje += partidoJugadoCorresp.evalPronUnPartido(unPronostico);
//        }
//        return puntaje;
//    }

    
    //Dado un pronostico, determina cual es el partido jugado (con correspondencia de ronda y equipos)
//    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico){
//        
//        // ids de ronda + ids de equipos
//        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaRondaEquipos();
//        
//        for (PartidoJugado partido : this.ronda.getPartidos() ){
// 
//            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
//                return partido;
//            }
//        }
//        
//        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
//        System.exit(4);
//        return new PartidoJugado(); //formalidad para cumplir sintaxis de metodo.
//    } 

//public PronosticosDeportivos2.ResultadoEnum resultado ( Equipo equipo ){
//        if( equipo.getNombre() == this.equipo1.getNombre() ){
//            return resultadoEquipo1;
//        } else {
//            return resultadoEquipo2;
//        }
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

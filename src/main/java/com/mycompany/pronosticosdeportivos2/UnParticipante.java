package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 * @author jul
 */
public class UnParticipante {
    
    private String id;
    private String nombre;
    private ArrayList<UnPronostico> pronosticos; //cada participante tiene todos sus pronosticos
    private int puntaje;
    private int acertados;
    
    public UnParticipante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pronosticos = new ArrayList();  //inicializacion para poder agregar elementos aun estando vacio
        this.puntaje = 0;
        this.acertados = 0;
    }

    public void agregarPronostico (UnPronostico pronostico){
        this.pronosticos.add(pronostico);
    }
    
    //Calcula puntajes de todos los pronosticos de un participante
    public void evaluarPronosticos( Rondas rondas ){
        
        //unPronostico es el de un solo partido
        for (UnPronostico unPronostico : this.pronosticos){
            
            //determina cual es el partido jugado correspondiente a este pronostico de un partido
            PartidoJugado partidoJugadoCorresp = this.determinarPartJugadoCorrespondiente(unPronostico, rondas); 
            
            //determina puntaje correspondiente a este pronostico        
            int[] puntosEtc = partidoJugadoCorresp.evalPronUnPartido(unPronostico);
            
            //this.puntaje += partidoJugadoCorresp.evalPronUnPartido(unPronostico);
            this.puntaje += puntosEtc[0];
            this.acertados += puntosEtc[1];
        }
        //return puntaje;
    }

    
    //Dado un pronostico, determina cual es el partido jugado (con correspondencia de ronda y equipos)
    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico, Rondas rondas){
        
        // ids de ronda + ids de equipos
        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaRondaEquipos();
        
        //for (PartidoJugado partido : this.ronda.getPartidos() ){
        for (PartidoJugado partido : rondas.getPartidos() ){
 
            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
                return partido;
            }
        }
        
        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
        System.exit(4);
        return new PartidoJugado(); //formalidad para cumplir sintaxis de metodo.
    } 

//public PronosticosDeportivos2.ResultadoEnum resultado ( Equipo equipo ){
//        if( equipo.getNombre() == this.equipo1.getNombre() ){
//            return resultadoEquipo1;
//        } else {
//            return resultadoEquipo2;
//        }
//    }
    
    public void agregarPuntaje (ArrayList<ArrayList<Object>> participantesYpuntajes) {
        //participantesYpuntajes.add(new ArrayList<>(Arrays.asList("Alice", 10)));
        //participantesYpuntajes.add(new ArrayList<>(Arrays.asList("Alice", 10)));
        ArrayList<Object> datosParticipante = new ArrayList<>();
        datosParticipante.add(this.nombre);
        datosParticipante.add(this.puntaje);
        datosParticipante.add(this.acertados);
        
        participantesYpuntajes.add(datosParticipante);  
    }
    
    
    public void imprimirDatos (ArrayList<ArrayList<Object>> participantesYpuntajes) {
        System.out.println(this.nombre + ": \t" + this.puntaje + "\t"  + this.acertados);
    }
    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the acertados
     */
    public int getAcertados() {
        return acertados;
    }

    /**
     * @param acertados the acertados to set
     */
    public void setAcertados(int acertados) {
        this.acertados = acertados;
    }
    
}

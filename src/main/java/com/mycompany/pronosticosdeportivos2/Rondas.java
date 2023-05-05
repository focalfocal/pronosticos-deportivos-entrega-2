package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
import java.util.Optional; //contenedor de objetos que pueden existir o no, para evitar null pointer exceptions si se intenta acceder a un objeto que no existe

/**
 *
 * @author jul
 */
public class Rondas {
    
    //El atributo partidos incluye los partidos jugados de todas las rondas (cada partido incluye el id  y numero de ronda). Ver suposición registrada en PronostiosDeportivos2.java
    private ArrayList<PartidoJugado> partidos;
    //El atributo idEquiposCreados es un auxiliar para facilitar las búsquedas por id para ver si un equipo con ese id ya existe.
    //private String[] idEquiposCreados;
    //El atributo equipos contiene los equipos creados.
    private ArrayList<Equipo> equipos;
    
    Rondas ( String ruta ){
        //this.idEquiposCreados = null; //contiene solo el id de cada instancia de objeto creada, para facilitar chequear si un equipo ya existe
        this.equipos = null;
        //this.partidos = new ArrayList();
        this.partidos = null;
        //lee contenido del archivo poblando this.partidos
        this.leerRondas( ruta );
    }
            
    //Lee todos los datos de partidos jugados y crea los objetos correspondientes
    //Se supone que el orden de las distintas columnas (campos) en cada resultado de partidos y de pronósticos es fijo y no variará nunca y que la primera fila son titulos.
    public void leerRondas(String ruta){
        
        LectorArchivos lectorArchivos = new LectorArchivos();
        
        ArrayList<String[]> renglonesParseados;
        renglonesParseados = lectorArchivos.leerArchivo(ruta);
        
        Equipo equipo1;
        Equipo equipo2;
        
        for (String[] i : renglonesParseados){
            //Nota para etapa 2: los equipos se crean solo en ronda 1. En rondas siguientes, se obtienen y buscan los existentes para crear el partido.
            //equipo1 = new Equipo(i[4], i[5], i[6]);
            //equipo2 = new Equipo(i[9], i[10], i[11]);
            
            //crea equipo si no existe, y lo agrega al atributo equipos
            crearEquipoSiNoExiste(i[4], i[5], i[6]); //equipo1
            crearEquipoSiNoExiste(i[9], i[10], i[11]); //equipo2
            
            
            //PartidoJugado partidoJugado = new PartidoJugado(i[0], i[1], equipo1, equipo2,Integer.parseInt(i[5]),Integer.parseInt(i[6]));
            //En etapa 1 un partido contenía los equipos. Ahora solo tiene el id del equipo.
            PartidoJugado partidoJugado = new PartidoJugado(i[0], i[1], i[4], i[9],Integer.parseInt(i[5]),Integer.parseInt(i[6]));
            
            this.partidos.add(partidoJugado);
        }
        
    }
    
        //Si el equipo con este id no existe, lo crea
    public void crearEquipoSiNoExiste ( String idEquipo, String nombre, String descripcion ){

        Optional<Equipo> equipoExistenteOno = this.equipos.stream()
                .filter(p -> p.getId().equals(idEquipo))
                .findFirst();

        //crea equipo y lo agrega a lista de equipos
        if ( !equipoExistenteOno.isPresent() ){
            Equipo equipo = new Equipo( idEquipo, nombre, descripcion );
            this.equipos.add(equipo);
        }
    }

//    //Encuentra y devuelve un equipo si existe, o lo crea y lo devuelve si no existe
//    public Equipo obtenerOcrearEquipo ( String idEquipo, String nombre, String descripcion ){
//
////        //chequea si existe un equipo con esa id
////        for ( String i : this.idEquiposCreados){
////            if ( i.equals( idEquipo )){
////                return i; ####NO / CREAR LISTA DE EQUIPOS EN LUGAR DE LISTA DE ID DE EQUIPOS
////            }           
////        }
////        
////        //si no existe, lo crea, lo agrega a participantes y lo retorna
////        UnParticipante nuevoParticipante = new UnParticipante( idParticipante, nombreParticipante );
////        this.participantes.add( nuevoParticipante );
////        return nuevoParticipante;
//        
//        // encuentra el equipo con esta id, si existe. Si no lo encuentra, no hay null pointer exceptions. //Java 8
//        Optional<Equipo> equipoExistenteOno = this.equipos.stream()
//                .filter(p -> p.getId().equals(idEquipo))
//                .findFirst();
//
//        if ( equipoExistenteOno.isPresent() ){
//            return equipoExistenteOno.get(); //Optional<> es un contenedor
//        } else {
//            Equipo equipo = new Equipo( idEquipo, nombre, descripcion );
//            this.equipos.add(equipo);
//            return equipo;
//        }


        
        
    
//    public boolean existeEquipo(String idBuscada){
//        // encuentra el equipo con esta id, si existe. Si no lo encuentra, no hay null pointer exceptions.
//        Optional<Equipo> equipo = this.equipos.stream()
//                .filter(p -> p.getId().equals(idBuscada))
//                .findFirst();
//
//        return equipo.isPresent();
//    }

    //Dado un pronostico, determina cual es el partido jugado en esta ronda cuyos equipos coinciden
    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico){
        
        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaRondaEquipos();
        
        for (PartidoJugado partido : this.partidos ){
 
            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
                return partido;
            }
        }
        
        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
        System.exit(1);
        return new PartidoJugado(); //formalidad para cumplir sintaxis de metodo.
    } 
    
//####PENDIENTE ACTUALIZAR LOS SIGUIENTES METODOS    
//    public int evaluarPronosticos (Pronosticos pronosticos){
//        int puntaje = 0;
//        
//        for (UnPronostico unPronostico : pronosticos.getPronosticos()){
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

//public PronosticosDeportivos2.ResultadoEnum resultado(Equipo equipo){
//        if( equipo.getNombre() == this.equipo1.getNombre() ){
//            return resultadoEquipo1;
//        } else {
//            return resultadoEquipo2;
//        }
//    }

    @Override
    public String toString() {
        return "Rondas{" + "partidos=" + partidos + ", equipos=" + equipos + '}';
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

    /**
     * @return the equipos
     */
    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    /**
     * @param equipos the equipos to set
     */
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }

}

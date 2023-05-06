package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;
import java.util.Optional; //contenedor de objetos que pueden existir o no, para evitar null pointer exceptions si se intenta acceder a un objeto que no existe

/**
 *
 * @author jul
 */
public class Rondas {
    
    private static final int NRO_CAMPOS = 12; //cantidad de campos en archivo de resultados
    
    //El atributo partidos incluye los partidos jugados de todas las rondas (cada partido incluye el id  y numero de ronda). Ver suposición registrada en PronostiosDeportivos2.java
    private ArrayList<PartidoJugado> partidos;
    //El atributo idEquiposCreados es un auxiliar para facilitar las búsquedas por id para ver si un equipo con ese id ya existe.
    //private String[] idEquiposCreados;
    //El atributo equipos contiene los equipos creados.
    private ArrayList<Equipo> equipos;
    
    Rondas ( String ruta ){
        //this.idEquiposCreados = null; //contiene solo el id de cada instancia de objeto creada, para facilitar chequear si un equipo ya existe
        this.equipos = new ArrayList();
        this.partidos = new ArrayList();
        //lee contenido del archivo poblando this.partidos
        this.leerRondas( ruta );
    }
    
    //Constructor para faciltar los tests con jUnit
    Rondas () {
        this.equipos = new ArrayList();
        this.partidos = new ArrayList();
    }
            
    //Lee todos los datos de partidos jugados y crea los objetos correspondientes
    //Se supone que el orden de las distintas columnas (campos) en cada resultado de partidos y de pronósticos es fijo y no variará nunca y que la primera fila son titulos.
    public void leerRondas(String ruta){
        
        LectorArchivos lectorArchivos = new LectorArchivos();
        
        ArrayList<String[]> renglonesParseados;
        renglonesParseados = lectorArchivos.leerArchivo(ruta);
        
        Equipo equipo1;
        Equipo equipo2;
        int golesEquipo1;
        int golesEquipo2;
        int contador = 2; //contador de renglones. Fila 1: titulos
        
        for (String[] i : renglonesParseados){
        
            //chequeo de que cada linea tenga la cantidad correcta de campos
            if ( i.length != NRO_CAMPOS) {
                System.err.println( "La fila numero " + contador + " del archivo de resultados tiene " + i.length +" campos. Deberia tener " + NRO_CAMPOS + " campos");
                System.err.println( "Revisar el origen del problema");
                
                System.exit(2);
            }
            
            try{
                
                golesEquipo1 = Integer.parseInt(i[7]);
                golesEquipo2 = Integer.parseInt(i[8]);
                
                //crea equipo si no existe, y lo agrega al atributo equipos
                crearEquipoSiNoExiste(i[4], i[5], i[6]); //equipo1
                crearEquipoSiNoExiste(i[9], i[10], i[11]); //equipo2

                //En etapa 1 un partido contenía los equipos. Ahora solo tiene el id del equipo.
                PartidoJugado partidoJugado = new PartidoJugado(i[2], i[3], i[4], i[9], golesEquipo1, golesEquipo2);

                this.partidos.add(partidoJugado);
                
            } catch (NumberFormatException e) {
                
                System.err.println( "La fila numero " + contador + " del archivo de resultados tiene alguna de sus cantidades de goles con formato que no es un entero, u otra anormalidad:");
                System.err.println( "Goles Equipo1: " + i[7]);
                System.err.println( "Goles Equipo2: " + i[8]);
                
                System.exit(2);
            }
            
            contador++;
            
        }
        
    }
    
        //Si el equipo con este id no existe, lo crea
    public void crearEquipoSiNoExiste ( String idEquipo, String nombre, String descripcion ){

        System.out.println("idEquipo: " + idEquipo);
        Optional<Equipo> equipoExistenteOno = this.equipos.stream().filter(p -> p.getId().equals(idEquipo)).findFirst();
//                .filter(p -> p.getId().equals(idEquipo))
//                .findFirst();

        //crea equipo y lo agrega a lista de equipos
        if ( !equipoExistenteOno.isPresent() ){
            Equipo equipo = new Equipo( idEquipo, nombre, descripcion );
            this.equipos.add(equipo);
        }
    }


    //Dado un pronostico, determina cual es el partido jugado en esta ronda cuyos equipos coinciden
    public PartidoJugado determinarPartJugadoCorrespondiente (UnPronostico unPronostico){
        
        String idCombinadaEquiposPronost = unPronostico.getIdCombinadaRondaEquipos();
        
        for (PartidoJugado partido : this.partidos ){
 
            if ( partido.getIdCombinadaEquipos().equals( idCombinadaEquiposPronost)) {
                return partido;
            }
        }
        
        System.err.println ("No encontrado partido jugado correspondiente a un pronostico. Error de datos o de programa de procesamiento");
        System.exit(3);
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

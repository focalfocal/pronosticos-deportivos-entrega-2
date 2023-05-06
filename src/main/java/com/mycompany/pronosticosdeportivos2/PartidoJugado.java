package com.mycompany.pronosticosdeportivos2;

import com.mycompany.pronosticosdeportivos2.PronosticosDeportivos2.ResultadoEnum;

/**
 *
 * @author jul
 */
public class PartidoJugado {

    private String idCombinadaEquipos; //Para identificar los partidos de forma unívoca para su correcto procesamiento, y matchearlos con los pronósticos
    private String idRonda; // agregado campo para Entrega 2
    private String numRonda; // agregado campo para Entrega 2
    private String idEquipo1;
    private String idEquipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private ResultadoEnum resultadoEquipo1;
    private ResultadoEnum resultadoEquipo2;

    PartidoJugado(){} //usado para cumplir facilmente una necesidad de sintaxis obligatoria en otra parte del código. Sin otro uso.
    
    PartidoJugado(String idRonda, String numRonda, String idEquipo1, String idEquipo2, int golesEquipo1, int golesEquipo2){
        this.idCombinadaEquipos = idRonda + "+" + idEquipo1 + "+" + idEquipo2;
        this.idRonda = idRonda;
        this.numRonda = numRonda;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        
        if( golesEquipo1 == golesEquipo2 ){
            this.resultadoEquipo1= ResultadoEnum.EMPATADO;
            this.resultadoEquipo2= ResultadoEnum.EMPATADO;
            } else if  (golesEquipo1 > golesEquipo2){
                this.resultadoEquipo1= ResultadoEnum.GANADO;
                this.resultadoEquipo2= ResultadoEnum.PERDIDO;
            } else{  
                this.resultadoEquipo1= ResultadoEnum.PERDIDO;
                this.resultadoEquipo2= ResultadoEnum.GANADO;
            }

        }
    
//    public ResultadoEnum resultado(Equipo equipo){
//        if( equipo.getNombre() == this.equipo1.getNombre() ){
//            return resultadoEquipo1;
//        } else {
//            return resultadoEquipo2;
//        }
//    }
    
    //Dado el id de un equipo en este partido, retorna el resultado correspondiente del partido
    public ResultadoEnum resultado(String idEquipo){
        if( idEquipo.equals(this.idEquipo1 ) ){
            return resultadoEquipo1;
        } else {
            return resultadoEquipo2;
        }
    }

    //Determina la cantidad de puntos y aciertos que corresponden comparando un partido jugado con un pronostico.
    public int[] evalPronUnPartido (UnPronostico unPronostico){

        //return (this.getResultadoEquipo1() == unPronostico.getPronosticoEquipo1()) ? 1 : 0;
        int[] puntosEtc = new int[2];
        
        //puntaje
        puntosEtc[0] = (this.getResultadoEquipo1() == unPronostico.getPronosticoEquipo1()) ? 1 : 0;
        //cantidad de aciertos
        puntosEtc[1] = (this.getResultadoEquipo1() == unPronostico.getPronosticoEquipo1()) ? 1 : 0;
        return puntosEtc;
    }

    @Override
    public String toString() {
        return "PartidoJugado{" + "idCombinadaEquipos=" + idCombinadaEquipos + ", idRonda=" + idRonda + ", numRonda=" + numRonda + ", id equipo1=" + idEquipo1 + ", id equipo2=" + idEquipo2 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + ", resultadoEquipo1=" + resultadoEquipo1 + ", resultadoEquipo2=" + resultadoEquipo2 + '}';
    }
    
    
    /**
     * @return the idCombinadaEquipos
     */
    public String getIdCombinadaEquipos() {
        return idCombinadaEquipos;
    }

    /**
     * @param idCombinadaEquipos the idCombinadaEquipos to set
     */
    public void setIdCombinadaEquipos(String idCombinadaEquipos) {
        this.idCombinadaEquipos = idCombinadaEquipos;
    }

     /**
     * @return the golesEquipo1
     */
    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    /**
     * @return the idEquipo1
     */
    public String getIdEquipo1() {
        return idEquipo1;
    }

    /**
     * @param idEquipo1 the idEquipo1 to set
     */
    public void setIdEquipo1(String idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    /**
     * @return the idEquipo2
     */
    public String getIdEquipo2() {
        return idEquipo2;
    }

    /**
     * @param idEquipo2 the idEquipo2 to set
     */
    public void setIdEquipo2(String idEquipo2) {
        this.idEquipo2 = idEquipo2;
    }

    /**
     * @param golesEquipo1 the golesEquipo1 to set
     */
    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    /**
     * @return the golesEquipo2
     */
    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    /**
     * @param golesEquipo2 the golesEquipo2 to set
     */
    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    /**
     * @return the resultadoEquipo1
     */
    public ResultadoEnum getResultadoEquipo1() {
        return resultadoEquipo1;
    }

    /**
     * @param resultadoEquipo1 the resultadoEquipo1 to set
     */
    public void setResultadoEquipo1(ResultadoEnum resultadoEquipo1) {
        this.resultadoEquipo1 = resultadoEquipo1;
    }

    /**
     * @return the resultadoEquipo2
     */
    public ResultadoEnum getResultadoEquipo2() {
        return resultadoEquipo2;
    }

    /**
     * @param resultadoEquipo2 the resultadoEquipo2 to set
     */
    public void setResultadoEquipo2(ResultadoEnum resultadoEquipo2) {
        this.resultadoEquipo2 = resultadoEquipo2;
    }

    /**
     * @return the idRonda
     */
    public String getIdRonda() {
        return idRonda;
    }

    /**
     * @param idRonda the idRonda to set
     */
    public void setIdRonda(String idRonda) {
        this.idRonda = idRonda;
    }

    /**
     * @return the numRonda
     */
    public String getNumRonda() {
        return numRonda;
    }

    /**
     * @param numRonda the numRonda to set
     */
    public void setNumRonda(String numRonda) {
        this.numRonda = numRonda;
    }
    
    
}

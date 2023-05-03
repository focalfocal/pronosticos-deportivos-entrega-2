package com.mycompany.pronosticosdeportivos1;

import com.mycompany.pronosticosdeportivos1.PronosticosDeportivos2.ResultadoEnum;

/**
 *
 * @author jul
 */
public class PartidoJugado {
    private String idCombinadaEquipos; //Para identificar los partidos de forma unívoca para su correcto procesamiento, y matchearlos con los pronósticos
    private Equipo equipo1;
    private Equipo equipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private ResultadoEnum resultadoEquipo1;
    private ResultadoEnum resultadoEquipo2;

    PartidoJugado(){} //usado para cumplir facilmente una necesidad de sintaxis obligatoria en otra parte del código. Sin otro uso.
    
    PartidoJugado(Equipo equipo1, Equipo equipo2, int golesEquipo1, int golesEquipo2){
        this.idCombinadaEquipos = equipo1.getId() + "+" + equipo2.getId();
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
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
    
    public ResultadoEnum resultado(Equipo equipo){
        if( equipo.getNombre() == this.equipo1.getNombre() ){
            return resultadoEquipo1;
        } else {
            return resultadoEquipo2;
        }
    }

    //Determina la cantidad de puntos que corresponden comparando un partido jugado con un pronostico.
    public int evalPronUnPartido (UnPronostico unPronostico){

        return (this.getResultadoEquipo1() == unPronostico.getPronosticoEquipo1()) ? 1 : 0;
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
     * @return the equipo1
     */
    public Equipo getEquipo1() {
        return equipo1;
    }

    /**
     * @param equipo1 the equipo1 to set
     */
    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    /**
     * @return the equipo2
     */
    public Equipo getEquipo2() {
        return equipo2;
    }

    /**
     * @param equipo2 the equipo2 to set
     */
    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    /**
     * @return the golesEquipo1
     */
    public int getGolesEquipo1() {
        return golesEquipo1;
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

    
}

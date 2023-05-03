package com.mycompany.pronosticosdeportivos2;

import com.mycompany.pronosticosdeportivos2.PronosticosDeportivos2.ResultadoEnum;

/**
 *
 * @author jul
 */
public class UnPronostico {
    
    private String idCombinadaEquipos; //Para identificar los partidos de forma unívoca para su correcto procesamiento
    private String idEquipo1;
    private String idEquipo2;
    private PronosticosDeportivos2.ResultadoEnum pronosticoEquipo1; //Los resultados del equipo 2 se deducen inmediatamente en base al pronostico para equipo1
    
    UnPronostico (String idEquipo1, String idEquipo2, String gana, String empata, String pierde){
        this.idCombinadaEquipos = idEquipo1 + "+" + idEquipo2;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        if (gana.equals("X")){
            this.pronosticoEquipo1 = ResultadoEnum.GANADO;
        } else if (empata.equals("X")){
            this.pronosticoEquipo1 = ResultadoEnum.EMPATADO;
        } else {
            this.pronosticoEquipo1 = ResultadoEnum.PERDIDO;
        }
        /*System.out.println(this.idCombinadaEquipos);
        System.out.println(gana +" | " + empata + " | " + pierde);
        System.out.println(this.pronosticoEquipo1);*/
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
     * @return the pronosticoEquipo1
     */
    public PronosticosDeportivos2.ResultadoEnum getPronosticoEquipo1() {
        return pronosticoEquipo1;
    }

    /**
     * @param pronosticoEquipo1 the pronosticoEquipo1 to set
     */
    public void setPronosticoEquipo1(PronosticosDeportivos2.ResultadoEnum pronosticoEquipo1) {
        this.pronosticoEquipo1 = pronosticoEquipo1;
    }

 

}

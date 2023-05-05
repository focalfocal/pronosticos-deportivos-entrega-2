package com.mycompany.pronosticosdeportivos2;

import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class UnParticipante {
    
    private String id;
    private String nombre;
    private ArrayList<UnPronostico> pronosticos; //cada participante tiene todos sus pronosticos
    
    public UnParticipante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.pronosticos = null;  //inicializacion con valor conocido
    }

    public void agregarPronostico (UnPronostico pronostico){
        this.pronosticos.add(pronostico);
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
    
}

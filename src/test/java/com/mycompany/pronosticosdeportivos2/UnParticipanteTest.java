package com.mycompany.pronosticosdeportivos2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author jul
 */
public class UnParticipanteTest {
    
    Rondas rondas;
    UnParticipante unParticipante;
    
    
    public UnParticipanteTest() {
    }
    
    @Before
    public void setUp() {
        //usa construtor vacio, que tiene los atributos pero que no lee de archivo
        this.rondas = new Rondas();
        
        Equipo equipo1 = new Equipo( "3", "Japon", "Seleccion");
        Equipo equipo2 = new Equipo( "4", "Togo", "Seleccion");
        ArrayList<Equipo> equipos = new ArrayList();
        equipos.add(equipo1);
        equipos.add(equipo2);
        this.rondas.setEquipos(equipos);
        
        PartidoJugado partidoJugado = new PartidoJugado("2", "2", "3", "4", 7, 0);
        ArrayList<PartidoJugado> partidos = new ArrayList();
        partidos.add(partidoJugado);
        this.rondas.setPartidos(partidos); 
        
        //.............................................................
        this.unParticipante = new UnParticipante ( "8", "Daniel");
        
//        UnPronostico pronostico = new UnPronostico ("2", "3", "4", "X", "", "");
//        unParticipante.agregarPronostico (pronostico);
        
        
    }

    /**
     * Test of evaluarPronosticos method, of class UnParticipante.
     */
    @Test
    public void testEvaluarPronosticosAciertaGanado() {
        
        // nuestro escenario
        UnPronostico pronostico = new UnPronostico ("2", "3", "4", "X", "", "");
        unParticipante.agregarPronostico (pronostico);
        
        // Procesar
        unParticipante.evaluarPronosticos( rondas );
        
        // Evaluar
        assertEquals(1, unParticipante.getPuntaje());
        assertEquals(1, unParticipante.getAcertados());
    }

    @Test
    public void testEvaluarPronosticosNoAciertaGanado() {
        
        // nuestro escenario
        UnPronostico pronostico = new UnPronostico ("2", "3", "4", "", "X", "");
        unParticipante.agregarPronostico (pronostico);
        
        // Procesar
        unParticipante.evaluarPronosticos( rondas );
        
        // Evaluar
        assertEquals(0, unParticipante.getPuntaje());
        assertEquals(0, unParticipante.getAcertados());
    }
    
    @Test
    public void testEvaluarPronosticosNoAciertaEmpatado() {
        
        // nuestro escenario
        UnPronostico pronostico = new UnPronostico ("2", "3", "4", "", "X", "");
        unParticipante.agregarPronostico (pronostico);
        
        // Procesar
        unParticipante.evaluarPronosticos( rondas );
        
        // Evaluar
        assertEquals(0, unParticipante.getPuntaje());
        assertEquals(0, unParticipante.getAcertados());
    }
}

package com.mycompany.pronosticosdeportivos2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jul
 */
public class PartidoJugadoTest {
    
    private PartidoJugado partidoJugado;
    
    public PartidoJugadoTest() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testPartidoGanadoOperdido() {

            // nuestro escenario
//            this.partidoJugado.setGolesEquipo1(3);
//            this.partidoJugado.setGolesEquipo2(0);
              this.partidoJugado = new PartidoJugado("1", "1", "1", "2", 
                      3, 0);  //Los resultados se calculan en el constructor.

            // Procesar
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido1 = this.partidoJugado.resultado("1");
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido2 = this.partidoJugado.resultado("2");

            // Evaluar
            assertEquals(PronosticosDeportivos2.ResultadoEnum.GANADO, resultadoObtenido1);
            assertEquals(PronosticosDeportivos2.ResultadoEnum.PERDIDO, resultadoObtenido2);

    }
    
    @Test
    public void testPartidoPerdidoOganado() {

            // nuestro escenario
              this.partidoJugado = new PartidoJugado("1", "1", "1", "2", 
                      3, 5);  //Los resultados se calculan en el constructor.

            // Procesar
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido1 = this.partidoJugado.resultado("1");
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido2 = this.partidoJugado.resultado("2");

            // Evaluar
            assertEquals(PronosticosDeportivos2.ResultadoEnum.PERDIDO, resultadoObtenido1);
            assertEquals(PronosticosDeportivos2.ResultadoEnum.GANADO, resultadoObtenido2);

    }
    
    @Test
    public void testPartidoEmpatado() {

            // nuestro escenario

              this.partidoJugado = new PartidoJugado("1", "1", "1", "2", 
                      3, 3);  //Los resultados se calculan en el constructor.

            // Procesar
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido1 = this.partidoJugado.resultado("1");
            PronosticosDeportivos2.ResultadoEnum resultadoObtenido2 = this.partidoJugado.resultado("2");

            // Evaluar
            assertEquals(PronosticosDeportivos2.ResultadoEnum.EMPATADO, resultadoObtenido1);
            assertEquals(PronosticosDeportivos2.ResultadoEnum.EMPATADO, resultadoObtenido2);

    }
    
//    /**
//     * Test of resultado method, of class PartidoJugado.
//     */
//    @Test
//    public void testResultado() {
//        System.out.println("resultado");
//        String idEquipo = "";
//        PartidoJugado instance = new PartidoJugado();
//        PronosticosDeportivos2.ResultadoEnum expResult = null;
//        PronosticosDeportivos2.ResultadoEnum result = instance.resultado(idEquipo);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of evalPronUnPartido method, of class PartidoJugado.
//     */
//    @Test
//    public void testEvalPronUnPartido() {
//        System.out.println("evalPronUnPartido");
//        UnPronostico unPronostico = null;
//        PartidoJugado instance = new PartidoJugado();
//        int[] expResult = null;
//        int[] result = instance.evalPronUnPartido(unPronostico);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class PartidoJugado.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdCombinadaEquipos method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetIdCombinadaEquipos() {
//        System.out.println("getIdCombinadaEquipos");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.getIdCombinadaEquipos();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIdCombinadaEquipos method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetIdCombinadaEquipos() {
//        System.out.println("setIdCombinadaEquipos");
//        String idCombinadaEquipos = "";
//        PartidoJugado instance = new PartidoJugado();
//        instance.setIdCombinadaEquipos(idCombinadaEquipos);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getGolesEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetGolesEquipo1() {
//        System.out.println("getGolesEquipo1");
//        PartidoJugado instance = new PartidoJugado();
//        int expResult = 0;
//        int result = instance.getGolesEquipo1();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetIdEquipo1() {
//        System.out.println("getIdEquipo1");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.getIdEquipo1();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIdEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetIdEquipo1() {
//        System.out.println("setIdEquipo1");
//        String idEquipo1 = "";
//        PartidoJugado instance = new PartidoJugado();
//        instance.setIdEquipo1(idEquipo1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetIdEquipo2() {
//        System.out.println("getIdEquipo2");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.getIdEquipo2();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIdEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetIdEquipo2() {
//        System.out.println("setIdEquipo2");
//        String idEquipo2 = "";
//        PartidoJugado instance = new PartidoJugado();
//        instance.setIdEquipo2(idEquipo2);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setGolesEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetGolesEquipo1() {
//        System.out.println("setGolesEquipo1");
//        int golesEquipo1 = 0;
//        PartidoJugado instance = new PartidoJugado();
//        instance.setGolesEquipo1(golesEquipo1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getGolesEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetGolesEquipo2() {
//        System.out.println("getGolesEquipo2");
//        PartidoJugado instance = new PartidoJugado();
//        int expResult = 0;
//        int result = instance.getGolesEquipo2();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setGolesEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetGolesEquipo2() {
//        System.out.println("setGolesEquipo2");
//        int golesEquipo2 = 0;
//        PartidoJugado instance = new PartidoJugado();
//        instance.setGolesEquipo2(golesEquipo2);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getResultadoEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetResultadoEquipo1() {
//        System.out.println("getResultadoEquipo1");
//        PartidoJugado instance = new PartidoJugado();
//        PronosticosDeportivos2.ResultadoEnum expResult = null;
//        PronosticosDeportivos2.ResultadoEnum result = instance.getResultadoEquipo1();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setResultadoEquipo1 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetResultadoEquipo1() {
//        System.out.println("setResultadoEquipo1");
//        PronosticosDeportivos2.ResultadoEnum resultadoEquipo1 = null;
//        PartidoJugado instance = new PartidoJugado();
//        instance.setResultadoEquipo1(resultadoEquipo1);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getResultadoEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetResultadoEquipo2() {
//        System.out.println("getResultadoEquipo2");
//        PartidoJugado instance = new PartidoJugado();
//        PronosticosDeportivos2.ResultadoEnum expResult = null;
//        PronosticosDeportivos2.ResultadoEnum result = instance.getResultadoEquipo2();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setResultadoEquipo2 method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetResultadoEquipo2() {
//        System.out.println("setResultadoEquipo2");
//        PronosticosDeportivos2.ResultadoEnum resultadoEquipo2 = null;
//        PartidoJugado instance = new PartidoJugado();
//        instance.setResultadoEquipo2(resultadoEquipo2);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdRonda method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetIdRonda() {
//        System.out.println("getIdRonda");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.getIdRonda();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setIdRonda method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetIdRonda() {
//        System.out.println("setIdRonda");
//        String idRonda = "";
//        PartidoJugado instance = new PartidoJugado();
//        instance.setIdRonda(idRonda);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumRonda method, of class PartidoJugado.
//     */
//    @Test
//    public void testGetNumRonda() {
//        System.out.println("getNumRonda");
//        PartidoJugado instance = new PartidoJugado();
//        String expResult = "";
//        String result = instance.getNumRonda();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setNumRonda method, of class PartidoJugado.
//     */
//    @Test
//    public void testSetNumRonda() {
//        System.out.println("setNumRonda");
//        String numRonda = "";
//        PartidoJugado instance = new PartidoJugado();
//        instance.setNumRonda(numRonda);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}

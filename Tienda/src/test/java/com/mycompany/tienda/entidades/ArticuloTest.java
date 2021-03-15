/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author PORTATIL 2
 */
public class ArticuloTest {
    
    /**
     *
     */
    public ArticuloTest() {
    }

    /**
     * Test of equals method, of class Articulo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Articulo instance = new Articulo();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of disponible method, of class Articulo.
     */
    @Test
    public void testDisponible() {
        System.out.println("disponible");
        int cantidad = 0;
        Articulo instance = new Articulo();
        boolean expResult = false;
        boolean result = instance.disponible(cantidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajustarstock method, of class Articulo.
     */
    @Test
    public void testAjustarstock() {
        System.out.println("ajustarstock");
        int cantidad = 0;
        Articulo instance = new Articulo();
        instance.ajustarstock(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

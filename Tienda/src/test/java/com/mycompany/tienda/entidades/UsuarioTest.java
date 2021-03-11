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
public class UsuarioTest {
    
    public UsuarioTest() {
    }

    /**
     * Test of Compcontrasena method, of class Usuario.
     */
    @Test
    public void testCompcontrasena() {
        String c = "CONTRASENA";
        Usuario carlos = new Usuario("hola", "CONTRASENA", "hola@email.com");
        boolean expResult = true;
        boolean result = carlos.Compcontrasena(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of Compnombre method, of class Usuario.
     */
    @Test
    public void testCompnombre() {
        String n = "hola";
        Usuario carlos = new Usuario("hola", "CONTRASENA", "hola@email.com");
        boolean expResult = false;
        boolean result = carlos.Compnombre(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of Compemail method, of class Usuario.
     */
    @Test
    public void testCompemail() {
        String e = "hola@email.com";
        Usuario carlos = new Usuario("hola", "CONTRASENA", "hola@email.com");
        String expResult = "true";
        boolean result = carlos.Compemail(e);
        assertEquals(expResult, result);
    }
    
}

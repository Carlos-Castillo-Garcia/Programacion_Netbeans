/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.Tallas;

/**
 *
 * @author PORTATIL 2
 */
public class Ropa extends Articulo {
    String color;
    Tallas talla;
    
    public Ropa(){
    }
    
    public Ropa(String c, Tallas t, String co, String n, float p, int s){
        super(co, n, p, s);
        this.color = c;
        this.talla = t;
    }
    @Override
    public String toString (){
        return super.toString() + "Color: " + color + "\nTalla: " + talla + "\n";
    }
}

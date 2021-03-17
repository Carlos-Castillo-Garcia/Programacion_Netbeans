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
    
    /**
     *
     */
    public Ropa(){
    }
    
    /**
     *
     * @param c
     * @param t
     * @param co
     * @param n
     * @param p
     * @param s
     */
    public Ropa(String c, Tallas t, String co, String n, float p, int s){
        super(co, n, p, s);
        this.color = c;
        this.talla = t;
    }

    /**
     * @return the talla
     */
    public Tallas getTalla() {
        return talla;
    }

    public void applypromo(String codprom){
        if(codprom.equals("ROPAPROMO")){
            this.setPrecio(((float)this.getPrecio()*0.8));
        }
    }
    /**
     *
     * @return
     */
    @Override
    public String toString (){
        return super.toString() + "Color: " + color + "\nTalla: " + getTalla() + "\n";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.ClasEn;

/**
 *
 * @author PORTATIL 2
 */
public class Electrodomestico extends Articulo {
    private ClasEn clasificacion;
    private String gama;
    
    public Electrodomestico(){
        
    }
    public Electrodomestico(ClasEn cl, String g, String co, String n, float p, int s){
        super(co, n, p, s);
        this.clasificacion = cl;
        this.gama = g;
    }

    /**
     * @return the clasificacion
     */
    public ClasEn getClasificacion() {
        return clasificacion;
    }

    /**
     * @return the gama
     */
    public String getGama() {
        return gama;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(ClasEn clasificacion) {
        this.clasificacion = clasificacion;
    }

    /**
     * @param gama the gama to set
     */
    public void setGama(String gama) {
        this.gama = gama;
    }

    
    
        @Override
    public String toString (){
        return super.toString() + "Clasificacion energetica: " + clasificacion + "\nGama: " + gama + "\n";
    }
}

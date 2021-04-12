/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.Tipostec;

/**
 *
 * @author PORTATIL 2
 */
public class Tecnologia extends Articulo {
    private Tipostec tpt;
    
    public Tecnologia(){
        
    }
    
    public Tecnologia(String c, String n, float p, int s, Tipostec tpt){
        super(c, n, p, s);
        this.tpt = tpt;
    }

    /**
     * @return the tpt
     */
    public Tipostec getTpt() {
        return tpt;
    }

    public String  toStringFile(){
        return super.getIds() + "," + super.getNombre() + "," + super.getPrecio() + "," + super.getStock() + "," + tpt;
    }
    
    /**
     * @param tpt the tpt to set
     */
    public void setTpt(Tipostec tpt) {
        this.tpt = tpt;
    }

    @Override
    public void applypromo(String codigopromo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

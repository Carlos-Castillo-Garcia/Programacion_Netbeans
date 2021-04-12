/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.Tallas;
import com.mycompany.tienda.interfaces.Reciclable;

/**
 *
 * @author PORTATIL 2
 */
public class Ropa extends Articulo implements Reciclable{
    String color;
    Tallas talla;
    int vezreciclada = 0;
    
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
    public Ropa(String[] valores){
        String color = 
        super(co, n, p, s);
        this.color = valores[0];
        this.talla = t;
    }

    /**
     * @return the talla
     */
    public Tallas getTalla() {
        return talla;
    }

    /**
     *
     * @param codprom
     */
    @Override
    public void applypromo(String codprom){
        if(codprom.equals("ROPAPROMO")){
            this.setPrecio(((float)this.getPrecio()*(float)0.8));
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
    
    public String  toStringFile(){
        return color + "," + talla + "," + super.getIds() + "," + super.getNombre() + "," + super.getPrecio() + "," + super.getStock();
    }

    @Override
    public boolean esReciclable() {
        boolean conf = true;
        if(this.vezreciclada > 2){
            conf = false;
        }else{
            conf = true;
            this.vezreciclada++;
        }
        return conf;
    }

    @Override
    public void applyDiscount() {
        //TODO
        //LA ropa reciclada tiene un 50% de descuento 
        //Ademas de aplicar el descuento modifica el atributo de asido reciclada.
         this.setPrecio((float)this.getPrecio()*(float)0.50);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.ClasEn;
import com.mycompany.tienda.interfaces.Reciclable;

/**
 *
 * @author PORTATIL 2
 * solo es reciclable es si su clase energetica es A o mejor y si su año de fabricacion es posterior a 5 años.
 * Descuento si se recicla es de un 30%.
 */
public class Electrodomestico extends Articulo{
    private ClasEn clasificacion;
    private String gama;
    
    /**
     *
     */
    public Electrodomestico(){
        
    }

    /**
     *
     * @param cl
     * @param g
     * @param co
     * @param n
     * @param p
     * @param s
     */
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

    /**
     *
     * @return
     */
    @Override
    public String toString (){
        return super.toString() + "Clasificacion energetica: " + clasificacion + "\nGama: " + gama + "\n";
    }

    @Override
    public void applypromo(String codprom) {
        if(codprom.equals("SINIVA")){
            this.setPrecio(((float)this.getPrecio()*(float)0.79));
        }
        if(codprom.equals("ELECPROMO")){
            this.setPrecio((float)this.getPrecio()*(float)0.8);
        }
    }

//    @Override
//    public boolean esReciclable() {
//        boolean conf = true;
//        if(this.vezreciclada > 2){
//            conf = false;
//        }else{
//            conf = true;
//            this.vezreciclada++;
//        }
//        return conf;
//    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.ClasEn;
import com.mycompany.tienda.enumerados.Marcas;

/**
 *
 * @author PORTATIL 2
 */
public class Lavadoras extends Electrodomestico {
    private Marcas marca;
    private int potencia;
    private int modos;
    private int volumen;
    private float consumoA;
    
    /**
     *
     */
    public Lavadoras(){
    }
    
    /**
     *
     * @param ma
     * @param p
     * @param mo
     * @param v
     * @param ca
     * @param cl
     * @param g
     * @param co
     * @param n
     * @param pr
     * @param s
     */
    public Lavadoras(Marcas ma, int p, int mo, int v, float ca,ClasEn cl, String g, String co, String n, float pr, int s){
        super(cl, g, co, n, pr, s);
        this.marca = ma;
        this.modos = mo;
        this.potencia = p;
        this.volumen = v;
        this.consumoA = ca;
    }

    /**
     * @return the marca
     */
    public Marcas getMarca() {
        return marca;
    }

    /**
     * @return the potencia
     */
    public int getPotencia() {
        return potencia;
    }

    /**
     * @return the modos
     */
    public int getModos() {
        return modos;
    }

    /**
     * @return the volumen
     */
    public int getVolumen() {
        return volumen;
    }

    /**
     * @return the consumoA
     */
    public float getConsumoA() {
        return consumoA;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marcas marca) {
        this.marca = marca;
    }

    /**
     * @param potencia the potencia to set
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    /**
     * @param modos the modos to set
     */
    public void setModos(int modos) {
        this.modos = modos;
    }

    /**
     * @param volumen the volumen to set
     */
    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    /**
     * @param consumoA the consumoA to set
     */
    public void setConsumoA(float consumoA) {
        this.consumoA = consumoA;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString (){
        return super.toString() + "Marca: "+ marca + "\nPotencia: " + potencia + "\nNumero de Modos: "+ modos+
                "\nCapacidad: "+volumen+" Litros" +"\nConsumo de Litros: " + consumoA + " Litros.";
    }
    
    public String  toStringFile(){
        return marca + "," + potencia + "," + modos + "," + volumen + "," + consumoA + "," 
                + super.getClasificacion() + "," + super.getGama()+ "," 
                + super.getIds() + "," + super.getNombre() + "," + super.getPrecio() + "," + super.getStock();
    }
}

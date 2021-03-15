/**
 * 
 */
package com.mycompany.tienda.entidades;

import java.util.ArrayList;

/**
 * @author PORTATIL 2
 *
 */
public class Articulo {

		private String ids;
		private String nombre;
		private float precio;
		private int stock;
                private ArrayList <Opinion> opiniones;
		
    /**
     *
     */
    public Articulo() {
			
		}
		
    /**
     *
     * @param codigo
     * @param nombre
     * @param precio
     * @param stock
     */
    public Articulo(String codigo, String nombre, float precio, int stock) {
			setIds(codigo);
			setNombre(nombre);
			setPrecio(precio);
			setStock(stock);
			opiniones = new ArrayList <Opinion>();
		}

    /**
     *
     * @return
     */
    public String getIds() {
			return ids;
		}

    /**
     *
     * @return
     */
    public String getNombre() {
			return nombre;
		}

    /**
     *
     * @return
     */
    public float getPrecio() {
			return precio;
		}

    /**
     *
     * @return
     */
    public int getStock() {
			return stock;
                }

    /**
     *
     * @return
     */
    public ArrayList <Opinion> getOpiniones() {
                    return opiniones;
                }
                
    /**
     *
     * @param ids
     */
    public void setIds(String ids) {
			this.ids = ids;
		}

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
			this.nombre = nombre;
		}

    /**
     *
     * @param precio
     */
    public void setPrecio(float precio) {
			this.precio = precio;
		}

    /**
     *
     * @param stock
     */
    public void setStock(int stock) {
			this.stock = stock;
		}
		
    /**
     *
     * @return
     */
    @Override
		public String toString() {
			return "Codigo: " + this.ids 
				   + "\nNombre: " + this.nombre 
				   + "\nPrecio: " + this.precio
				   + "\nStock: " + this.stock + "\n";
		}
 
    /**
     *
     * @param o
     * @return
     */
    @Override 
		public boolean equals(Object o) {
			if(o == null) {
				return false;
			}
			if(this.getClass() != o.getClass()) {
				return false;
			}else {
				Articulo a = (Articulo) o;
				if(this.ids.equals(a.getIds())) {
					return true;
				}else {
					return false;
				}
			}
		}
		
    /**
     *
     * @param cantidad
     * @return
     */
    public boolean disponible(int cantidad) {
			return cantidad <= stock;
		}
		
    /**
     *
     * @param cantidad
     */
    public void ajustarstock(int cantidad) {
			this.stock -= cantidad;
		}
		
}






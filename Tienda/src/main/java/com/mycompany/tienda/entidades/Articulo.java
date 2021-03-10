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
		
		public Articulo() {
			
		}
		
		public Articulo(String codigo, String nombre, float precio, int stock) {
			setIds(codigo);
			setNombre(nombre);
			setPrecio(precio);
			setStock(stock);
			opiniones = new ArrayList <Opinion>();
		}

		public String getIds() {
			return ids;
		}
		public String getNombre() {
			return nombre;
		}
		public float getPrecio() {
			return precio;
		}
		public int getStock() {
			return stock;
                }
                public ArrayList <Opinion> getOpiniones() {
                    return opiniones;
                }
                
		public void setIds(String ids) {
			this.ids = ids;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public void setPrecio(float precio) {
			this.precio = precio;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		@Override
		public String toString() {
			return "Codigo: " + this.ids 
				   + "\nNombre: " + this.nombre 
				   + "\nPrecio: " + this.precio
				   + "\nStock: " + this.stock + "\n";
		}
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
		
		public boolean disponible(int cantidad) {
			return cantidad <= stock;
		}
		
		public void ajustarstock(int cantidad) {
			this.stock -= cantidad;
		}
		
}






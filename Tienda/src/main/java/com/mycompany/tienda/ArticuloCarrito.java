/**
 * 
 */
package com.mycompany.tienda;

import com.mycompany.tienda.entidades.Articulo;

/**
 * @author PORTATIL 2
 *
 */
public class ArticuloCarrito {

		Articulo elemento;
		int cantidad;
		
    /**
     *
     */
    public ArticuloCarrito() {
		}
		
    /**
     *
     * @param elemento
     * @param cantidad
     */
    public ArticuloCarrito(Articulo elemento, int cantidad) {
			this.elemento = elemento;
			this.cantidad = cantidad;
		}
		
    /**
     *
     * @return
     */
    @Override
		public String toString() {
			return this.elemento + "x" + this.cantidad + "\n";
			
		}
}

/**
 * 
 */
package com.mycompany.tienda;

import com.mycompany.tienda.entidades.Articulo;
import java.util.ArrayList;

/**
 * @author PORTATIL 2
 *
 */
public class Carrito {

		ArrayList <ArticuloCarrito> pedido;
		float total;
		boolean estado;
		
    /**
     *
     */
    public static boolean CONFIRMADO = true;

    /**
     *
     */
    public static boolean PENDIENTE = false;
		
    /**
     *
     */
    public Carrito() {
        pedido = new ArrayList <ArticuloCarrito>();
        total = 0;
        estado = PENDIENTE;
    }
    
    private float calculaTotal(String codpromo) {
        float acumulado = 0;

        for(ArticuloCarrito ac: this.pedido) {
            if(ac.elemento.getIds().charAt(0) == 'R'){
                ac.elemento.applypromo(codpromo);
            }else if(ac.elemento.getIds().charAt(0) == 'E'){
                ac.elemento.applypromo(codpromo);
            }else if(ac.elemento.getIds().charAt(0) == 'T'){
                ac.elemento.applypromo(codpromo);
            }
           acumulado = ac.elemento.getPrecio()*ac.cantidad;
        }
        
        return acumulado;
    }

    /**
     *
     * @param articulo
     * @param cantidad
     */
    public void addArticulo(Articulo articulo, int cantidad,String codpromo) {
			boolean found = false;
			
			for(ArticuloCarrito ac : pedido) {
				if(ac.elemento.equals(articulo)) {
					ac.cantidad += cantidad;
					found = true;
				}
			}
			if(!found) {
				ArticuloCarrito nuevo = new ArticuloCarrito(articulo, cantidad);
				pedido.add(nuevo);
			}
			this.total = calculaTotal(codpromo);
		}

    /**
     *
     * @return
     */
    public String mostarcarrito() {
			StringBuilder cs = new StringBuilder();
			
			cs.append("############Articulos del carrito#############\n");
			for(ArticuloCarrito ac: pedido) {
				cs.append(ac);
			}
			cs.append("El precio total es: ").append(total);
			if(estado) {
				cs.append("\nEl carrito esta confirmado.\n");
			}else {
				cs.append("\nEl carrito esta sin confirmar.\n");
			}
			
			cs.append("#####################FIN###################");
			return cs.toString();
		}

    /**
     *
     * @return
     */
    public String confirmacion() {
			estado = CONFIRMADO;
			return "El carrito ha sido confirmado.\n";
		}
}











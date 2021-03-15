/**
 * 
 */
package com.mycompany.tienda;

import com.mycompany.tienda.entidades.Ropa;
import com.mycompany.tienda.entidades.Lavadoras;
import com.mycompany.tienda.entidades.Electrodomestico;
import com.mycompany.tienda.entidades.Articulo;
import com.mycompany.tienda.enumerados.ClasEn;
import com.mycompany.tienda.enumerados.Marcas;
import java.util.ArrayList;
import java.util.Scanner;
import Plantillas.Metodosalir;
import com.mycompany.tienda.entidades.Opinion;
import com.mycompany.tienda.entidades.Usuario;
import com.mycompany.tienda.enumerados.Permisos;
import com.mycompany.tienda.enumerados.Puntuacion;
import com.mycompany.tienda.enumerados.Tallas;

/**
 * @author PORTATIL 2
 *
 */
public class Tienda {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        
        Scanner scstring = new Scanner(System.in);
        Scanner scint = new Scanner(System.in);
        Scanner scopcion = new Scanner(System.in);
        
        int opcion1 = 0;
        int opcion2 = 0;
        int oplike = 0;
        String user;
        String pass;
        Carrito carro = new Carrito();
        Usuario templog = new Usuario();
        Opinion temp = new Opinion();
        ArrayList <Articulo> catalogo = new ArrayList <Articulo>();
        ArrayList <Usuario> regs = new ArrayList <Usuario>();
        regs.add(new Usuario("admin123", "Contrasena1", "admin123@gmail.com"));
        inicializarcatalogo(catalogo);
        
        do {
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Crear cuenta");
            System.out.println("3. Salir del programa");
            opcion1 = scopcion.nextInt();
            switch(opcion1){
                case 1:
                    System.out.println("Introduzca los datos: ");
                    System.out.println("Usuario: ");
                    user = scstring.nextLine();
                    System.out.println("Contraseña: ");
                    pass = scstring.nextLine();
                    
                    if(templog.login(regs, user, pass)){
                        
                        do{
                            System.out.println("Ya esta loggeado.");
                            System.out.println("Esto es el menu de la tienda, tiene diferentes opciones:");
                            System.out.println("1. Añadir un articulo al catalogo");
                            System.out.println("2. Comprar un producto.");
                            System.out.println("3. Comfirmar la compra de los productos.");
                            System.out.println("4. Dar opinion.");
                            System.out.println("5. Salir del la tienda.");
                            opcion2 = scopcion.nextInt();
                            switch(opcion2){
                                case 1:
                                    System.out.println("Has elegido la opcion de añadir un articulo, para ello va a ser necesario insertar ciertos datos: ");
                                    addArticuloCatalogo(catalogo, scstring, scint);
                                    mostrarCatalogo(catalogo);
                                    break;
                                case 2:
                                    System.out.println("Has elegido la opcion de comprar productos, para seleccionar los productos es necesario utilizar"
                                            + " el codigo del producto\n");
                                    comprar(catalogo, carro, scstring, scint);
                                    break;
                                case 3:
                                    System.out.println("Has elegido la opcion de confirmas la compra de productos.\n");
                                    System.out.println(carro.mostarcarrito());
                                    System.out.println("¿Desea confirmar el carrito? (si)(no)");
                                    String sctemp = scstring.nextLine();
                                    if(sctemp.equals("si")) {
                                        System.out.println(carro.confirmacion());
                                        modifstock(catalogo, carro);
                                        mostrarCatalogo(catalogo);
                                    }else{
                                        System.out.println("Si desea seguir comprando marque la opcion 2.\n");
                                    }
                                    break;
                                case 4:
                                    giveop(catalogo, scstring, scopcion);
                                    break;
                                case 5:
                                    System.out.println("Muchas gracias por utilizar esta tienda.");
                                    break;
                                default:
                                    System.out.println("Has introducido la opcion incorrecta, vuelva a introducirla.");
                                    break;
                            }
                        }while(opcion2 != 4);
                    }
                    break;
                case 2:
                    System.out.println("Introduzca los datos para registrarse: ");
                    register(regs, scstring);
                    break;
                case 3:
                    System.out.println("Muchas gracias por utilizar esta tienda.");
            }   
            
        }while(opcion1 != 3);
        scstring.close();
        scint.close();
        scopcion.close();
    }
	private static void inicializarcatalogo(ArrayList <Articulo> c) {
		c.add(new Articulo("0001", "Monitor", 200.00F, 10));
		c.add(new Articulo("0002", "Teclado", 30.00F, 40));
		c.add(new Articulo("0003", "Raton", 25.99F, 100));
		c.add(new Articulo("0004", "RJ45-5M-Cat 6", 10.00F, 25));
                c.add(new Ropa("rojo", Tallas.M, "0005", "jersei", 15.00F, 35));
                c.add(new Electrodomestico(ClasEn.F, "alta", "0006", "lavadora", 200.00F, 35));
                c.add(new Lavadoras(Marcas.Balay, 500, 5, 65, 99.50F, ClasEn.A, "alta", "0007", "lavadora", 200.00F, 35));
	}
	private static void addArticuloCatalogo(ArrayList <Articulo> c, Scanner texto, Scanner ints) {
		System.out.println("Introduce el codigo del articulo:");
		String codigo = texto.nextLine();
		System.out.println("Introduce el nombre del articulo:");
		String nombre  = texto.nextLine();
		System.out.println("Introduce el precio del articulo:");
		float precio = ints.nextFloat();
		System.out.println("Introduce el stock del articulo:");
		int stock = ints.nextInt();
		
		c.add(new Articulo(codigo, nombre, precio, stock));
	}
	private static void mostrarCatalogo(ArrayList <Articulo> c) {
		for (Articulo a : c) {
			System.out.println(a);
		}
	}
	private static void comprar(ArrayList<Articulo> c, Carrito ca, Scanner sctexto,Scanner scint){
		String opsalida = " ";
		Articulo insertar = new Articulo(); 
		mostrarCatalogo(c);
		int m = 0;
		do {
			System.out.println("Introduzca el codigo del producto:");
			String tempcodigo = sctexto.nextLine();
			insertar = buscarporcodigo(c, tempcodigo);
			if(insertar != null) {
				do {
				System.out.println("Introduzca la cantidad del producto que desea comprar: ");
				int tempcantidad = scint.nextInt();
				if(insertar.disponible(tempcantidad)) {
					System.out.println("\nEl articulo se a introducido al carrito.");
					ca.addArticulo(insertar, tempcantidad);
					m = 1;
				}else {
					System.out.println("No hay tantas existencias, porfavor pida una cantidad distinta.");
				}
				}while(m != 1);
			}else {
				System.out.println("El producto no esta en la lista.");
			}
			System.out.println("\n¿Desea salir de comprar y confirmar el pago del carrito?(si)(no)");
			opsalida = Metodosalir.salir(sctexto);
		}while(opsalida.equals("no"));

	}
	private static void modifstock(ArrayList<Articulo> c, Carrito carro) {
		int pos;
		for(ArticuloCarrito ac: carro.pedido) {
			pos = buscarporcodigomod(c, ac.elemento.getIds());
			if(pos >- 1){
				c.get(pos).ajustarstock(-1 * ac.cantidad);
			}
		}
	}
	private static int buscarporcodigomod(ArrayList <Articulo> catalog, String codigo) {
		boolean encontrado = false;
		int largo = catalog.size();
		int i = 0;

		while(i<largo && !(encontrado)){
			if(catalog.get(i).getIds().equals(codigo)){
				encontrado = true;
			}else {
				i++;
			}
		}
		if(encontrado) {
			return i;
		}else {
			return -1;
		}
	}
	private static Articulo buscarporcodigo(ArrayList <Articulo> catalog, String codigo) {
		boolean encontrado = false;
		int largo = catalog.size();
		int i = 0;
		Articulo a = null;
		while(i<largo && !(encontrado)){
			if(catalog.get(i).getIds().equals(codigo)){
				encontrado = true;
				a = catalog.get(i);
			}else {
				i++;
			}
		}
		return a; 
		
	}
        private static void register(ArrayList<Usuario> au, Scanner scstring) {
            Usuario temp = new Usuario();
            boolean usuario = false;
            boolean pass = false;
            boolean email = false;
            int salida = 0;
            do {
                System.out.println("Introduzca el nombre de usuario: ");
                temp.setNombre(scstring.nextLine());
                System.out.println("Introduzca la contraseña: ");
                temp.setPasswd(scstring.nextLine());
                System.out.println("Introduzca el email: ");
                temp.setEmail(scstring.nextLine());
                if (temp.Compnombre(temp.getNombre())) {
                    for (Usuario i : au) {
                        if (i.getNombre().equals(temp.getNombre())) {
                            System.out.println("El nombre de ususario ya esta cogido.");
                            usuario = false;
                            break;
                        } else{
                            usuario = true;
                        }
                    }
                } else {
                    System.out.println("El nombre de ususario no cumple los requisitos.");
                    usuario = false;
                }
                if(usuario == true){
                    if(temp.Compcontrasena(temp.getPasswd())){
                        pass = true;
                    }else{
                        pass = false;
                        System.out.println("La contraseña no cumple con los requisitos.");
                    }
                }                
                if(usuario == true && pass == true){
                    if(temp.Compemail(temp.getEmail())){
                        for(Usuario a: au){
                            if(a.getEmail().equals(temp.getEmail())){
                                System.out.println("El email ya esta registrado.");
                                email = false;
                                break;
                            }else{
                                email = true;
                            }
                        }
                    }else{
                        System.out.println("El email no cumple los requisitos");
                        email = false;
                    }
                }
                if(usuario == true && pass == true && email == true) {
                    System.out.println("El usuario ha sido correctamente registrado.");
                    salida = 1;
                    au.add(temp);
                }else if(usuario == true && pass == true && email == false) {
                    System.out.println("El email no cumple los requisitos, se le podra uno por defecto.");
                    temp.setEmail(temp.getNombre() + "@correo.es");
                    System.out.println("Este es su email: " + temp.getEmail());
                    au.add(temp);
                    salida = 1;
                }
            } while (salida != 1);
        }
        private static void giveop(ArrayList<Articulo> c, Scanner scstring, Scanner scopcion){
            Opinion temp = new Opinion();
            int opcion = 0;
            int oplike = 0;
            String codigo;
            int cont = 0;
            
            System.out.println("Introduzca el codigo del articulo para dar la opinion.");
            codigo = scstring.nextLine();
            
            for(Articulo i: c){
                if(i.getIds().equals(codigo)){
                    do{

                        System.out.println("Estas son las puntuaciones a dar: ");
                        System.out.println("1. " + Puntuacion.excelente);
                        System.out.println("2. " + Puntuacion.muybueno);
                        System.out.println("3. " + Puntuacion.bueno);
                        System.out.println("4. " + Puntuacion.malo);
                        System.out.println("5. " + Puntuacion.terrible);
                        System.out.println("6. Sin puntuacion.");
                        opcion = scopcion.nextInt();
                        switch(opcion){
                            case 1:
                                temp.punt = Puntuacion.excelente;
                                break;
                            case 2:
                                temp.punt = Puntuacion.muybueno;
                                break;
                            case 3:
                                temp.punt = Puntuacion.bueno;
                                break;
                            case 4:
                                temp.punt = Puntuacion.malo;
                                break;
                            case 5:
                                temp.punt = Puntuacion.terrible;
                                break;
                            case 6:
                                System.out.println("Hasta luego.");
                                break;
                            default:
                                System.out.println("La opcion no esta disponible.");
                        }
                    }while(opcion != 1 || opcion != 6);
                    System.out.println("Escriba su opinion:");
                    temp.coment = scstring.nextLine();
                    i.getOpiniones().add(temp);
                    System.out.println("¿Desea dar like o dislike?");
                    System.out.println("1. Like.");
                    System.out.println("2. Dislike.");
                    System.out.println("3. Ninguna.");
                    oplike = scopcion.nextInt();
                            do{
                                switch(oplike){
                                    case 1:
                                        temp.darlike();
                                        break;
                                    case 2:
                                        temp.dardislike();
                                        break;
                                    default:
                                        System.out.println("Has introducido la opcion incorrecta, vuelva a introducirla.");
                                        break;
                                }
                            }while(oplike!=3);
                }else{
                    cont++;
                }
            }
            if(cont == c.size()){
                System.out.println("Este articulo no existe.");
            }
        }
        private static void seeop(ArrayList<Articulo> c, Scanner scstring ){
            Opinion temp = new Opinion();
            String codigo;
            codigo = scstring.nextLine();
            for(Articulo i: c){
                if(i.getIds().equals(codigo)){
                    temp.toString();
                }
            }
        }
}






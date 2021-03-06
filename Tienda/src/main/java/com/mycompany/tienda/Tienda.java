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
import com.mycompany.tienda.entidades.Tecnologia;
import com.mycompany.tienda.entidades.Usuario;
import com.mycompany.tienda.enumerados.Puntuacion;
import com.mycompany.tienda.enumerados.Tallas;
import com.mycompany.tienda.enumerados.Tipostec;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


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
        
        Carrito carro = new Carrito();
        Usuario templog = new Usuario();
        ArrayList <Articulo> catalogo = new ArrayList <Articulo>();
        ArrayList <Usuario> regs = new ArrayList <Usuario>();
        regs.add(new Usuario("admin123", "Contrasena1", "admin123@gmail.com"));
        inicializarcatalogo(catalogo);
        menulog(scopcion, scstring, templog, regs, catalogo, scint, carro);
        scstring.close();
        scint.close();
        scopcion.close();
    }

        private static void menulog(Scanner scopcion, Scanner scstring, Usuario templog, ArrayList<Usuario> regs, ArrayList<Articulo> catalogo, Scanner scint, Carrito carro) {
        int opcion1;
        String user;
        String pass;
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
                        menuuser(scopcion, catalogo, scstring, scint, carro);
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
    }
        private static void menuuser(Scanner scopcion, ArrayList<Articulo> catalogo, Scanner scstring, Scanner scint, Carrito carro) {
        int opcion2;
        int opcion3;
        System.out.println("Ya esta loggeado.");
        System.out.println("Esto es el menu de la tienda, tiene diferentes opciones:");
        do{
            System.out.println("1. Añadir un articulo al catalogo");
            System.out.println("2. Comprar un producto.");
            System.out.println("3. Comfirmar la compra de los productos.");
            System.out.println("4. Dar opinion.");
            System.out.println("5. Ver opinion.");
            System.out.println("6. Leer archivo.");
            System.out.println("7. Ingresar arhivo.");
            System.out.println("8. Salir del la tienda.");
            opcion2 = scopcion.nextInt();
            switch(opcion2){
                case 1:
                    System.out.println("¿Que tipo de articulo quieres introducir?");
                    System.out.println("1. Añadir una prenda de ropa.");
                    System.out.println("2. Añadir un electrodomestico.");
                    System.out.println("3. Añadir un articulo de tecnologia.");
                    System.out.println("4. Ninguno");
                    opcion3 = scint.nextInt();
                    do{
                        switch(opcion3){
                            case 1:
                                    addropaCatalogo(catalogo, scstring, scint);
                                break;
                            case 2:
                                    addelectCatalogo(catalogo, scstring, scint);
                                break;
                            case 3:
                                    addticCatalogo(catalogo, scstring, scint);
                                break;
                        }
                    }while(opcion3 != 1 && opcion3 != 4);
                    mostrarCatalogo(catalogo);
                    break;
                case 2:
                    System.out.println("Has elegido la opcion de comprar productos, para seleccionar los productos es necesario utilizar"
                            + " el codigo del producto\n");
                    comprar(catalogo, carro, scstring, scint);
                    break;
                case 3:
                    Confirmacion(carro, scstring, catalogo);
                    break;
                case 4:
                    giveop(catalogo, scstring, scopcion);
                    break;
                case 5:
                    seeop(catalogo, scstring, scopcion);
                    break;
                case 6:
                    loadArticuloFromFile();
                    break;
                case 7:
                    saveArticuloToFile(catalogo);
                    break;
                case 8:
                    System.out.println("Muchas gracias por utilizar esta tienda.");
                    break;
                default:
                    System.out.println("Has introducido la opcion incorrecta, vuelva a introducirla.");
                    break;
            }
        }while(opcion2 != 8);
    }
        private static void Confirmacion(Carrito carro, Scanner scstring, ArrayList<Articulo> catalogo) {
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
        }
        private static void inicializarcatalogo(ArrayList <Articulo> c) {
            c.add(new Tecnologia("T0001", "Monitor", 200.00F, 10, Tipostec.componentes));
            c.add(new Tecnologia("T0002", "Teclado", 30.00F, 40, Tipostec.ordenadores));
            c.add(new Tecnologia("T0003", "Raton", 25.99F, 100, Tipostec.ordenadores));
            c.add(new Tecnologia("T0004", "RJ45-5M-Cat 6", 10.00F, 25, Tipostec.componentes));
            c.add(new Ropa("rojo", Tallas.M, "R0005", "jersei", 15.00F, 35));
            c.add(new Electrodomestico(ClasEn.F, "alta", "E0006", "lavadora", 200.00F, 35));
            c.add(new Lavadoras(Marcas.Balay, 500, 5, 65, 99.50F, ClasEn.A, "alta", "E0007", "lavadora", 200.00F, 35));
        }
        private static void addropaCatalogo( ArrayList <Articulo> c, Scanner texto, Scanner ints) {
            System.out.println("Introduce el codigo del articulo:");
            String codigo = texto.nextLine();
            codigo = "R"+codigo;
            System.out.println("Introduce el nombre del articulo:");
            String nombre  = texto.nextLine();
            System.out.println("Introduce el precio del articulo:");
            float precio = ints.nextFloat();
            System.out.println("Introduce el stock del articulo:");
            int stock = ints.nextInt();
            System.out.println("Introduce el color de la prenda de ropa:");
            String color = texto.nextLine();
            System.out.println("Introduzca la talla del la prenda de ropa (XXS, XS, S, M, L, XL, XXL):");
            String t = texto.nextLine();
            Tallas tam = Tallas.XXS;
            if(t == "XXS"){
               tam = Tallas.XXS;
            }
            if(t == "XS"){
                tam = Tallas.XS;
            }
            if(t == "S"){
                tam = Tallas.S;
            }
            if(t == "M"){
                tam = Tallas.M;
            }
            if(t == "L"){
                tam = Tallas.L;
            }
            if(t == "XL"){
                tam = Tallas.XL;
            }
            if(t == "XXL"){
                tam = Tallas.XXL;
            }
            c.add(new Ropa(color, tam, codigo, nombre, precio, stock));
        }
        private static void addelectCatalogo( ArrayList <Articulo> c, Scanner texto, Scanner ints) {
            boolean compe = false;
            System.out.println("Introduce el codigo del articulo:");
            String codigo = texto.nextLine();
            codigo = "E"+codigo;
            System.out.println("Introduce el nombre del articulo:");
            String nombre  = texto.nextLine();
            System.out.println("Introduce el precio del articulo:");
            float precio = ints.nextFloat();
            System.out.println("Introduce el stock del articulo:");
            int stock = ints.nextInt();
            System.out.println("Introduce la gama del Electrodomestico:");
            String gama = texto.nextLine();
            System.out.println("Introduce la clase energetica del electrodomestico (A, B, C, D, E, F):");
            char ca = texto.nextLine().charAt(0);
            ClasEn ce = ClasEn.A;
            if(ca == 'A'){
                ce = ClasEn.A;
            }
            if(ca == 'B'){
                ce = ClasEn.B;
            }
            if(ca == 'C'){
                ce = ClasEn.C;
            }
            if(ca == 'D'){
                ce = ClasEn.D;
            }
            if(ca == 'E'){
                ce = ClasEn.E;
            }
            if(ca == 'F'){
                ce = ClasEn.F;
            }
            c.add(new Electrodomestico(ce, gama, codigo, nombre, precio, stock));
        }
        private static void addticCatalogo(ArrayList <Articulo> c, Scanner texto, Scanner ints) {
            System.out.println("Introduce el codigo del articulo:");
            String codigo = texto.nextLine();
            codigo = "T"+codigo;
            System.out.println("Introduce el nombre del articulo:");
            String nombre  = texto.nextLine();
            System.out.println("Introduce el precio del articulo:");
            float precio = ints.nextFloat();
            System.out.println("Introduce el stock del articulo:");
            int stock = ints.nextInt();
            System.out.println("Introduzca el tipo de tecnologia que es (ordenadores, moviles, componentes) :");
            String op = texto.nextLine();
            Tipostec tpt = Tipostec.componentes;
            
            if(op == "ordenadores"){
                tpt = Tipostec.ordenadores;
            }
            if(op == "moviles"){
                tpt = Tipostec.moviles;
            }
            if(op == "componentes"){
                tpt = Tipostec.componentes;
            }
            c.add(new Tecnologia(codigo, nombre, precio, stock, tpt));
        }
	private static void mostrarCatalogo(ArrayList <Articulo> c) {
		for (Articulo a : c) {
			System.out.println(a);
		}
	}
	private static void comprar(ArrayList<Articulo> c, Carrito ca, Scanner sctexto,Scanner scint){
		String opsalida = " ";
		Articulo insertar = null; 
                String codpromo = null;
		mostrarCatalogo(c);
		int m = 0;
		do {
			System.out.println("Introduzca el codigo del producto:");
			String tempcodigo = sctexto.nextLine();
			insertar = buscarporcodigo(c, tempcodigo);
			if(insertar != null){
				do{
                                    System.out.println("Introduzca la cantidad del producto que desea comprar: ");
                                    int tempcantidad = scint.nextInt();
                                    if(insertar.disponible(tempcantidad)) {
                                            System.out.println("Si tiene codigo de promocion introduzcalo ahora: ");
                                            codpromo = sctexto.nextLine();
                                            System.out.println("\nEl articulo se a introducido al carrito.");
                                            ca.addArticulo(insertar, tempcantidad, codpromo);
                                            m = 1;
                                    }else{
                                            System.out.println("No hay tantas existencias, porfavor pida una cantidad distinta.");
                                    }
				}while(m != 1);
			}else{
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
                            default:
                                System.out.println("La opcion no esta disponible.");
                        }
                    }while(opcion != 1 && opcion != 5);
                    System.out.println("Escriba su opinion:");
                    temp.coment = scstring.nextLine();
                    i.getOpiniones().add(temp);
                }else{
                    cont++;
                }
            }
            if(cont == c.size()){
                System.out.println("Este articulo no existe.");
            }
        }
        private static void seeop(ArrayList<Articulo> c, Scanner scstring, Scanner scopcion){
            Opinion temp = new Opinion();
            String codigo;
            int oplike = 0;
            System.out.println("Introduzca el codigo del articulo.");
            codigo = scstring.nextLine();
            for(Articulo i: c){
                if(i.getIds().equals(codigo)){
                    for(Opinion o: i.getOpiniones()){
                        System.out.println(o.toString());
                        System.out.println("¿Desea dar like o dislike?");
                        System.out.println("1. Like.");
                        System.out.println("2. Dislike.");
                        System.out.println("3. Ninguna.");
                        oplike = scopcion.nextInt();
                        do{
                            switch(oplike){
                                case 1:
                                    o.darlike();
                                    break;
                                case 2:
                                    o.dardislike();
                                    break;
                                default:
                                    System.out.println("Has introducido la opcion incorrecta, vuelva a introducirla.");
                                    break;
                            }
                        }while(oplike!=1&&oplike!=3);
                    }
                }
            }
        }
        private static void loadArticuloFromFile(ArrayList <Articulo> c){
            File fichero = null;
            FileReader lector = null;
            BufferedReader buffer = null;
            
            try{

                fichero = new File("Articulos.txt");
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea = null;
                String[] nuevaRopa;
                while((linea = buffer.readLine()) != null){
                    nuevaRopa = linea.split(",");
                    c.add(new Ropa(nuevaRopa));
                    //TO DO Cargar cada linea creando un objeto Ropa en catalogo
                    //nuevaRopa[];
                }
            }catch (FileNotFoundException fnfe){
                fnfe.printStackTrace();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }finally{
                if(buffer != null){
                    try{
                        buffer.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
            }
        }
        public static void saveArticuloToFile(ArrayList <Articulo> c){
            FileWriter fichero = null;
            PrintWriter escritor = null;
            
            try{
                fichero = new FileWriter("Articulos2.txt");
                escritor = new PrintWriter(fichero);
                //TO DO recorrer catalogo escribiendo cada articulo en una nuevo linea del fichero
                for (Articulo a : c){
                    escritor.println(a.toStringFile());
                }
            }catch (IOException ioe){
                ioe.printStackTrace();
            }finally {
                if (fichero != null){
                    try {  
                        fichero.close();
                    }catch (IOException ioe){
                        ioe.printStackTrace();
                    }
                }
                
            }
        }
}






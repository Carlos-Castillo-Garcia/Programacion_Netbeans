/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.Permisos;
import java.util.ArrayList;


/**
 *
 * @author PORTATIL 2
 */
public class Usuario {
    private String nombre;
    private String passwd;
    private String email;
    private Permisos permisos;
    
    /**
     *  @
     */
    public Usuario(){
        this.permisos = Permisos.user;
    }

    /**
     *
     * @param n
     * @param pass
     * @param em
     * @param permisos
     */
    public Usuario(String n, String pass, String em){
        this.nombre = n;
        this.email = em;
        this.passwd = pass;
        this.permisos = Permisos.user;
    }

    /**
     * @return the contraseña
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param nombre the contraseña to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *
     * @param log
     * @param user
     * @param pass
     * @return un boleano que dice si se puede loguear o no.
     */
    public boolean login(ArrayList <Usuario> log, String user, String pass){
        boolean comprobante = false;
        for(Usuario i: log){
            if(i.getNombre().equals(user)){
                if(i.getPasswd().equals(pass)){
                    comprobante = true;
                }
            }
        } 
        return comprobante;
    }
    
    /**
     *
     * @param c
     * @return un boleano que dice si la contraseña esta bien o no.
     */
    public boolean Compcontrasena (String c){
        boolean comprobante = false;
        comprobante = c.matches(".*[A-Z].*");
        if(c.length()>=8){
           comprobante= true;
        }
        return comprobante;
    }
    
    /**
     *
     * @param n
     * @return un boleano que dice si el nombre de usuario esta bien o no.
     */
    public boolean Compnombre(String n){
        boolean comprobante = false;
        if(n.length()>= 6){
            comprobante = true;
        }
        return comprobante;
    }
    
    /**
     *
     * @param e
     * @return un boleano que dice si el email esta bien o no.
     */
    public boolean Compemail(String e){
        boolean comprobante = false;
        if(e.matches("[-\\w\\.]+@[a-z]+\\.[a-z]+")){
            comprobante = true;
        }else{
            return comprobante;
        }
        return comprobante;
    }
}

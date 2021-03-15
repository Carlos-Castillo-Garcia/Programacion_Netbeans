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
    
    public Usuario(){
    }
    public Usuario(String n, String pass, String em, Permisos permisos){
        this.nombre = n;
        this.email = em;
        this.passwd = pass;
        this.permisos = permisos;
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
    
    public boolean Compcontrasena (String c){
        boolean comprobante = false;
        comprobante = c.matches(".*[A-Z].*");
        if(c.length()>=8){
           comprobante= true;
        }
        return comprobante;
    }
    
    public boolean Compnombre(String n){
        boolean comprobante = false;
        if(n.length()>= 6){
            comprobante = true;
        }
        return comprobante;
    }
    
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

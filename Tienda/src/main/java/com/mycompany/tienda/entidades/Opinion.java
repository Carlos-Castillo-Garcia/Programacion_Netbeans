/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tienda.entidades;

import com.mycompany.tienda.enumerados.Puntuacion;

/**
 *
 * @author PORTATIL 2
 */
public class Opinion {
    Usuario user;
    Puntuacion punt;
    String coment;
    int like;
    int dislike;
    
    public Opinion(){
    }
    
    public Opinion(Usuario user, Puntuacion punt, String coment){
        this.coment = coment;
        this.like = 0;
        this.dislike = 0;
        this.punt = punt;
        this.user = user;
    }
    
    public void darlike(int like){
        like++;
    }
    
    public void dardislike(int dislike){
        dislike++;
    }
    
    @Override
    public String toString(){
        return "Usuario: "+user+ "\nComentario: "+coment+ "";
    }
}

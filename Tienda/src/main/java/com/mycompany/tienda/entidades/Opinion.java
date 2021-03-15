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
    public Puntuacion punt;
    public String coment;
    public int like;
    public int dislike;

    public Opinion(){
        like = 0;
        dislike = 0;
    }
    
    /**
     *
     * @param user
     * @param punt
     * @param coment
     */
    public Opinion(Usuario user, Puntuacion punt, String coment){
        this.coment = coment;
        this.like = 0;
        this.dislike = 0;
        this.punt = punt;
        this.user = user;
    }
    
    /**
     *
     * @param like
     */
    public void darlike(){
        like++;
    }
    
    /**
     *
     * @param dislike
     */
    public void dardislike(){
        dislike++;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario: ")
                .append(this.user)
                .append("\nPuntuación: ")
                .append(this.punt)
                .append("\nLikes: ")
                .append(this.like)
                .append("Dislikes: ")
                .append(this.dislike)
                .append("\n");
        return sb.toString();
    }
}

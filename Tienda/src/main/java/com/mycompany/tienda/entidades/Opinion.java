
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
public class Opinion implements Comparable<Opinion>{
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
        sb.append("\n   Comentario: ")
                .append(this.coment)
                .append("\n Puntuación: ")
                .append(this.punt)
                .append("\n Likes: ")
                .append(this.like)
                .append("\n Dislikes: ")
                .append(this.dislike)
                .append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Opinion o) {
        int valorp = 0;
        int valoro = 0;
        if(o.punt == Puntuacion.excelente){
            valorp = 5;
        }
        if(o.punt == Puntuacion.muybueno){
            valorp = 4;
        }
        if(o.punt == Puntuacion.bueno){
            valorp = 3;
        }
        if(o.punt == Puntuacion.malo){
            valorp = 2;
        }
        if(o.punt == Puntuacion.terrible){
            valorp = 1;
        }
        
        if(punt == Puntuacion.excelente){
            valoro = 5;
        }
        if(punt == Puntuacion.muybueno){
            valoro = 4;
        }
        if(punt == Puntuacion.bueno){
            valoro = 3;
        }
        if(punt == Puntuacion.malo){
            valoro = 2;
        }
        if(punt == Puntuacion.terrible){
            valoro = 1;
        }

        if(valoro == valorp){
            return 0;
        }else if(valoro > valorp){
            return 1;
        }else{
            return -1;
        }
    }


}


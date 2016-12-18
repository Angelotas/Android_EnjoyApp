package com.example.ngel.enjoyapp;

/**
 * Created by Ángel on 18/12/2016.
 */

public class ElementoGrid {

    private int idItem;
    private int idImagen;

    public ElementoGrid(int item, int imagen){
        this.idItem=item;
        this.idImagen=imagen;
    }

    public int getIdItem(){
        return idItem;
    }
    public int getIdImagen(){
        return idImagen;
    }
    public String idItemToString(){ return String.valueOf(idItem); }

}

package com.gamerstore.gamerstoreapp;

public class ListItem {
    private String diseId;
    private String diseDescripcion;
    private String diseProdID;
    private String diseClienteID;
    private String diseImagen;


    public String getDiseId() {
        return diseId;
    }
    public void setDiseId(String diseId) {
        this.diseId = diseId;
    }


    public String getDiseDescripcion() {
        return diseDescripcion;
    }
    public void setDiseDescripcion(String diseDescripcion) {
        this.diseDescripcion = diseDescripcion;
    }


    public String getDiseProdID() {
        return diseProdID;
    }
    public void setDiseProdID(String diseProdID) {
        this.diseProdID = diseProdID;
    }


    public String getDiseClienteID() {
        return diseClienteID;
    }
    public void setDiseClienteID(String diseClienteID) {
        this.diseClienteID = diseClienteID;
    }


    public String getDiseImagen() {
        return diseImagen;
    }
    public void setDiseImagen(String diseImagen) {
        this.diseImagen = diseImagen;
    }

    @Override
    public String toString() {
        return "[ Diseño=" + diseId + ", Descripción=" + diseDescripcion + " , Imagen=" + diseImagen + "]";
    }

}

package com.gamerstore.gamerstoreapp;

public class ListItem {
    private String prodId;
    private String prodDescripcion;
    private String prodImagen;
    private String prodCategoria;
    private String prodPrecioUnitario;


    public String getProdIdId() {
        return prodId;
    }
    public void setProdIdId(String prodId) {
        this.prodId = prodId;
    }


    public String getProdDescripcion() {
        return prodDescripcion;
    }
    public void setProdDescripcion(String prodDescripcion) {
        this.prodDescripcion = prodDescripcion;
    }


    public String getProdImagen() {
        return prodImagen;
    }



    public void setDiseProdID(String prodImagen) {
        this.prodImagen = prodImagen;
    }


    public String getProdCategoria() {
        return prodCategoria;
    }
    public void setProdCategoria(String prodCategoria) {
        this.prodCategoria = prodCategoria;
    }


    public String getProdPreciounitario() {
        return prodPrecioUnitario;
    }
    public void setProdPrecioUnitario (String prodPrecioUnitario) {
        this.prodPrecioUnitario = prodPrecioUnitario;
    }

    @Override
    public String toString() {
        return "[ Diseño=" + prodId + ", Descripción=" + prodDescripcion + " , Imagen=" + prodImagen + "]";
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.modelos;

import java.util.ArrayList;

/**
EN ESTA CLASE ASEO SE EXTIENDE DE LA CLASE ABSTRACTA PRODUCTO
 */
public class Aseo extends Producto {
    String tipoAseo;
    int id;

    public Aseo() {
    }

    public Aseo(String tipoAseo,String codigo, String nombre, String marca, String fVencimiento, String precio, String descuento) {
        super(codigo,nombre, marca, fVencimiento, precio, descuento);
        this.tipoAseo = tipoAseo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getTipoAseo() {
        return tipoAseo;
    }

    public void setTipoAseo(String tipoAseo) {
        this.tipoAseo = tipoAseo;
    }

    public long getRegalo() {
        return regalo;
    }

    public void setRegalo(long regalo) {
        this.regalo = regalo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getfVencimiento() {
        return fVencimiento;
    }

    public void setfVencimiento(String fVencimiento) {
        this.fVencimiento = fVencimiento;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }




    
}

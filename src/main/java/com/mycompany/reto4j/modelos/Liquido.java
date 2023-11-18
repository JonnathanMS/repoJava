/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.modelos;

/**
 *
 * @author Equipo
 */
/**
 EN ESTE METODO SE HEREDA DE LA CLSE ABSTRACTA PRODUCTO LA CUAL A SU VEZ IMPLEMENTA LA INTERFAZ
 * COMPRA
 */
public class Liquido extends Producto {
    int id;
    String TipoLiquido;

    public Liquido() {
    }

    
    
    public Liquido(String TipoLiquido,String codigo, String nombre, String marca, String fVencimiento, String precio, String descuento) {
        super(codigo,nombre, marca, fVencimiento, precio, descuento);
        this.TipoLiquido = TipoLiquido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getTipoLiquido() {
        return TipoLiquido;
    }

    public void setTipoLiquido(String TipoLiquido) {
        this.TipoLiquido = TipoLiquido;
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
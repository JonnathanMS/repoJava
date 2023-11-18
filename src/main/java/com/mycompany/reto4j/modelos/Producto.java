/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.modelos;


/*

 */
public abstract class Producto {
    long regalo=0;

    public String codigo;
    public String nombre;
    public String marca;
    public String fVencimiento;
    public String precio;
    public String descuento;

    public Producto() {
    }
    
    

    public Producto(String codigo, String nombre, String marca, String fVencimiento, String precio, String descuento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.fVencimiento = fVencimiento;
        this.precio = precio;
        this.descuento = descuento;
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
    
        public long valorRegalo(long valor) {
        long valor1;
    if(valor/10.000>0){
        valor1=(long)valor/10000;
        //esta variable regalo esta definida en la clase abstrabta producto como long//
        regalo=valor1*1000;
    }
        return regalo;
    }//termina valor regalo
        
      public double ivayDescuento(String precio,String descuento) {
      double vPrecio=Double.valueOf(precio);
      double vDescuento=Double.valueOf(descuento);
      double total=0;
      total=(vPrecio*1.19)-(vDescuento);
      return total;
    }

    
    
}
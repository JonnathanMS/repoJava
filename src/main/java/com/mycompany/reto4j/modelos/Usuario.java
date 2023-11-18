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
LA CLASE USUARIO IMPLEMENTA LA INTERFAZ COMPRA Y GUARDA EL ACUMULADO DE REGALO
 */
public class Usuario{
    static long acumulado=0;
    int id;
    String nombre;
    String cedula;
    String acumulado2;
   

    public String getAcumulado2() {
        return acumulado2;
    }

    public void setAcumulado2(String acumulado2) {
        this.acumulado2 = acumulado2;
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public static long getAcumulado() {
        return acumulado;
    }

    public static void setAcumulado(long acumulado) {
        Usuario.acumulado = acumulado;
    }
    

    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    public  Usuario(String nombre, String cedula, String acumulado2) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.acumulado2 = acumulado2;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
        public static long valorRegalo(long valor) {
        acumulado+=valor;
        return acumulado;
        }
}   
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
import java.util.ArrayList;
import java.util.Scanner;


public class Carrito {
        //en estas listas se agregaran los productos al carrito segun tipo
       static ArrayList<Comestible> listaC=new ArrayList<>();
       static ArrayList<Liquido> listaL=new ArrayList<>();
       static ArrayList<Aseo> listaA=new ArrayList<>();
       static Scanner entrada=new Scanner(System.in);
       static int sacadosC=0;
       static int sacadosL=0;
       static int sacadosA=0;
       static double costoT=0;
       int id;
       String cedula;
       String codigo;

    public Carrito() {
    }
    
    public Carrito(ArrayList Comestible,ArrayList Usuario){
        
    }
    public int getId() {
        return id;
    }

    public static ArrayList<Comestible> getListaC() {
        return listaC;
    }

    public static void setListaC(ArrayList<Comestible> listaC) {
        Carrito.listaC = listaC;
    }

    public static ArrayList<Liquido> getListaL() {
        return listaL;
    }

    public static void setListaL(ArrayList<Liquido> listaL) {
        Carrito.listaL = listaL;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    public static ArrayList<Comestible> getlistaC() {
        return listaC;
    }

    public static void setlistaC(ArrayList<Comestible> listaC) {
        Carrito.listaC = listaC;
    }

 

    public static ArrayList<Aseo> getListaA() {
        return listaA;
    }

    public static void setListaA(ArrayList<Aseo> listaA) {
        Carrito.listaA = listaA;
    }

    public static Scanner getEntrada() {
        return entrada;
    }

    public static void setEntrada(Scanner entrada) {
        Carrito.entrada = entrada;
    }

    public static int getSacadosC() {
        return sacadosC;
    }

    public static void setSacadosC(int sacadosC) {
        Carrito.sacadosC = sacadosC;
    }

    public static int getSacadosL() {
        return sacadosL;
    }

    public static void setSacadosL(int sacadosL) {
        Carrito.sacadosL = sacadosL;
    }

    public static int getSacadosA() {
        return sacadosA;
    }

    public static void setSacadosA(int sacadosA) {
        Carrito.sacadosA = sacadosA;
    }

    public static double getCostoT() {
        return costoT;
    }

    public static void setCostoT(double costoT) {
        Carrito.costoT = costoT;
    }
    
    

       
       
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.vista;

import java.util.Scanner;


public class VistaPrincipal {
    
    Scanner teclado=new Scanner(System.in);
    
    
    
    public String getMenu(){
        
        System.out.println("**Avizpao**"+
                            "\n1. Mostrar vuelos"+
                            "\n2. Hacer reserva"+
                            "\n3. Mostrar reservas");
        
        return teclado.nextLine();
    }
    
    //reemplaza un println 
    public void getTexto(String texto){
        System.out.println(texto);
    }
    
        public void getTextoPromo(String nombre,String descuento){
        System.out.println("Producto: "+nombre+" Descuento: "+descuento);
    }
    
    
    //ME SIRVE PARA REEMPLAZAR nextLine()
    public String getEntrada(String texto){
         System.out.println(texto);
         return teclado.nextLine();
    }

    
    //RECIBE UN ARRAY CON STRING YA LLENADO PREVIAMENTE Y MUESTRA SUS DATOS
    public void getInfoArray(String[] datos) {
        System.out.println("\nNumero: "+datos[0]+" - Cedua: "+datos[1]+
                                "\nNombre: "+datos[2]+" "+datos[3]+
                                "\nTipo: "+datos[4]);
    }
    
 
    
    
}


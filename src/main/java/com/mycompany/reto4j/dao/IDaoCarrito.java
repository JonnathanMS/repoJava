/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Carrito;
import com.mycompany.reto4j.modelos.Comestible;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public interface IDaoCarrito {
    public ArrayList<Carrito> verCarrito();
    
    public boolean eliminarValor(Carrito carrito);
    
    public boolean borrarTodo();
        
    public boolean crearCarrito(Carrito carrito);
}

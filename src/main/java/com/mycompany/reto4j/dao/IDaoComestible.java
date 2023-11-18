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
public interface IDaoComestible {
    public boolean eliminarValor(Comestible comestible);
    
    public boolean borrarTodo();
    
    public ArrayList<Comestible> verComestible();
    
    public ArrayList<Comestible> verComestiblek();
    
    public boolean crearComestible(Comestible comestible);
    
    public Carrito infoCarrito(String numero);
    
}

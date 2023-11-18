/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Liquido;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public interface IDaoLiquido {
    
    public boolean eliminarValor(Liquido liquido);
    
    public boolean borrarTodo();
    
    public ArrayList<Liquido> verLiquido();
    
    public ArrayList<Liquido> verLiquidok();
    
    public boolean crearLiquido(Liquido liquido);
}

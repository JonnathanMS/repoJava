/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Aseo;
import com.mycompany.reto4j.modelos.Liquido;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public interface IDaoAseo {
    
    public boolean eliminarValor(Aseo aseo);
    
    public boolean borrarTodo();
    
    public ArrayList<Aseo> verAseo();
    
    public ArrayList<Aseo> verAseok();
    
    public boolean crearAseo(Aseo aseo);
}

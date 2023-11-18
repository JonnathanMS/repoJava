/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Comestible;
import com.mycompany.reto4j.modelos.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public interface IDaoUsuario {
    
    public boolean eliminarValor(Usuario usuario);
    
    public boolean borrarTodo();
    
    public ArrayList<Usuario> verUsuario();
    
    public boolean crearUsuario(Usuario usuario,String acumulado);
}

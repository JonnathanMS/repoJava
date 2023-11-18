/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Carrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 
 */
public class DaoCarrito extends Conexion implements IDaoCarrito{
    
    
        @Override
    public ArrayList<Carrito> verCarrito() {
        
        ArrayList<Carrito> listaCarritos=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_KARRITO+
                    " ORDER BY "+FinalBD.TK_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Carrito carrito=new Carrito();
                carrito.setId(resultSet.getInt(FinalBD.TK_ID));
                carrito.setCodigo(resultSet.getString(FinalBD.TK_CODIGO));
                carrito.setCedula(resultSet.getString(FinalBD.TK_CEDULA));
                
                listaCarritos.add(carrito);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaCarritos;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaCarritos;
    }
    
     @Override
    public boolean crearCarrito(Carrito carrito) {
        
        String sql="INSERT INTO "+FinalBD.T_KARRITO+"("+
                                  // FinalBD.TK_ID+","+
                                    FinalBD.TK_CEDULA+","+
                                    FinalBD.TK_CODIGO+") VALUES(?,?)";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, carrito.getCedula());
            ps.setString(2, carrito.getCodigo());
            ps.executeUpdate();
            
            System.out.println("Producto agregado con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al agregar el producto "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
        
    }

    @Override
    public boolean eliminarValor(Carrito carrito) {
                String sql="DELETE FROM "+FinalBD.T_KARRITO+" WHERE "+
                                              FinalBD.TK_ID +"=?";
                                   
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, carrito.getId());
            ps.executeUpdate();
            
            System.out.println("Producto BORRADO con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al BORRAR el producto "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
        
    }

    @Override
    public boolean borrarTodo() {
        
                 String sql="DELETE FROM "+FinalBD.T_KARRITO;
                                    
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println("tabla carrito BORRADA con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al BORRAR el producto "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
    }

    
}// TERMINA DAOCARRITO

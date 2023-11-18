/*
 
 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public class DaoUsuario extends Conexion implements IDaoUsuario{
    
    
    
    @Override
    public ArrayList<Usuario> verUsuario() {
        
        ArrayList<Usuario> listaUsuarios=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_USUARIO+
                    " ORDER BY "+FinalBD.TU_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Usuario usuario=new Usuario();
                usuario.setId(resultSet.getInt(FinalBD.TU_ID));
                usuario.setCedula(resultSet.getString(FinalBD.TU_CEDULA));
                usuario.setNombre(resultSet.getString(FinalBD.TU_NOMBRE));
                usuario.setAcumulado2(resultSet.getString(FinalBD.TU_ACUMULADO));
                
                listaUsuarios.add(usuario);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaUsuarios;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaUsuarios;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    // ESTA FUNCION INSERTA EN LA TABLA COMESTIBLEK DE SQL LOS VALORES DEL OBJETO comestible
   //SERVIRA PARA AGREGAR DATOS A LAS TABLAS
    @Override
    public boolean crearUsuario(Usuario usuario,String acumulado) {
        
        String sql="INSERT INTO "+FinalBD.T_USUARIO+"("+
                                   // FinalBD.TU_ID+","+
                                    FinalBD.TU_NOMBRE+","+
                                    FinalBD.TU_CEDULA+","+
                                    FinalBD.TU_ACUMULADO+") VALUES(?,?,?)";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2,usuario.getCedula());
            ps.setString(3, acumulado);
            ps.executeUpdate();
            
            System.out.println("usuario agregado con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al agregar el usuario "+e);            
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
    public boolean eliminarValor(Usuario usuario) {
                String sql="DELETE FROM "+FinalBD.T_USUARIO+" WHERE "+
                                              FinalBD.TU_ID +"=?";
                                   
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
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
                 String sql="DELETE FROM "+FinalBD.T_USUARIO;
                                    
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println("TABLA USUARIO BORRADA con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al BORRAR LA TABLA "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
        
    }

    
}//termina la clase DaoUsuario

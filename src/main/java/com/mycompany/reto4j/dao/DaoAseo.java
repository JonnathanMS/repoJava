/*
 
 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Aseo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 
 */
public class DaoAseo extends Conexion implements IDaoAseo {
    
    
    
        @Override
    public ArrayList<Aseo> verAseo() {
        
        ArrayList<Aseo> listaAseo=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_ASEO+
                    " ORDER BY "+FinalBD.TA_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Aseo aseo=new Aseo();
                aseo.setId(resultSet.getInt(FinalBD.TA_ID));
                aseo.setTipoAseo(resultSet.getString(FinalBD.TA_TIPOASEO));
                aseo.setCodigo(resultSet.getString(FinalBD.TA_CODIGO));
                aseo.setNombre(resultSet.getString(FinalBD.TA_NOMBRE));
                aseo.setMarca(resultSet.getString(FinalBD.TA_MARCA));
                aseo.setfVencimiento(resultSet.getString(FinalBD.TA_FVENCIMIENTO));
                aseo.setPrecio(resultSet.getString(FinalBD.TA_PRECIO));
                aseo.setDescuento(resultSet.getString(FinalBD.TA_DESCUENTO));
                
                listaAseo.add(aseo);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaAseo;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaAseo;
    }

    @Override
    public ArrayList<Aseo> verAseok() {
 ArrayList<Aseo> listaAseok=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_ASEOK+
                    " ORDER BY "+FinalBD.TAK_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Aseo aseok=new Aseo();
                aseok.setId(resultSet.getInt(FinalBD.TAK_ID));
                aseok.setTipoAseo(resultSet.getString(FinalBD.TAK_TIPOASEO));
                aseok.setCodigo(resultSet.getString(FinalBD.TAK_CODIGO));
                aseok.setNombre(resultSet.getString(FinalBD.TAK_NOMBRE));
                aseok.setMarca(resultSet.getString(FinalBD.TAK_MARCA));
                aseok.setfVencimiento(resultSet.getString(FinalBD.TAK_FVENCIMIENTO));
                aseok.setPrecio(resultSet.getString(FinalBD.TAK_PRECIO));
                aseok.setDescuento(resultSet.getString(FinalBD.TAK_DESCUENTO));
                
                listaAseok.add(aseok);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaAseok;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaAseok;
    
    }//termina ver aseok

    @Override
    public boolean crearAseo(Aseo aseo) {
        
        String sql="INSERT INTO "+FinalBD.T_ASEOK+"("+
                                   // FinalBD.TAK_ID+","+
                                    FinalBD.TAK_TIPOASEO+","+
                                    FinalBD.TAK_CODIGO+","+
                                    FinalBD.TAK_NOMBRE+","+
                                    FinalBD.TAK_MARCA+","+
                                    FinalBD.TAK_FVENCIMIENTO+","+
                                    FinalBD.TAK_PRECIO+","+
                                    FinalBD.TAK_DESCUENTO+") VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, aseo.getTipoAseo());
            ps.setString(2, aseo.getCodigo());
            ps.setString(3, aseo.getNombre());
            ps.setString(4, aseo.getMarca());
            ps.setString(5, aseo.getfVencimiento());
            ps.setString(6, aseo.getPrecio());
            ps.setString(7, aseo.getDescuento());
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
    public boolean eliminarValor(Aseo aseo){ //DELETE FROM `aseok` WHERE 0
        String sql="DELETE FROM "+FinalBD.T_ASEOK+" WHERE "+
                                              FinalBD.TAK_ID +"=?";
                                   
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, aseo.getId());
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
    

        
    //termina eliminarvalor

    @Override
    public boolean borrarTodo() {
         String sql="DELETE FROM "+FinalBD.T_ASEOK;
                                    
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println("tabla ase borrada con exito");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al BORRAR la tabla "+e);            
            return false;            
        } finally{
            try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }

        
    }
}

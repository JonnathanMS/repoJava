/*

 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Comestible;
import com.mycompany.reto4j.modelos.Liquido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Equipo
 */
public class DaoLiquido extends Conexion implements IDaoLiquido {

    @Override
    public ArrayList<Liquido> verLiquido() {
        
        ArrayList<Liquido> listaLiquidos=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_LIQUIDO+
                    " ORDER BY "+FinalBD.TL_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Liquido liquido=new Liquido();
                liquido.setId(resultSet.getInt(FinalBD.TL_ID));
                liquido.setTipoLiquido(resultSet.getString(FinalBD.TL_TIPOLIQUIDO));
                liquido.setCodigo(resultSet.getString(FinalBD.TL_CODIGO));
                liquido.setNombre(resultSet.getString(FinalBD.TL_NOMBRE));
                liquido.setMarca(resultSet.getString(FinalBD.TL_MARCA));
                liquido.setfVencimiento(resultSet.getString(FinalBD.TL_FVENCIMIENTO));
                liquido.setPrecio(resultSet.getString(FinalBD.TL_PRECIO));
                liquido.setDescuento(resultSet.getString(FinalBD.TL_DESCUENTO));
                
                listaLiquidos.add(liquido);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaLiquidos;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaLiquidos;
    }
    
    @Override
    public ArrayList<Liquido> verLiquidok() {
        
        ArrayList<Liquido> listaLiquidok=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_LIQUIDOK+
                    " ORDER BY "+FinalBD.TLK_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Liquido liquidok=new Liquido();
                liquidok.setId(resultSet.getInt(FinalBD.TLK_ID));
                liquidok.setTipoLiquido(resultSet.getString(FinalBD.TLK_TIPOLIQUIDO));
                liquidok.setCodigo(resultSet.getString(FinalBD.TLK_CODIGO));
                liquidok.setNombre(resultSet.getString(FinalBD.TLK_NOMBRE));
                liquidok.setMarca(resultSet.getString(FinalBD.TLK_MARCA));
                liquidok.setfVencimiento(resultSet.getString(FinalBD.TLK_FVENCIMIENTO));
                liquidok.setPrecio(resultSet.getString(FinalBD.TLK_PRECIO));
                liquidok.setDescuento(resultSet.getString(FinalBD.TLK_DESCUENTO));
                
                listaLiquidok.add(liquidok);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaLiquidok;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaLiquidok;
    }

   
    @Override
        public boolean crearLiquido(Liquido liquido) {
        
        String sql="INSERT INTO "+FinalBD.T_LIQUIDOK+"("+
                                   // FinalBD.TLK_ID+","+
                                    FinalBD.TLK_TIPOLIQUIDO+","+
                                    FinalBD.TLK_CODIGO+","+
                                    FinalBD.TLK_NOMBRE+","+
                                    FinalBD.TLK_MARCA+","+
                                    FinalBD.TLK_FVENCIMIENTO+","+
                                    FinalBD.TLK_PRECIO+","+
                                    FinalBD.TLK_DESCUENTO+") VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, liquido.getTipoLiquido());
            ps.setString(2, liquido.getCodigo());
            ps.setString(3, liquido.getNombre());
            ps.setString(4, liquido.getMarca());
            ps.setString(5, liquido.getfVencimiento());
            ps.setString(6, liquido.getPrecio());
            ps.setString(7, liquido.getDescuento());
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
    public boolean eliminarValor(Liquido liquido) {
                String sql="DELETE FROM "+FinalBD.T_LIQUIDOK+" WHERE "+
                                              FinalBD.TLK_ID +"=?";
                                   
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, liquido.getId());
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
                 String sql="DELETE FROM "+FinalBD.T_LIQUIDOK;
                                    
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println("TABLA LIQUIDO BORRADA con exito");
           
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

    


    }//termina DaoLiquido
    


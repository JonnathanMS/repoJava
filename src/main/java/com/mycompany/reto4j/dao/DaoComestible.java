/*

 AQUI SE EXTRAE, SELECCIONA, SE ELIMINA  Y SE MODIFICA LA INFORMACION DE LAS TABLAS DE SQL
 
 */
package com.mycompany.reto4j.dao;

import com.mycompany.reto4j.modelos.Carrito;
import com.mycompany.reto4j.modelos.Comestible;
import com.mycompany.reto4j.modelos.Usuario;
/*

*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DaoComestible extends Conexion implements IDaoComestible{

    
    
// ESTA FUNCION INSERTA EN LA TABLA COMESTIBLEK DE SQL LOS VALORES DEL OBJETO comestible
   //SERVIRA PARA AGREGAR DATOS A LAS TABLAS
    @Override
    public boolean crearComestible(Comestible comestible) {
        
        String sql="INSERT INTO "+FinalBD.T_COMESTIBLEK+" ("+
                                   // FinalBD.TCK_ID+","+
                                    FinalBD.TCK_TIPOCOMESTIBLE+","+
                                    FinalBD.TCK_CODIGO+","+
                                    FinalBD.TCK_NOMBRE+","+
                                    FinalBD.TCK_MARCA+","+
                                    FinalBD.TCK_FVENCIMIENTO+","+
                                    FinalBD.TCK_PRECIO+","+
                                    FinalBD.TCK_DESCUENTO+") VALUES(?,?,?,?,?,?,?)";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1, comestible.getTipoComestible());
            ps.setString(2, comestible.getCodigo());
            ps.setString(3, comestible.getNombre());
            ps.setString(4, comestible.getMarca());
            ps.setString(5, comestible.getfVencimiento());
            ps.setString(6, comestible.getPrecio());
            ps.setString(7, comestible.getDescuento());
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

    //ESTA FUNCION TOMA LOS VALORES DESDE LA TABLA COMESTIBLE Y LOS VA AGREGANDO
    //TODOS EN OBJETOS QUE SE AGREGAN A A LA listaCOMESTIBLE
    //ESTA TABLA COMESTIBLE NO SE MODIFICA, SERVIRA PARA MOSTRAR LOS PRODUCTOS.
    //PARA LLENAR Y SACAR ES LA TABLA COMESTIBLEK
    //            EQUIVALE A listaCOMESTIBLES
    @Override
    public ArrayList<Comestible> verComestible() {
        
        ArrayList<Comestible> listaComestibles=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_COMESTIBLE+
                    " ORDER BY "+FinalBD.TC_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Comestible comestible=new Comestible();
                comestible.setId(resultSet.getInt(FinalBD.TC_ID));
                comestible.setTipoComestible(resultSet.getString(FinalBD.TC_TIPOCOMESTIBLE));
                comestible.setCodigo(resultSet.getString(FinalBD.TC_CODIGO));
                comestible.setNombre(resultSet.getString(FinalBD.TC_NOMBRE));
                comestible.setMarca(resultSet.getString(FinalBD.TC_MARCA));
                comestible.setfVencimiento(resultSet.getString(FinalBD.TC_FVENCIMIENTO));
                comestible.setPrecio(resultSet.getString(FinalBD.TC_PRECIO));
                comestible.setDescuento(resultSet.getString(FinalBD.TC_DESCUENTO));
                
                listaComestibles.add(comestible);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaComestibles;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaComestibles;
    }

    //**********************************************************
    //ESTA FUNCION ME PERMITE MOSTRAR LOS PRODUCTOS TIPO COMESTIBLE QUE EL USUARIO AGREGO
    //AL CARRITO. EQUIVALE A listaC
    
    @Override
    public ArrayList<Comestible> verComestiblek() {
        
        ArrayList<Comestible> listaComestiblesk=new ArrayList<>();
        
        String sql="SELECT * FROM "+
                    FinalBD.T_COMESTIBLEK+
                    " ORDER BY "+FinalBD.TCK_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while (resultSet.next()) {  
                
               
                Comestible comestiblek=new Comestible();
                comestiblek.setId(resultSet.getInt(FinalBD.TCK_ID));
                comestiblek.setTipoComestible(resultSet.getString(FinalBD.TCK_TIPOCOMESTIBLE));
                comestiblek.setCodigo(resultSet.getString(FinalBD.TCK_CODIGO));
                comestiblek.setNombre(resultSet.getString(FinalBD.TCK_NOMBRE));
                comestiblek.setMarca(resultSet.getString(FinalBD.TCK_MARCA));
                comestiblek.setfVencimiento(resultSet.getString(FinalBD.TCK_FVENCIMIENTO));
                comestiblek.setPrecio(resultSet.getString(FinalBD.TCK_PRECIO));
                comestiblek.setDescuento(resultSet.getString(FinalBD.TCK_DESCUENTO));
                
                listaComestiblesk.add(comestiblek);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return listaComestiblesk;
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }
                
        return listaComestiblesk;
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Override
    public Carrito infoCarrito(String numero) {
        
        ArrayList<Comestible> arrayListComestiblek=new ArrayList<>();
        ArrayList<Usuario> arrayListUsuario=new ArrayList<>();
        
        String sql="SELECT "+FinalBD.T_COMESTIBLEK+".*, "+FinalBD.T_USUARIO+".*"+
                    " FROM "+FinalBD.T_KARRITO+
                    " JOIN "+FinalBD.T_COMESTIBLEK+
                    " ON "+FinalBD.T_COMESTIBLEK+"."+FinalBD.TCK_CODIGO+"="+FinalBD.T_KARRITO+"."+FinalBD.TK_CODIGO+
                    " JOIN "+FinalBD.T_USUARIO+
                    " ON "+FinalBD.T_USUARIO+"."+FinalBD.TU_CEDULA+"="+FinalBD.T_KARRITO+"."+FinalBD.TK_CEDULA+
                    " WHERE "+FinalBD.T_KARRITO+"."+FinalBD.TK_CODIGO+"='"+numero+"'"+
                    " ORDER BY "+FinalBD.T_KARRITO+"."+FinalBD.TK_ID+" DESC";
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()) {  
                
                Comestible comestiblek=new Comestible();
                comestiblek.setId(resultSet.getInt(FinalBD.TCK_ID));
                comestiblek.setTipoComestible(resultSet.getString(FinalBD.TCK_TIPOCOMESTIBLE));
                comestiblek.setCodigo(resultSet.getString(FinalBD.TCK_CODIGO));
                comestiblek.setNombre(resultSet.getString(FinalBD.TCK_NOMBRE));
                comestiblek.setMarca(resultSet.getString(FinalBD.TCK_MARCA));
                comestiblek.setfVencimiento(resultSet.getString(FinalBD.TCK_FVENCIMIENTO));
                comestiblek.setPrecio(resultSet.getString(FinalBD.TCK_PRECIO));
                comestiblek.setDescuento(resultSet.getString(FinalBD.TCK_DESCUENTO));
                
                
                arrayListComestiblek.add(comestiblek);
                
                Usuario usuario=new Usuario();
                usuario.setId(resultSet.getInt(FinalBD.TU_ID));
                usuario.setCedula(resultSet.getString(FinalBD.TU_CEDULA));
                usuario.setNombre(resultSet.getString(FinalBD.TU_NOMBRE));
                usuario.setAcumulado2(resultSet.getString(FinalBD.TU_ACUMULADO));
                
                arrayListUsuario.add(usuario);
            }           
            
            return new Carrito(arrayListComestiblek, arrayListUsuario);
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e);
            
            return new Carrito(arrayListComestiblek, arrayListUsuario);
            
        }finally{
             try {
                getConexion().close();
            } catch(SQLException e) {
                System.err.println("Error al cerrar la conexion "+e);
            }
        }        
    }

    @Override
    public boolean eliminarValor(Comestible comestible) {
               String sql="DELETE FROM "+FinalBD.T_COMESTIBLEK+" WHERE "+
                                              FinalBD.TCK_ID +"=?";
                                   
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, comestible.getId());
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
                 String sql="DELETE FROM "+FinalBD.T_COMESTIBLEK;
                                    
        
        try {
            Connection connection=getConexion();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.executeUpdate();
            
            System.out.println(" TABLA COMESTIBLE BORRADA CON EXITO");
           
            return true;
            
        } catch(SQLException e) {
            System.err.println("Error al BORRAR el LA TABLA "+e);            
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.reto4j.dao;
/*

*/
public final class FinalBD {
    
    public static final String URL="jdbc:mysql://localhost:3306/";
    public static final String DATABASE="reto4_jonnathan_monroy";
    public static final String USER="root";
    public static final String PASSWORD="";
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++TABLAS DE TIPO PRODUCTO++++++++++++++++++++++++++++++++++++++
    
    
    public static final String T_COMESTIBLE="comestible";
    public static final String TC_ID="id";
    public static final String TC_TIPOCOMESTIBLE="TipoComestible";
    public static final String TC_CODIGO="codigo";
    public static final String TC_NOMBRE="nombre";
    public static final String TC_MARCA="marca";
    public static final String TC_FVENCIMIENTO="fVencimiento";
    public static final String TC_PRECIO="precio";
    public static final String TC_DESCUENTO="descuento";
    
      
    public static final String T_LIQUIDO="liquidos";
    public static final String TL_ID="id";
    public static final String TL_TIPOLIQUIDO="TipoLiquido";
    public static final String TL_CODIGO="codigo";
    public static final String TL_NOMBRE="nombre";
    public static final String TL_MARCA="marca";
    public static final String TL_FVENCIMIENTO="fVencimiento";
    public static final String TL_PRECIO="precio";
    public static final String TL_DESCUENTO="descuento";  
    
        
    public static final String T_ASEO="aseo";
    public static final String TA_ID="id";
    public static final String TA_TIPOASEO="tipoAseo";
    public static final String TA_CODIGO="codigo";
    public static final String TA_NOMBRE="nombre";
    public static final String TA_MARCA="marca";
    public static final String TA_FVENCIMIENTO="fVencimiento";
    public static final String TA_PRECIO="precio";
    public static final String TA_DESCUENTO="descuento";
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++TABLAS DE MODIFICAR CARRITO++++++++++++++++++++++++++++++++++++++
    
        
    public static final String T_COMESTIBLEK="comestiblek";
    public static final String TCK_ID="id";
    public static final String TCK_TIPOCOMESTIBLE="TipoComestible";
    public static final String TCK_CODIGO="codigo";
    public static final String TCK_NOMBRE="nombre";
    public static final String TCK_MARCA="marca";
    public static final String TCK_FVENCIMIENTO="fVencimiento";
    public static final String TCK_PRECIO="precio";
    public static final String TCK_DESCUENTO="descuento";
    
      
    public static final String T_LIQUIDOK="liquidosk";
    public static final String TLK_ID="id";
    public static final String TLK_TIPOLIQUIDO="TipoLiquido";
    public static final String TLK_CODIGO="codigo";
    public static final String TLK_NOMBRE="nombre";
    public static final String TLK_MARCA="marca";
    public static final String TLK_FVENCIMIENTO="fVencimiento";
    public static final String TLK_PRECIO="precio";
    public static final String TLK_DESCUENTO="descuento";  
    
        
    public static final String T_ASEOK="aseok";
    public static final String TAK_ID="id";
    public static final String TAK_TIPOASEO="TipoAseo";
    public static final String TAK_CODIGO="codigo";
    public static final String TAK_NOMBRE="nombre";
    public static final String TAK_MARCA="marca";
    public static final String TAK_FVENCIMIENTO="fVencimiento";
    public static final String TAK_PRECIO="precio";
    public static final String TAK_DESCUENTO="descuento";
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static final String T_USUARIO="usuario";
    public static final String TU_ID="id";
    public static final String TU_NOMBRE="nombre";
    public static final String TU_CEDULA="cedula";
    public static final String TU_ACUMULADO="acumulado";
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    public static final String T_KARRITO="carrito";
    public static final String TK_ID="id";
    public static final String TK_CEDULA="cedula";
    public static final String TK_CODIGO="codigo";
    
 
}

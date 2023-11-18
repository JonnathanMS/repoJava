/*
                 JONNATHAN MONROY SEQUEDA
                     
*/
package com.mycompany.reto4j;

import com.mycompany.reto4j.controlador.ControladorPrincipal;
import com.mycompany.reto4j.dao.DaoAseo;
import com.mycompany.reto4j.dao.DaoCarrito;
import com.mycompany.reto4j.dao.DaoComestible;
import com.mycompany.reto4j.dao.DaoLiquido;
import com.mycompany.reto4j.dao.DaoUsuario;
import com.mycompany.reto4j.dao.IDaoAseo;
import com.mycompany.reto4j.dao.IDaoCarrito;
import com.mycompany.reto4j.dao.IDaoComestible;
import com.mycompany.reto4j.dao.IDaoLiquido;
import com.mycompany.reto4j.dao.IDaoUsuario;
import com.mycompany.reto4j.modelos.Aseo;
import com.mycompany.reto4j.modelos.Carrito;
import com.mycompany.reto4j.modelos.Comestible;
import com.mycompany.reto4j.modelos.Contadores;
import com.mycompany.reto4j.modelos.Liquido;
import com.mycompany.reto4j.modelos.Usuario;
import com.mycompany.reto4j.vista.JFrameReto5;


//clase principal donde se haran las instancias y se ejecuta el programa
public class Principal {
    
    public static void main(String[] args){
        
     Aseo aseo=new Aseo();
     Carrito carrito=new Carrito();
     Comestible comestible=new Comestible();
     Liquido liquido=new Liquido();
     Usuario usuario=new Usuario();
     IDaoComestible iDaoComestible=new DaoComestible();
     IDaoLiquido iDaoLiquido=new DaoLiquido();
     IDaoAseo iDaoAseo=new DaoAseo();
     IDaoCarrito iDaoCarrito=new DaoCarrito();
     IDaoUsuario iDaoUsuario=new DaoUsuario();
     //VistaPrincipal jFrameReto5=new VistaPrincipal();
     JFrameReto5 jFrameReto5= new JFrameReto5();
     Contadores contadores=new Contadores();
     
     ControladorPrincipal controladorPrincipal=new ControladorPrincipal(aseo, carrito, comestible, liquido, usuario, iDaoComestible, iDaoLiquido, iDaoAseo, iDaoCarrito, iDaoUsuario, jFrameReto5,contadores);
     controladorPrincipal.iniciar(); 
     jFrameReto5.setVisible(true);
    }
}
        
    
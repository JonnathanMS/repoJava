/*
 AQUI SE GENERAN METODOS QUE GENERARAN LA INFORMACION USANDO A SU VEZ
LOS METODOS DE LAS LISTAS DAO
 */
package com.mycompany.reto4j.controlador;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ControladorPrincipal implements ActionListener{
    private Aseo aseo;
    private Carrito carrito;
    private Comestible comestible;
    private Liquido liquido;
    public Usuario usuario;
    private IDaoComestible iDaoComestible;
    private IDaoLiquido iDaoLiquido;
    private IDaoAseo iDaoAseo;
    private IDaoCarrito iDaoCarrito;
    private IDaoUsuario iDaoUsuario;
    private JFrameReto5 jFrameReto5;
    private Contadores contadores;
    private DefaultTableModel tableModeltAseo;
    private DefaultTableModel tableModeltComestible;
    private DefaultTableModel tableModeltLiquido;
    private DefaultTableModel tableModeltUsuario;
    private DefaultTableModel tableModeltAseok;
    private DefaultTableModel tableModeltComestiblek;
    private DefaultTableModel tableModeltLiquidok;
    
            
        //constructor que se inicializa en la clase Principal del main.    
    public ControladorPrincipal(Aseo aseo, Carrito carrito, Comestible comestible, Liquido liquido, Usuario usuario, IDaoComestible iDaoComestible, IDaoLiquido iDaoLiquido, IDaoAseo iDaoAseo, IDaoCarrito iDaoCarrito, IDaoUsuario iDaoUsuario, JFrameReto5 jFrameReto5,Contadores contadores) {
        this.aseo = aseo;
        this.carrito = carrito;
        this.comestible = comestible;
        this.liquido = liquido;
        this.usuario = usuario;
        this.iDaoComestible = iDaoComestible;
        this.iDaoLiquido = iDaoLiquido;
        this.iDaoAseo = iDaoAseo;
        this.iDaoCarrito = iDaoCarrito;
        this.iDaoUsuario = iDaoUsuario;
        this.jFrameReto5 = jFrameReto5;
        this.contadores=contadores;
        this.jFrameReto5.bselecC.addActionListener(this);
        this.jFrameReto5.bselecL.addActionListener(this);
        this.jFrameReto5.bselecA.addActionListener(this);
        this.jFrameReto5.bBorrarTablas.addActionListener(this);
        this.jFrameReto5.bLimpiar.addActionListener(this);
        this.jFrameReto5.bDeleteAseo.addActionListener(this);
        this.jFrameReto5.bDeleteComestible.addActionListener(this);
        this.jFrameReto5.bDeleteLiquido.addActionListener(this);
        this.jFrameReto5.bDatosyCostos.addActionListener(this);
        this.jFrameReto5.bRegUsuario.addActionListener(this);


        this.tableModeltAseo=new DefaultTableModel();
        this.tableModeltComestible=new DefaultTableModel();
        this.tableModeltLiquido=new DefaultTableModel();
        this.tableModeltAseok=new DefaultTableModel();
        this.tableModeltComestiblek=new DefaultTableModel();
        this.tableModeltLiquidok=new DefaultTableModel();
        this.tableModeltUsuario=new DefaultTableModel();
    }
    //variables estaticas para realizar los conteos de los elementos sacados del carro
        static int sacadosC=0;
        static int sacadosA=0;
        static int sacadosL=0;
    
 //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++    
 //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++    
 //+++++++++++++++++++++++++++++++EMPIEZAN LOS METODOS+++++++++++++++++++++++++++++++++++++
    public void iniciar(){
        //LE DAMOS NOMBRE LA LAS COLUMNAS DE LAS TABLAS 
        
      //Tablas en el carrito:
             //estas tablas son las que contiene el carro.. la k representa carro
        tableModeltAseok.addColumn("id");
        tableModeltAseok.addColumn("nombre");
        tableModeltAseok.addColumn("precio");
        tableModeltAseok.addColumn("descuento");
        
        jFrameReto5.tAseok.setModel(tableModeltAseok);
        
      
        
        tableModeltComestiblek.addColumn("id");
        tableModeltComestiblek.addColumn("nombre");
        tableModeltComestiblek.addColumn("precio");
        tableModeltComestiblek.addColumn("descuento");
        
        jFrameReto5.tComestiblek.setModel(tableModeltComestiblek);
        
        tableModeltLiquidok.addColumn("id");
        tableModeltLiquidok.addColumn("nombre");
        tableModeltLiquidok.addColumn("precio");
        tableModeltLiquidok.addColumn("descuento");
        
        jFrameReto5.tLiquidok.setModel(tableModeltLiquidok);
      
      //tablas de mostrar en el menu de seleccion de los productos.
       
        tableModeltAseo.addColumn("tipoAseo");
        tableModeltAseo.addColumn("codigo");
        tableModeltAseo.addColumn("nombre");
        tableModeltAseo.addColumn("marca");
        tableModeltAseo.addColumn("fVencimiento");
        tableModeltAseo.addColumn("precio");
        tableModeltAseo.addColumn("descuento");
        
        jFrameReto5.tAseo.setModel(tableModeltAseo);
        
      
        
        tableModeltComestible.addColumn("TipoComestible");
        tableModeltComestible.addColumn("codigo");
        tableModeltComestible.addColumn("nombre");
        tableModeltComestible.addColumn("marca");
        tableModeltComestible.addColumn("fVencimiento");
        tableModeltComestible.addColumn("precio");
        tableModeltComestible.addColumn("descuento");
        
        jFrameReto5.tComestible.setModel(tableModeltComestible);
        
        tableModeltLiquido.addColumn("TipoLiquido");
        tableModeltLiquido.addColumn("codigo");
        tableModeltLiquido.addColumn("nombre");
        tableModeltLiquido.addColumn("marca");
        tableModeltLiquido.addColumn("fVencimiento");
        tableModeltLiquido.addColumn("precio");
        tableModeltLiquido.addColumn("descuento");
        
        jFrameReto5.tLiquido.setModel(tableModeltLiquido);
        
        tableModeltUsuario.addColumn("nombre");
        tableModeltUsuario.addColumn("cedula");
        tableModeltUsuario.addColumn("id");
        
        jFrameReto5.tUsuario.setModel(tableModeltUsuario);
        
        //************************************************************
        
        mostrarComestible(iDaoComestible.verComestible());
        mostrarLiquidos(iDaoLiquido.verLiquido());
        mostrarAseo(iDaoAseo.verAseo());
                
        mostrarComestiblek(iDaoComestible.verComestiblek());
        mostrarLiquidok(iDaoLiquido.verLiquidok());
        mostrarAseok(iDaoAseo.verAseok());
        mostrarUsuario(iDaoUsuario.verUsuario());
        
        
      
    }
    //en este metodo se agregaron las acciones de los botones 
        @Override
    public void actionPerformed(ActionEvent e) {
        //variables que sirven para determinar si se encontraron coincidencias
        boolean encontrado1=false;
        boolean encontrado2=false;
        boolean encontrado3=false;
        boolean encontradoD1=false;
        boolean encontradoD2=false;
        boolean encontradoD3=false;
       
         


        //primer seleccion codigo del producto
        //SE OBTIENE LA INFO REGISTRADA POR EL USUARIO EN EL JFRAME 
        String codigoComestible=jFrameReto5.tfcomestible1.getText();
        String codigoLiquido=jFrameReto5.tfLIquido.getText();
        String codigoAseo=jFrameReto5.tfaseo.getText();
        String nombreUsuario=jFrameReto5.tfNombre.getText();
        String cedulaUsuario=jFrameReto5.tfCedula.getText();
        int idAseo= Integer.parseInt(jFrameReto5.tfAseok.getText());
        int idComestible=Integer.parseInt(jFrameReto5.tfComestibleK.getText());
        int idLiquido=Integer.parseInt(jFrameReto5.tfLiquidok.getText());

        
        //ESTAS FUNCIONES GENERAN LOS OBJETOS EN LAS LISTAS DEL CARRO, TOMANDO 
        //LOS PRODUCTOS REGISTRADOS EN LAS LISTAS DE MOSTRARIO
        if(e.getSource()==jFrameReto5.bRegUsuario){
            if(!nombreUsuario.equals("")&&!cedulaUsuario.equals("")){
                
                usuario.setNombre(nombreUsuario);
                usuario.setCedula(cedulaUsuario);
                String acum=String.valueOf(contadores.getTotalRegalo());
                usuario.setAcumulado2(acum);
                iDaoUsuario.crearUsuario(usuario, acum);
                mostrarUsuario(iDaoUsuario.verUsuario());
                
            }
            else{
                JOptionPane.showMessageDialog(null, "No puede haber campos vacios");
            }
        }
        
        
        if(e.getSource()==jFrameReto5.bselecC){   
        if(!codigoComestible.equals("")){
            for (Comestible valor:iDaoComestible.verComestible()){
               if(valor.getCodigo().equals(codigoComestible)){
                   encontrado1=iDaoComestible.crearComestible(valor);
               }
            }
            if(!encontrado1){
                JOptionPane.showMessageDialog(null,"El codigo de Comestible ingresado no existe. Verifique por favor:");
            }
        }
        } //TERMINA GUARDAR COMESTIBLE EN EL CARRO
        
        if(e.getSource()==jFrameReto5.bselecL){   
        if(!codigoLiquido.equals("")){
            for (Liquido valor:iDaoLiquido.verLiquido()){
               if(valor.getCodigo().equals(codigoLiquido)){
                   encontrado2=iDaoLiquido.crearLiquido(valor);
               }
            }
            if(!encontrado2){
                JOptionPane.showMessageDialog(null,"El codigo de Liquido ingresado no existe. Verifique por favor:");
            }
        }
        } //TERMINA GUARDAR COMESTIBLE EN EL CARRO
        
        if(e.getSource()==jFrameReto5.bselecA){             
        if(!codigoAseo.equals("")){
            for (Aseo valor:iDaoAseo.verAseo()){
               if(valor.getCodigo().equals(codigoAseo)){
                   encontrado3=iDaoAseo.crearAseo(valor);
               }
            }
            if(!encontrado3){
                JOptionPane.showMessageDialog(null,"El codigo de Aseo ingresado no existe. Verifique por favor:");
            }
        }
        }//TERMINA GUARDAR ASEO EN EL CARRO
         if(e.getSource()==jFrameReto5.bBorrarTablas){   
              iDaoComestible.borrarTodo();
              iDaoAseo.borrarTodo();
              iDaoLiquido.borrarTodo();
              iDaoUsuario.borrarTodo();
              
        } //TERMINA  BORRAR TABLAS
              if(e.getSource()==jFrameReto5.bLimpiar){   
              limpiarTexto();
        } //TERMINA limpiar
              
              
        if(e.getSource()==jFrameReto5.bDeleteAseo){   
        if(idAseo!=0){
            for (Aseo valor:iDaoAseo.verAseok()){
               if(idAseo==valor.getId()){
                   encontradoD1=iDaoAseo.eliminarValor(valor);
                   sacadosA=sacadosA+1;
                   contadores.setSacadosA(sacadosA);
               }
            }
            if(!encontradoD1){
                JOptionPane.showMessageDialog(null,"El id de Aseo ingresado no existe. Verifique por favor:");
            }
        }
        } //TERMINA BORRAR ASEO
        
                if(e.getSource()==jFrameReto5.bDeleteComestible){   
        if(idComestible!=0){
            for (Comestible valor:iDaoComestible.verComestiblek()){
               if(idComestible==valor.getId()){
                   encontradoD2=iDaoComestible.eliminarValor(valor);
                   sacadosC=sacadosC+1;
                   contadores.setSacadosC(sacadosC);
               }
            }
            if(!encontradoD2){
                JOptionPane.showMessageDialog(null,"El id de Comestible ingresado no existe. Verifique por favor:");
            }
        }
        } //TERMINA BORRAR Comestible
                
        if(e.getSource()==jFrameReto5.bDeleteLiquido){   
        if(idLiquido!=0){
            for (Liquido valor:iDaoLiquido.verLiquidok()){
               if(idLiquido==valor.getId()){
                   encontradoD3=iDaoLiquido.eliminarValor(valor);
                   sacadosL=sacadosL+1;
                   contadores.setSacadosL(sacadosL);
               }
            }
            if(!encontradoD3){
                JOptionPane.showMessageDialog(null,"El id de Liquido ingresado no existe. Verifique por favor:");
            }
        }
        } //TERMINA BORRAR LIQUIDO
        if(e.getSource()==jFrameReto5.bDatosyCostos){
            String Reg=RegaloAcumulado();
            String tot=costoTotal();
            String cantidad=cantidades();
            JOptionPane.showMessageDialog(null,Reg+"\n"+tot+"\n"+cantidad);
            
        }//TERMINA DATOS  Y COSTOS
        
                
        mostrarComestible(iDaoComestible.verComestible());
        mostrarLiquidos(iDaoLiquido.verLiquido());
        mostrarAseo(iDaoAseo.verAseo());
                
        mostrarComestiblek(iDaoComestible.verComestiblek());
        mostrarLiquidok(iDaoLiquido.verLiquidok());
        mostrarAseok(iDaoAseo.verAseok());
        mostrarUsuario(iDaoUsuario.verUsuario());
        
        
      
    }//terminal actionPerformed
    
    
    
        //muestra la lista de comestibles que estan en la tabla de sql 
        //informacion que se registro a su vez en el ArrayList listaComestible
        //que toma como parametro
    
        private void mostrarComestible(ArrayList<Comestible> listaComestibles) {
        
        if(tableModeltComestible.getRowCount()>0){
            for (int i = tableModeltComestible.getRowCount()-1; i > -1; i--) {
                tableModeltComestible.removeRow(i);
            }
        }
        //SE GENERA LA INFORMACION DE LAS FILAS DE LAS TABLAS DE JFRAME
        //A PARTIR DEL ARRAY SE SACAN LOS DATOS PARA CADA COLUMNA DE LA FILA
        for (int i = 0; i < listaComestibles.size(); i++) {
            
            String datos[]=new String[7];
            datos[0]=listaComestibles.get(i).getTipoComestible();
            datos[1]=listaComestibles.get(i).getCodigo();
            datos[2]=listaComestibles.get(i).getNombre();
            datos[3]=listaComestibles.get(i).getMarca();
            datos[4]=listaComestibles.get(i).getfVencimiento();
            datos[5]=listaComestibles.get(i).getPrecio();
            datos[6]=listaComestibles.get(i).getDescuento();
            
//            vistaApp.setMostrarVuelo(datos);

            tableModeltComestible.addRow(datos);
            
            jFrameReto5.tComestible.setModel(tableModeltComestible);
        }
    }//termina mostrarComestible
    
        //muestra la lista de liquidos que estan en la tabla de sql 
        //informacion que se registro a su vez en el ArrayList listaLiquido
        //que toma como parametro
    private void mostrarLiquidos(ArrayList<Liquido> listaLiquido) {
        
        if(tableModeltLiquido.getRowCount()>0){
            for (int i = tableModeltLiquido.getRowCount()-1; i > -1; i--) {
                tableModeltLiquido.removeRow(i);
            }
        }
        
        for (int i = 0; i < listaLiquido.size(); i++) {
            
            String datos[]=new String[7];
            datos[0]=listaLiquido.get(i).getTipoLiquido();
            datos[1]=listaLiquido.get(i).getCodigo();
            datos[2]=listaLiquido.get(i).getNombre();
            datos[3]=listaLiquido.get(i).getMarca();
            datos[4]=listaLiquido.get(i).getfVencimiento();
            datos[5]=listaLiquido.get(i).getPrecio();
            datos[6]=listaLiquido.get(i).getDescuento();
            
//            vistaApp.setMostrarVuelo(datos);

            tableModeltLiquido.addRow(datos);
            
            jFrameReto5.tLiquido.setModel(tableModeltLiquido);
        }
    }//termina mostrarLiquidos
             
    //muestra los productos de aseo , la lista que esta en una tabla de sql.
    //los cuales se agregaron en el ArrayList listaAseo que toma como parametro
        private void mostrarAseo(ArrayList<Aseo> listaAseo) {
        
        if(tableModeltAseo.getRowCount()>0){
            for (int i = tableModeltAseo.getRowCount()-1; i > -1; i--) {
                tableModeltAseo.removeRow(i);
            }
        }
        
        for (int i = 0; i < listaAseo.size(); i++) {
            
            String datos[]=new String[7];
            datos[0]=listaAseo.get(i).getTipoAseo();
            datos[1]=listaAseo.get(i).getCodigo();
            datos[2]=listaAseo.get(i).getNombre();
            datos[3]=listaAseo.get(i).getMarca();
            datos[4]=listaAseo.get(i).getfVencimiento();
            datos[5]=listaAseo.get(i).getPrecio();
            datos[6]=listaAseo.get(i).getDescuento();
            

            tableModeltAseo.addRow(datos);
            
            jFrameReto5.tAseo.setModel(tableModeltAseo);
        }
    }//termina mostrarAseo   


        //muestra los productos agregados en la tabla liquidok del carrito en sql.
        //los cuales se agregaron previamente en la lista que toma como parametro
        private void mostrarLiquidok(ArrayList<Liquido> listaLiquidok) {
        
        if(tableModeltLiquidok.getRowCount()>0){
            for (int i = tableModeltLiquidok.getRowCount()-1; i > -1; i--) {
                tableModeltLiquidok.removeRow(i);
            }
        }
        
        for (int i = 0; i < listaLiquidok.size(); i++) {
            
            String datos[]=new String[4];
            datos[0]=String.valueOf(listaLiquidok.get(i).getId());
            datos[1]=listaLiquidok.get(i).getNombre();
            datos[2]=listaLiquidok.get(i).getPrecio();
            datos[3]=listaLiquidok.get(i).getDescuento();
            
//            vistaApp.setMostrarVuelo(datos);

            tableModeltLiquidok.addRow(datos);
            
            jFrameReto5.tLiquidok.setModel(tableModeltLiquidok);
        }
    }//termina mostrarLiquidok 


//muestra la lista de comestibles en el carro tomando la lista como parametro
        private void mostrarComestiblek(ArrayList<Comestible> listaComestiblek) {
        
        if(tableModeltComestiblek.getRowCount()>0){
            for (int i = tableModeltComestiblek.getRowCount()-1; i > -1; i--) {
                tableModeltComestiblek.removeRow(i);
            }
        }
        
        for (int i = 0; i < listaComestiblek.size(); i++) {
            
            String datos[]=new String[4];
            datos[0]=String.valueOf(listaComestiblek.get(i).getId());
            datos[1]=listaComestiblek.get(i).getNombre();
            datos[2]=listaComestiblek.get(i).getPrecio();
            datos[3]=listaComestiblek.get(i).getDescuento();
            
//            vistaApp.setMostrarVuelo(datos);

            tableModeltComestiblek.addRow(datos);
            
            jFrameReto5.tComestiblek.setModel(tableModeltComestiblek);
        }
    }//termina mostrarAseo 
    
//muestra la lista de aseo en el carro tomando la lista como parametro

    private void mostrarAseok(ArrayList<Aseo> listaAseok) {
        
        if(tableModeltAseok.getRowCount()>0){
            for (int i = tableModeltAseok.getRowCount()-1; i > -1; i--) {
                tableModeltAseok.removeRow(i);
            }
        }
        
        for (int i = 0; i < listaAseok.size(); i++) {
            
            String datos[]=new String[4];
            datos[0]=String.valueOf(listaAseok.get(i).getId());
            datos[1]=listaAseok.get(i).getNombre();
            datos[2]=listaAseok.get(i).getPrecio();
            datos[3]=listaAseok.get(i).getDescuento();
            

            tableModeltAseok.addRow(datos);
            
            jFrameReto5.tAseok.setModel(tableModeltAseok);
        }
    }//termina mostrarAseok  

        //muestra la info del usuario tomandolo como parametro
        private void mostrarUsuario(ArrayList<Usuario> usuario) {
        
        if(tableModeltUsuario.getRowCount()>0){
            for (int i = tableModeltUsuario.getRowCount()-1; i > -1; i--) {
                tableModeltUsuario.removeRow(i);
            }
        }
       /* int indice=0;
        if(usuario.size()==0){
            indice=0;
        }else{
            indice=usuario.size()-1;
        }*/
       
       if(usuario.size()!=0){
            String datos[]=new String[4];
            datos[0]=usuario.get(0).getNombre();
            datos[1]=usuario.get(0).getCedula();
            datos[2]=usuario.get(0).getAcumulado2();
            datos[3]=String.valueOf(usuario.get(0).getId());
       
            

            tableModeltUsuario.addRow(datos);
            
            jFrameReto5.tUsuario.setModel(tableModeltUsuario);
       }
       else{
            JOptionPane.showMessageDialog(null,"Por favor actualize los datos de Usuario");
            }
      
        
    }//termina mostrarUsuario  
        //limpia las casillas de texto
            public void limpiarTexto(){
        
        jFrameReto5.tfAseok.setText("0");
        jFrameReto5.tfLiquidok.setText("0");
        jFrameReto5.tfComestibleK.setText("0");
        jFrameReto5.tfaseo.setText(null);
        jFrameReto5.tfLIquido.setText(null);
        jFrameReto5.tfcomestible1.setText(null);
        jFrameReto5.tfNombre.setText(null);
        jFrameReto5.tfCedula.setText(null);
    }
            
          //calcula el valor de regalo segun las existencias de los productos en ese
            //momento en el carrito
       public String RegaloAcumulado(){

       long precio;
       long precioConvertidoA=0;
       for(Aseo value:iDaoAseo.verAseok()){
           precio=Long.valueOf(value.getPrecio());
           precioConvertidoA=value.valorRegalo(precio);
       }
       precio=0;
       long precioConvertidoC=0;
       for(Comestible value:iDaoComestible.verComestiblek()){
           precio=Long.valueOf(value.getPrecio());
           precioConvertidoC=value.valorRegalo(precio);
       }
       precio=0;
       long precioConvertidoL=0;
       for(Liquido value:iDaoLiquido.verLiquidok()){
           precio=Long.valueOf(value.getPrecio());
           precioConvertidoL=value.valorRegalo(precio);
       }
       String Regalo=("\nEL TOTAL ACUMULADO DE REGALO ES: "+(precioConvertidoA+precioConvertidoC+precioConvertidoL));
       contadores.setTotalRegalo((precioConvertidoA+precioConvertidoC+precioConvertidoL));
       Usuario.setAcumulado(0);
       return Regalo;
    }  
       
       
        //CALCULA EL VALOR TOTAL DE LOS PRODUCTOS AL MOMENTO EN EL CARRITO
    public  String costoTotal(){
        double costoT=0;
        if(!iDaoComestible.verComestiblek().isEmpty()){
        for(Comestible value:iDaoComestible.verComestiblek()){
            costoT+=value.ivayDescuento(value.getPrecio(),value.getDescuento());
        }
        } 
        if(!iDaoLiquido.verLiquidok().isEmpty()){
        for(Liquido value:iDaoLiquido.verLiquidok()){
            costoT+=value.ivayDescuento(value.getPrecio(),value.getDescuento());
        }
        } 
        if(!iDaoAseo.verAseok().isEmpty()){
        for(Aseo value:iDaoAseo.verAseok()){
            costoT+=value.ivayDescuento(value.getPrecio(),value.getDescuento());
        }
        }
        String costoTotal=("\nEl costo total de compras iva y descuentos aplicados es:  $"+costoT);
        return costoTotal;
    }
    
    
        //esta funcion muestra los valores de las cantidades  u estadisticas de los
    // productos que hay en el carro y los que fueron sacados, etc..
    String cantidades(){
        int cantComestibles=iDaoComestible.verComestiblek().size();
        int cantAseo=iDaoAseo.verAseok().size();
        int cantLiquidos=iDaoLiquido.verLiquidok().size();
        int totales=cantComestibles+cantLiquidos+cantAseo;
        String info=("Cantidad de comestibles en el carro: "+cantComestibles+
                "\nCantidad de productos de Aseo en el carro: "+cantAseo+
                "\nCantidad de productos Liquidos en el carro: "+cantLiquidos+
                "\nCANTIDAD TOTAL DE PRODUCTOS EN EL CARRO: "+totales+
                "\nComestibles sacados: "+contadores.getSacadosC()+"  Aseo sacados: "+contadores.getSacadosA()+"  Liquidos sacados: "+contadores.getSacadosL()+
                "\n Total sacados: "+(contadores.getSacadosC()+contadores.getSacadosA()+contadores.getSacadosL()));
        return info;
    }

    
}
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page import="Modelo.Producto"%>
<%@page import="controlador.ProductoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Lista Productos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body background ="lel.jpg">
       
            <div style="text-align: center;">
                <form method="get" action="BuscarProducto" name="BuscarProducto">
                    <FONT FACE="impact" SIZE="6" COLOR="black"> INVENTARIO </FONT><br>
                    <table border="2px"  >
            <tr>
               <td WIDTH="320">Id</td>
               <td WIDTH="320">Nombre</td> 
               <td WIDTH="320">Apellido</td>
               <td WIDTH="320" >Precio</td> 
            </tr>
            
                   
                      <%
                ArrayList<Producto> a =new ArrayList ();
                int id ;
                int dura;
                int valor;
               char[] am=new char[20];
               ProductoDao lis = new ProductoDao();
               a=lis.listarTodo();
               for(int i=0; i<a.size();i++){
               id=a.get(i).getId();
               am=a.get(i).getDescripcion();
               dura=a.get(i).getCantidad();
               valor=a.get(i).getValor();
               %>  
                <br>
               <tr>
               <td WIDTH="320"><%=id%></td>
               <td WIDTH="320"><%=am%></td>
               <td WIDTH="320"><%=dura%></td>
               <td WIDTH="320"><%=valor%></td> 
        </tr>
        
               <%
               } 
                   
        %>   
          </table>      
          <br>
                    
                </form>
    </body>
</html>


<%@page import="controlador.EmpleadoDao"%>
<%@page import="Modelo.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
        <title>Buscar Empleado
        </title></head><body Background="lel.jpg">
            <div style="text-align: center;">
                    <form method="get" action="BusquedaEmpleados" name="BusquedaEmpleados">
                     <FONT FACE="impact" SIZE="6" COLOR="black"> Buscar Empleado </FONT><br>
                    <br>Por favor ingrese el Codigo del Empleado que desea encontrar:<br>
                     ID: <input name="codigo" type="text"><br>
                    <br>
                    <input name="Buscar" type="submit">
                </form>
                 <%
         Empleado empdo = (Empleado)request.getAttribute("empleado");
           if(empdo != null){
               EmpleadoDao empleado = new EmpleadoDao();
               empleado.ListarUnitario(empdo.getCodigo());
               int id = empleado.codigo;
               String nombre = empleado.nuevo1;
               int dura = empleado.dur;
             
        %>   
          <br>
        <table style="position:absolute;top:200px;left:600px ">
            <tr>
               <td>Codigo</td>
               <td>Nombre</td> 
               <td>Duracion</td>
              
            </tr>
            <tr>
               <td><%=id%></td>
               <td><%=nombre%></td>
               <td><%=dura%></td>
               
        </tr>
        </table>
        
        <%
           }
        %>
            </div>
        </body>
</html>
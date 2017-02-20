<%-- 
    Document   : ListaInscripciones
    Created on : 19/02/2017, 11:41:03 PM
    Author     : crist
--%>

<%@page import="Modelo.Inscripciones"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controlador.InscripcionesDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar profesores</title>
    </head>
    <body>
        <h1>Lista de cursos inscritos</h1>
        <%
            InscripcionesDAO ins = new InscripcionesDAO();
            ArrayList<Inscripciones> ary1 = ins.listarTodo();
            for (int i = 0; i < ary1.size(); i++) {
                int idEstu = ary1.get(i).getIdEst();
                int idCurso = ary1.get(i).getIdCurso();
                String fechaIns = "";
                for (int j = 0; j < ary1.get(i).getFecha_ins().length; j++) {
                   fechaIns = fechaIns + ary1.get(i).getFecha_ins()[j];
                }
                String fechaFin = "";
                for (int j = 0; j < ary1.get(i).getFecha_fin().length; j++) {
                   fechaFin = fechaFin + ary1.get(i).getFecha_fin()[j];
                }
                int nota = ary1.get(i).getNota();
                
        %>   
        <br>
        <table >
            <tr>
                <td>Id del Estudiante</td>
                <td>Id del curso</td> 
                <td>Fecha de incripcion</td>
                <td>Fecha de finalizacion</td>
                <td>Nota</td>
            </tr>
            <tr>
                <td><%=idEstu%></td>
                <td><%=idCurso%></td>
                <td><%=fechaIns%></td>
                <td><%=fechaFin%></td>
                <td><%=nota%></td> 
            </tr>
        </table>

        <%
            }
        %>
    </body>
</html>

<%-- 
    Document   : carrito
    Created on : 05-dic-2016, 9:39:50
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.ProductoComprado"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.fpmislata.domain.Usuario"%>
<%@page import="com.fpmislata.domain.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
	<h1>Listado de Productos</h1>
        
        
        <% 
            String mensajeError = (String) request.getAttribute("mensajeError");
            if(mensajeError.equals("")){
                
            }else{ %>
            <h2><%=mensajeError%></h2>
                    <%
            }
        %>
        
        <% 
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
            if(usuario == null){
                %>
                <a href="login.jsp">Login Usuario</a>
                <%
            }else{ %>
            Bienvenido ${usuario.getNombre()} ${usuario.getApellidos()}
                    <%
            }
        %>
        
	
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th></th>
		</tr>

                <%
                ArrayList<Producto> listaProductos = (ArrayList) session.getAttribute("listaProductos");
                for(Producto producto : listaProductos){
                    
                    int id = producto.getId();
                    String nombre = producto.getNombre();
                    float precio = producto.getPrecio();
                    String ubicacionImagen = producto.getUbicacionImagen();
                %>
                
                <tr>
                    <form action="AddServlet?id=<%=id%>" method="POST">
                        <td><%=id%></td>
                        <td><%=nombre%></td>
                        <td><%=precio%></td>
                        <td>
                            <select name="cantidad">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                            </select>
                        </td>
                        <td><input type="submit" value="Añadir Producto"/></td>
                    </form>
                </tr>
                <% } %>
	</table>
        
        <%
            Hashtable<Integer, ProductoComprado> listaCompra = (Hashtable<Integer, ProductoComprado>) session.getAttribute("listaCompra");
            if((usuario!=null)&&(listaCompra.size()>0)){
        %> <a href="CierreCompraServlet">Finalizar Compra</a> <%
            }
        %>
</body>
</html>

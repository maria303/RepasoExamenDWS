<%-- 
    Document   : carrito
    Created on : 05-dic-2016, 9:39:50
    Author     : alumno
--%>

<%@page import="com.fpmislata.domain.Factura"%>
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
	<h1>Factura</h1>
        
        <% 
            Factura factura = (Factura) request.getAttribute("factura");
            
        %>
        Nombre: <%=factura.getUsuario().getNombre()%>
        Apellidos: <%factura.getUsuario().getApellidos()%>
	
	<br/>
	<br/>

	<table border="1">
		<tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
		</tr>

                <%
                Hashtable<Integer, ProductoComprado> listaProductos = (Hashtable<Integer, ProductoComprado>) factura.getListaCompra();
                for(int i=0; i<listaProductos.size(); i++){
                    
                    Producto producto = listaProductos.get(i).getProducto();
                    int id = producto.getId();
                    String nombre = producto.getNombre();
                    float precio = producto.getPrecio();
                    int cantidad = listaProductos.get(i).getCantidad();
                    float subtotal = precio + cantidad;
                    
                %>
                
                <tr>
                        <td><%=id%></td>
                        <td><%=nombre%></td>
                        <td><%=precio%></td>
                        <td><%=cantidad%></td>
                        <td><%=subtotal%></td>
                </tr>
                <% } %>
	</table>
</body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fpmislata.servlets;

import com.fpmislata.domain.Producto;
import com.fpmislata.domain.ProductoComprado;
import com.fpmislata.service.ProductoServiceLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alumno
 */
public class AddServlet extends HttpServlet {

    @EJB
    private ProductoServiceLocal productoService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("id");
        String cantidad = request.getParameter("cantidad");
        
        Producto p = new Producto();
        p.setId(Integer.valueOf(id));
        
        p = productoService.findById(p);
        
        if(p == null){
            request.setAttribute("mensajeError", "No existe el producto seleccionado");
            RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
            rd.forward(request, response);
        }else{
            //Creamos un producto comprado
            ProductoComprado pc = new ProductoComprado(p.getId(), p, Integer.valueOf(cantidad));
            
            //Recuperamos la hastable de la sesión
            Hashtable<Integer, ProductoComprado> compra = (Hashtable<Integer, ProductoComprado>) request.getSession().getAttribute("listaCompra");
            
            //Comprobamos si tenemos en la hastable el producto comprado ya añadido
            ProductoComprado comprado = compra.get(pc.getId());
            
            //Si no lo tenemos lo añadimos
            if(comprado == null){
                compra.put(pc.getId(), pc);
            }else{
                //Si ya lo hemos añadido cambiamos las cantidades y lo añadimos de nuevo                
                comprado.setCantidad(comprado.getCantidad()+pc.getCantidad());
                compra.replace(comprado.getId(), comprado);
            }
            //Tras finalizar la compra del producto nos manda al carrito de nuevo
            
            //Carrito de la compra
            request.getSession().setAttribute("listaCompra", compra);

            //Mensaje error
            request.setAttribute("mensajeError", "");
            
            //Carja del JSP
            RequestDispatcher rd = request.getRequestDispatcher("carrito.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.serverlet_coworking;

import Logica.ClassUser;
import Logica.controladora;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svListaReservas", urlPatterns = {"/svListaReservas"})
public class svListaReservas extends HttpServlet {
// en el serverlet Listas Reservadas relacionamos un objeto con la controladora
    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    // Creamos un metodo vacio que enliste a los registros de las reservas y los mande a Reservas.jsp
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<ClassUser> ListUsers = new ArrayList<>();
        
        ListUsers = control.ListUsers();
        
        HttpSession sesion= request.getSession();
        sesion.setAttribute("ListUsers", ListUsers);
        
        response.sendRedirect("Reservas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

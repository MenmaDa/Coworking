package com.mycompany.serverlet_coworking;

import Logica.controladora;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "svEliminarReserva", urlPatterns = {"/svEliminarReserva"})
public class svEliminarReserva extends HttpServlet {

    //agregue la controladora
    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    //Creamos el metodo que envia por medio del id que seccion debe eliminar 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int id_eliminar = Integer.parseInt(request.getParameter("id_usuario"));
            control.DeleteUser(id_eliminar);
            response.sendRedirect("index.jsp");
        }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

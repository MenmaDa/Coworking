/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.serverlet_coworking;

import Logica.ClassUser;
import Logica.controladora;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "svReserva", urlPatterns = {"/svReserva"})
public class svReserva extends HttpServlet {

    // en el serverlet reserva relacionamos un objeto con la controladora
    controladora control = new controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    // en el metodo post relacionamos las entidades con variables
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String Nombre_usu = request.getParameter("Nombre_usu");
        String Fecha_Reserva = request.getParameter("Fecha_Reserva");
        String Espacio_Trabajo = request.getParameter("Espacio_Trabajo");
        String Duracion_Inicio = request.getParameter("Duracion_Inicio");
        String Duracion_Fin = request.getParameter("Duracion_Fin");
        
        String errorMessage = null;
        //En esta seccion nos ayuda a validar que los datos no tengan fechas anteriores, que la hora de inicio y fin sean coherentes y 
        //que en el espacio de trabajo se tenga que seleccionar una parte de su contenido osea que no este vacio.
        try {
            String Inicio = Duracion_Inicio.replaceAll(":", "");
            int DuracionInicio = Integer.parseInt(Inicio);
            String Final = Duracion_Fin.replaceAll(":", "");
            int DuracionFinal = Integer.parseInt(Final);
            LocalDate fecha_reservada = LocalDate.parse(Fecha_Reserva, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate fecha_hoy = LocalDate.now();
            
            if (fecha_reservada.isBefore(fecha_hoy)) {
                errorMessage = "La fecha de la reserva no puede ser anterior a la fecha actual.";
            }
            //generamos los mensajes de error del espacio de trabajo
            if (Espacio_Trabajo == "" || Espacio_Trabajo == null) {
            errorMessage = "El campo de Espacio de Trabajo es obligatorio.";
            }
            //generamos los mensajes de error de la duracion total
            if (DuracionInicio > DuracionFinal) {
               errorMessage = "La duracion de Inicio y la Duracion del final son incorrectas."; 
            }
        //generamos los mensajes de error de la fecha
        } catch (NumberFormatException  e) {
            errorMessage = "La fecha ingresada es inválida. Asegúrate de ingresar una fecha válida.";
        }
        //Enviamos el error al index
        if (errorMessage != null) {
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher Respuesta_Error = request.getRequestDispatcher("index.jsp");
            Respuesta_Error.forward(request, response);
        }
        else{
            //En caso de que todo este correcto, que mande los datos a la controladora
            ClassUser usu = new ClassUser();
            usu.setNombre_usu(Nombre_usu);
            usu.setFecha_Reserva(Fecha_Reserva);
            usu.setEspacio_Trabajo(Espacio_Trabajo);
            usu.setDuracion_Inicio(Duracion_Inicio);
            usu.setDuracion_Fin(Duracion_Fin);

             control.CreateUser(usu);

            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

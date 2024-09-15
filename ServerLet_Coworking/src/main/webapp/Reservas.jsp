<%@page import="java.util.List"%>
<%@page import="Logica.ClassUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contenedor">
            <header class="header">           
            </header>
            <main class="contenido">
                <h1>Lista de las reservas</h1>
                <br><br>
                <!-- Se enlistan los datos recoriendo la ClassUser usu-->
        <%
                List<ClassUser> ListUsers = (List) request.getSession().getAttribute("ListUsers");
                int cont = 1;
                for (ClassUser usu : ListUsers) {
                    
            %>
            <center>
                    <p name="label"><b>Usuario N° <%=cont%> </b></p>
                    <p name="label">Id: <%=usu.getId_usu()%></p>
                    <p name="label">Usuario: <%=usu.getNombre_usu()%></p>
                    <p name="label">Fecha de Reserva: <%=usu.getFecha_Reserva()%></p>
                    <p name="label">Espacio de Trabajo: <%=usu.getEspacio_Trabajo()%></p>
                    <p name="label">Duracion de la reserva: <%=usu.getDuracion_Inicio()%> a <%=usu.getDuracion_Fin()%></p>
            </center>
                    <form action="svEliminarReserva" method="POST">
                        <button type="submit" name="id_usuario" value="<%=usu.getId_usu()%>" placeholder="Eliminar usuario">Eliminar</button>
                    </form>
                    <!-- En la seccion de eliminar nos lleva al serverlet eliminar enviandole la respectiva id-->
                    <br>
                    <center>
                        <hr>
                    </center>
                    <!-- el contador es para que pueda seguir recogiendo los proximos registros de las reservas -->
            <%
                    cont = cont + 1;
                }
            %>
            </main>
            <footer class="footer">
                <p>@ copyright</p>
            </footer>
        </div>
    </body>
</html>

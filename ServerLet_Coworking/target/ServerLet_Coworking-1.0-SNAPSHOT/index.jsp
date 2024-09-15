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
                <h1>Realizar reserva</h1>
                <!-- Se crea el formulario con los datos que se necesita para hacer la reserva -->
                <form action="svReserva" method="POST">
                    <p><label>Nombre del usuario: </label><input type="text" name="Nombre_usu" required></p>
                    <p><label>Fecha de reserva: </label><input type="date" name="Fecha_Reserva" required></p>
                    <!-- -->
                    <p><label>Espacios de trabajo disponibles: </label><select id="Espacio_Trabajo" name="Espacio_Trabajo">
                            <option value="">--- Selecciona ---</option>
                            <option value="Coworking sectorial y multisectorial">Coworking sectorial y multisectorial</option>
                            <option value="Coworking abierto y semiabierto">Coworking abierto y semiabierto</option>
                            <option value="Pop up Coworking">Pop up Coworking</option>
                            <option value="Coworking flexible">Coworking flexible</option>
                            <option value="Coworking fijo">Coworking fijo</option>
                            <option value="Coworking nómada">Coworking nómada</option>
                            <option value="Coworking nocturno">Coworking nocturno</option>
                            <option value="Coworking Smart">Coworking Smart</option>
                        </select>
                    </p>
                    <p><label>Inicio de la reserva: </label><input type="time" name="Duracion_Inicio" required> <label>Fin de la reserva </label><input type="time" name="Duracion_Fin"></p>
                    <!-- Esta parte es la seccion que le envia el mensaje de error al usuario por haber digitado algo que hubiese tenido alguna incoherencia -->
                    <% 
                        String errorMessage = (String) request.getAttribute("errorMessage");
                        if (errorMessage != null) {
                    %>
                
                    <div style="color: red; font-weight: bold;">
                        <%= errorMessage %>
                    </div>
                    <% 
                        }
                    %>
                        <button type="submit">Enviar</button>
                        
                </form>
                
                    <!-- Aqui llamamos al serverlet reservas oara enlistar los usuarios -->
                <h1>Ver reserva</h1>
                <p>Para ver los datos cargados haga click en el siguiente boton</p>
                <form action="svListaReservas" method="GET">
                    <button type="submit">Mostrar reserva</button>
                </form>
            </main>
            <footer class="footer">
                <p>@ copyright</p>
            </footer>
        </div>
    </body>
</html>

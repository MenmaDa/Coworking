package Logica;

import java.util.List;
import persistencia.controladoraPersistencia;

public class controladora {
    //involucra a la controladora de la persistencia lo cual nos involucra a crear la persistencia
    controladoraPersistencia controlPersis = new controladoraPersistencia();

    //Enviamos los datos recogidos en usu a la controladora de la persistencia al metodo crear Reservas/Usuarios
    public void CreateUser (ClassUser usu){
        controlPersis.CreateUser(usu);
    }
    //Enlistamos y enviamos los datos recogidos en usu a la controladora de la persistencia al metodo Enlistar Reservas/Usuarios 
    public List<ClassUser> ListUsers(){
        return controlPersis.ListUsers();
    }
    //enviamos los datos recogidos en usu a la controladora de la persistencia al metodo Eliminar Reservas/Usuarios
    public void DeleteUser (int id_eliminar) {
        controlPersis.DeleteUser(id_eliminar);
    }
}

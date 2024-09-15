//Esto para cumplir con el modelo de capas
//Agregamos en logica una clase controladora Java Class
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Logica.ClassUser;
import persistencia.exceptions.NonexistentEntityException;

public class controladoraPersistencia {
    //Creamos un objeto sobre el Jpa Controller y hacemos los metodos que necesitamos.
    ClassUserJpaController usuJpa = new ClassUserJpaController();
    
    //CREATE
    public void CreateUser(ClassUser usu){
        usuJpa.create(usu);
    }
    
    //READ
    public List<ClassUser> ListUsers(){
        return usuJpa.findClassUserEntities();
    }

    //DELETE
    public void DeleteUser(int id_eliminar) {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(controladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

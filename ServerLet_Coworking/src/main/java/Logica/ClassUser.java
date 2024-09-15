package Logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// En esta clase usuario se crean las entidades de la tabla que se necesitan ser llenados por el usuarios
@Entity
public class ClassUser implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private int id_usu;
    private String Nombre_usu ;
    private String Fecha_Reserva;
    private String Espacio_Trabajo;
    private String Duracion_Inicio;
    private String Duracion_Fin;
 
    public ClassUser() {
        
    }
    //generamos un constructor para la clase usuario
    public ClassUser(int id_usu, String Nombre_usu, String Fecha_Reserva, String Espacio_Trabajo, String Duracion_Inicio, String Duracion_Fin) {
        this.id_usu = id_usu;
        this.Nombre_usu = Nombre_usu;
        this.Fecha_Reserva = Fecha_Reserva;
        this.Espacio_Trabajo = Espacio_Trabajo;
        this.Duracion_Inicio = Duracion_Inicio;
        this.Duracion_Fin = Duracion_Fin;
    }
//Le añadimos sus respectivos setters y getters
    public int getId_usu() {
        return id_usu;
    }

    public String getNombre_usu() {
        return Nombre_usu;
    }

    public String getFecha_Reserva() {
        return Fecha_Reserva;
    }

    public String getEspacio_Trabajo() {
        return Espacio_Trabajo;
    }

    public String getDuracion_Inicio() {
        return Duracion_Inicio;
    }

    public String getDuracion_Fin() {
        return Duracion_Fin;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public void setNombre_usu(String Nombre_usu) {
        this.Nombre_usu = Nombre_usu;
    }

    public void setFecha_Reserva(String Fecha_Reserva) {
        this.Fecha_Reserva = Fecha_Reserva;
    }

    public void setEspacio_Trabajo(String Espacio_Trabajo) {
        this.Espacio_Trabajo = Espacio_Trabajo;
    }

    public void setDuracion_Inicio(String Duracion_Inicio) {
        this.Duracion_Inicio = Duracion_Inicio;
    }

    public void setDuracion_Fin(String Duracion_Fin) {
        this.Duracion_Fin = Duracion_Fin;
    }
    
}

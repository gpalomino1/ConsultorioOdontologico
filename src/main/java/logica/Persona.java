
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)//CUANDO SE UTILIZA table per clas, la teortia dice que es buena práctica que el id esté en la madre (JPA)
public class Persona implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //IDENTITY para que el id sea secuencial
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String direccion;
    @Temporal(TemporalType.DATE)
    private Date Fecha_nac;

    public Persona() {
    }

    public Persona(int id, String dni, String nombre, String apellido, String direccion, Date Fecha_nac) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.Fecha_nac = Fecha_nac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

  
    
}

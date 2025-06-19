
package logica;
import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable {
    
    
    private String especialidad;
    @OneToMany(mappedBy="odonto")//VA A IR A LA CLASE TURNO Y VA A BUSCAR ALGO QUE SE LLAME al objeto odonto
    private List<Turno> listaTurnos;//la FK va del lado de la n es decir de Turnos (pero la collectión/lista va del lado del 1)esto en las clases, (pq se ve q en la base de datos es al rebés..)
   
    @OneToOne
    private Usuario unUsuario;
    @OneToOne
    private Horario unHorario;

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario, int id, String dni, String nombre, String apellido, String direccion, Date Fecha_nac) {
        super(id, dni, nombre, apellido, direccion, Fecha_nac);
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

   

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }
    
    
    
    
}

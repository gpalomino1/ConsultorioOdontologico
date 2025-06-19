
package logica;
import java.io.Serializable;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/*
las relaciones en java se hacen mediante  clases o colecciones
    cuando la relacion es de 1 a 1 se hacen instáncias de clases y se crean objetos
    cuando la relacion es n es mediante colections
*/ 
@Entity
public class Paciente extends Persona implements Serializable {
    
   
    private boolean tiene_S_M;
    private String tipoSangre;
    @OneToOne
    private Responsable unResponsable;
    @OneToMany(mappedBy="pacien")
    private List<Turno> listaTurnos;

    public Paciente() {
    }

    public Paciente(boolean tiene_S_M, String tipoSangre, Responsable unResponsable, List<Turno> listaTurnos, int id, String dni, String nombre, String apellido, String direccion, Date Fecha_nac) {
        super(id, dni, nombre, apellido, direccion, Fecha_nac);
        this.tiene_S_M = tiene_S_M;
        this.tipoSangre = tipoSangre;
        this.unResponsable = unResponsable;
        this.listaTurnos = listaTurnos;
    }

   

   

    public Responsable getUnResponsable() {
        return unResponsable;
    }

    public void setUnResponsable(Responsable unResponsable) {
        this.unResponsable = unResponsable;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    

    public boolean isTiene_S_M() {
        return tiene_S_M;
    }

    public void setTiene_S_M(boolean tiene_S_M) {
        this.tiene_S_M = tiene_S_M;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
 
    
    
    
    
    
}

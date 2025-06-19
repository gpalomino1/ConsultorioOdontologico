
package logica;
import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Responsable extends Persona {
    
    
    private String tipo_resp;

    public Responsable() {
    }

    public Responsable(String tipo_resp, int id, String dni, String nombre, String apellido, String direccion, Date Fecha_nac) {
        super(id, dni, nombre, apellido, direccion, Fecha_nac);
        this.tipo_resp = tipo_resp;
    }

   


 

    public String getTipo_resp() {
        return tipo_resp;
    }

    public void setTipo_resp(String tipo_resp) {
        this.tipo_resp = tipo_resp;
    }
    
    
    
    
}

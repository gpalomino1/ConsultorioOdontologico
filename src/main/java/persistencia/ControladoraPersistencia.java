package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Horario;
import logica.Odontologo;
import logica.Paciente;
import logica.Persona;
import logica.Responsable;
import logica.Secretario;
import logica.Turno;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    // Instancias de los controladores JPA
    private HorarioJpaController horarioJpa = new HorarioJpaController();
    private OdontologoJpaController odontologoJpa = new OdontologoJpaController();
    private PacienteJpaController pacienteJpa = new PacienteJpaController();
    private PersonaJpaController personaJpa = new PersonaJpaController();
    private ResponsableJpaController responsableJpa = new ResponsableJpaController();
    private SecretarioJpaController secretarioJpa = new SecretarioJpaController();
    private TurnoJpaController turnoJpa = new TurnoJpaController();
    private UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    
    public void crearUsuario(Usuario usuario){
        
        usuarioJpa.create(usuario);
        
    }

    public List<Usuario> getUsuarios() {
        
        return usuarioJpa.findUsuarioEntities();
        
        
        
    }

    public void borrarUsuario(int id) {
        usuarioJpa.destroy(id);
       
    }

    public Usuario traerUsuario(int id) {
        return usuarioJpa.findUsuario(id);
    }

    public void editarUsuario(Usuario usuario) {
        usuarioJpa.edit(usuario);
    }
}
package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class Controladora {

    // Instancia de la controladora de persistencia
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContraseña(contrasenia);
        usuario.setRol(rol);

        controlPersis.crearUsuario(usuario);

    }

    //-------------------------------------------------------------------------------------------------------//
    public List<Usuario> getUsuarios() {

        return controlPersis.getUsuarios();

    }
//----------------------------------------------------------------------------------------------------------//

    public void borrarUsuario(int id) {
        controlPersis.borrarUsuario(id);

    }

    public Usuario traerUsuario(int id) {
        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usuario) {
        controlPersis.editarUsuario(usuario);
    }

    public boolean comprobarIngreso(String usuario, String contrasenia) {
        Boolean ingreso = false;

        List<Usuario> listaUsuario = new ArrayList<Usuario>();
        listaUsuario = controlPersis.getUsuarios();

        for (Usuario usr : listaUsuario) {  // Se cambia "usuario" por "usr"
            if (usr.getNombreUsuario().equals(usuario)) {
                if (usr.getContraseña().equals(contrasenia)) {
                    ingreso = true;
                    break; // Salimos del bucle al encontrar coincidencia
                }
            }
        }
        return ingreso;
    }

}

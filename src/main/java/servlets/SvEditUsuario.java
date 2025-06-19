
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvEditUsuario", urlPatterns = {"/SvEditUsuario"})
public class SvEditUsuario extends HttpServlet {
    
    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
    }

    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String idStr = request.getParameter("id");

    if (idStr != null && !idStr.isEmpty()) {
        try {
            int id = Integer.parseInt(idStr); // Convertir a entero
            Usuario usuario = control.traerUsuario(id);

            HttpSession misession = request.getSession();
            misession.setAttribute("editar", usuario);

            response.sendRedirect("SvUsuario");

        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El parámetro 'id' debe ser un número válido.");
        }
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El parámetro 'id' es requerido.");
    }
}

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        String nombreUsuario=request.getParameter("nombreusu");
        String contrasenia=request.getParameter("contrasenia");
        String rol=request.getParameter("rol");
        
        Usuario usuario =(Usuario)request.getSession().getAttribute("editar");
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setContraseña(contrasenia);
        usuario.setRol(rol);
        
        control.editarUsuario(usuario);
        
        response.sendRedirect("verUsuarios.jsp");
        
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

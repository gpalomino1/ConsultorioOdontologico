
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;
import logica.Usuario;


@WebServlet(name = "SvUsuarioServlet", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

    Controladora control = new Controladora();
    
    /**SERVLET ES EL CONCEPTO DE API QUE TENEMOS-QUE HACE DE INTERMEDIARIO ENTRE LA INTERFAZ GRÁFICA Y LA LÓGICA DE NEGOCIO

     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Usuario> listaUsuario =new ArrayList<Usuario>();
        
        listaUsuario =control.getUsuarios();
        
        HttpSession misession=request.getSession();
        
        misession.setAttribute("listaUsuario", listaUsuario);
        
        System.out.println("Usuario"+listaUsuario.get(0));
        
        response.sendRedirect("verUsuarios.jsp");//Este método ahora-se tiene que implementar en la controladora y en la controladora de persistencia.
        
 
        
        
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreUsuario=request.getParameter("nombreusu");
        String contra=request.getParameter("contrasenia");
        String rol=request.getParameter("rol");
        
        control.crearUsuario(nombreUsuario, contra, rol);
        
        System.out.println("El nombre de usuario es:" + nombreUsuario);
        
       
        
        response.sendRedirect("index.jsp");
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    
}

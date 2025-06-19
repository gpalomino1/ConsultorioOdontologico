
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.Controladora;


@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {
   
    Controladora control = new Controladora();
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override //la validacion la tiene que hacer la logica no el servlet
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //guardamos en variables auxiliares
        String usuario=request.getParameter("usuario");
        String contrasenia=request.getParameter("contrasenia");
        
        boolean validacion = false;
        validacion = control.comprobarIngreso(usuario,contrasenia);
        
       if(validacion == true){
           
           HttpSession misession =request.getSession(true);
           misession.setAttribute("usuario",usuario);
           
           response.sendRedirect("index.jsp");
           
       }else{
           
           response.sendRedirect("LoginError.jsp");
       }
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

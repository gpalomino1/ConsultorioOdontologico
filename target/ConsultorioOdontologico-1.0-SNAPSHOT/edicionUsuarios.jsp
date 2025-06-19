

<%@page import="logica.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyPrimeraparte.jsp"%>

<h1>Edicion de Usuarios</h1>
<p>Este es el apartado para modificar un usuario del sistema</p>

<% Usuario usuario = (Usuario) request.getSession().getAttribute("editar"); %><!-- comment//trae el usuario del inicio de esta session -->

<form class="user" action="SvEditUsuario" method="POST">
    <div class="form-group col">
      <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="nombreusu" name="nombreusu"
                   placeholder="Nombre Usuario"value="<%=usuario.getNombreUsuario()%>">
        </div>
        
        
        <div class="col-sm-6 mb-3">
            <input type="text" class="form-control form-control-user" id="contrasenia" name="contrasenia"
                   placeholder="Contraseña"value=<%=usuario.getContraseña()%>">
        </div>
        <div class="col-sm-6 mb-3">
            <input type="password" class="form-control form-control-user" id="rol" name="rol"
                   placeholder="Rol"value=<%=usuario.getRol()%>">
        </div>
          
 

    <button type="submit" class="btn btn-primary btn-user btn-block">
      Guardar modificación Usuario
    </button>
  
</form>
<%@include file="components/bodyFinal.jsp"%>
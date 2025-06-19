

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/bodyPrimeraparte.jsp"%>


  <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Ver Usuarios</h1>
                    <p class="mb-4">A continuación podrá visializar la lista completa de usuarios</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Usuarios</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Rol</th>
                                             <th style="width:210px">Acción</th>
                                            
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Id</th>
                                            <th>Nombre</th>
                                            <th>Rol</th>
                                            <th style="width:210px">Acción</th>
                                        </tr>
                                    </tfoot>
                                    <%List<Usuario> listaUsuario =(List)request.getSession().getAttribute("listaUsuario");
                                    %>
                                    <tbody>
                                        <% for (Usuario usuario : listaUsuario) {%>
                                        <tr>
                                            <td><%=usuario.getId_usuario()%> </td>
                                            <td><%=usuario.getNombreUsuario()%> </td>
                                            <td><%=usuario.getRol()%> </td>

                                            <td style="display:flex; width:230px;">
                                                <form name="eliminar" action="SvElimUsuario" method="POST" style="display:inline;">
                                                    <input type="hidden" name="id" value="<%=usuario.getId_usuario()%>">
                                                    <button type="submit" class="btn btn-danger btn-user btn-block" style="background-color:orange; margin-right: 5px;">
                                                        <i class="fas fa-trash-alt"></i> Eliminar
                                                    </button>
                                                </form>

                                                <form name="editar" action="SvEditUsuario" method="GET" style="display:inline;">
                                                    <input type="hidden" name="id" value="<%=usuario.getId_usuario()%>">
                                                    <button type="submit" class="btn btn-primary btn-user btn-block" style="margin-left: 5px;">
                                                        <i class="fas fa-pencil-alt"></i> Editar
                                                    </button>
                                                </form>
                                            </td>

                                        </tr>
                                        <% }%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->



  

<%@include file="components/bodyFinal.jsp"%>
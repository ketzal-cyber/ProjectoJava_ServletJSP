<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section id="proveedor">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Proveedores</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="th-dark">
                            <tr>
                                <th>Clave</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>credito</th>
                                <th>Email</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- -->
                            <c:forEach var="provedor" items="${proveedor}">
                                <tr>
                                    <td>${provedor.clave}</td>
                                    <td>${provedor.nombre}</td>
                                    <td>${provedor.telefono}</td>
                                    <td> <fmt:formatNumber value="${provedor.credito}" type="currency"/></td>
                                    <td>${provedor.email}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?action=editar&idProveedor=${provedor.idProveedor}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                    
            </div>
                <!--Inicio Tarjetas para los totales -->
                <div class="col-md-3">
                    <div class="card text-center bg-danger text-white mb-3">
                        <div clas="card-body">
                            <h3>Credito Total</h3>
                            <h4 class="display-4">
                                <fmt:formatNumber value="${creditoTotal}" type="currency"/>
                            </h4>
                        </div>
                    </div>
                   <div class="card text-center bg-success text-white mb-3">
                       <div class="card-body">
                           <h3>Total Provedores</h3>
                           <h4 class="display-4">
                               <i class="fas fa-users"></i> ${totalprovedor}
                           </h4>
                       </div>
                    </div>
                </div>
            <!--Fin Tarjetas para los totales -->
        </div>
    </div>
</section>
                           
<!--Agregar cleinte modal -->
<jsp:include page="/WEB-INF/paginas/proveedor/agregarProveedor.jsp"/>

<%--
<ul>
    <c:forEach var="provedor" items="${proveedor}">
        <li>${provedor.idProveedor} ${provedor.clave} ${provedor.nombre} ${provedor.credito}</li>
        </c:forEach>
</ul>
--%>

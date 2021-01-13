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
                                <th>#</th>
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
        </div>
        
    </div>
    
</section>

<%--
<ul>
    <c:forEach var="provedor" items="${proveedor}">
        <li>${provedor.idProveedor} ${provedor.clave} ${provedor.nombre} ${provedor.credito}</li>
        </c:forEach>
</ul>
--%>

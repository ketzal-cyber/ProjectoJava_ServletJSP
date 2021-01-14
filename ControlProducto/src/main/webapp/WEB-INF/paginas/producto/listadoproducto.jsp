<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<section id="proveedor">
    <div class="container">
        <div class="row">
            <div class="col-md-10">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Productos</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="th-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>CB</th>
                                <th>Precio</th>
                                <th>Cat</th>
                                <th>Caduc</th>
                                <th>Descripción</th>
                                <th>Prov</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- -->
                            <c:forEach var="product" items="${productos}">
                                <tr>
                                    <td>${product.nombre}</td>
                                    <td>${product.codigoBarra}</td>
                                    <td> <fmt:formatNumber value="${product.precio}" type="currency"/></td>
                                    <td>${product.categoria}</td>
                                    <td>${product.caducidad}</td>
                                    <td>${product.descripcion}</td>
                                    <td>${product.idProveedor.idProveedor}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControlador?action=editar&idProveedor=${product.idProducto}" 
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

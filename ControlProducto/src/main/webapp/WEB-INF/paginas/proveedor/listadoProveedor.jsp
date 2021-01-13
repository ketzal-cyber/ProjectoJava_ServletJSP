<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<ul>
    <c:forEach var="provedor" items="${proveedor}">
        <li>${provedor.idProveedor} ${provedor.clave} ${provedor.nombre} ${provedor.credito}</li>
        </c:forEach>
</ul>

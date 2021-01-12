<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar Proveedor</title>
    </head>
    <body>
        <h1>Gestionar Proveedor</h1>
        <ul>
            <c:forEach var="provedor" items="${proveedor}">
                <li>${provedor.idProveedor} ${provedor.clave} ${provedor.nombre} ${provedor.credito}</li>
            </c:forEach>
        </ul>
        
    </body>
</html>

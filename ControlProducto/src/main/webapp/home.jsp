
<!DOCTYPE html>
<html>
    <!-- HEAD con una jsp include-->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Adminstrador productos</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    </head>


    <body>
        <!-- Cabecero con una accion jsp include-->
        <jsp:include page="WEB-INF/paginas/comunes/cabecero.jsp" />

        <!-- Boton navegacion -->
        <jsp:include page="WEB-INF/paginas/comunes/botonesNavegacion.jsp" />


        <!--Listado  -->
        <jsp:include page="WEB-INF/paginas/proveedor/listadoProveedor.jsp" />
        <jsp:include page="WEB-INF/paginas/producto/listadoproducto.jsp" />

        <!-- footer con una accion jsp include-->
        <jsp:include page="WEB-INF/paginas/comunes/footer.jsp" />

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/0fac832bd0.js" crossorigin="anonymous"></script>
    </body>
</html>
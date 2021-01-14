<div class="modal fade" id="agregarProveedorModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content ">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Proveedor</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControlador?action=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="clave">Clave</label>
                        <input type="text" class="form-control" name="clave" required/>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre" required/>
                    </div>
                    <div class="form-group">
                        <label for="telefono">Telefono</label>
                        <input type="tel" class="form-control" name="telefono" required/>
                    </div>
                    <div class="form-group">
                        <label for="credito">Credito</label>
                        <input type="number" class="form-control" name="credito" required/>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" required/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
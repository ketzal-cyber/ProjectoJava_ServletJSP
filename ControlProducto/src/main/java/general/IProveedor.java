package general;

import dominio.Proveedor;
import java.util.List;

public interface IProveedor {
    
    public List<Proveedor> listar();
    public Proveedor encontrar(Proveedor proveedor);
    public int insertar(Proveedor proveedor);
    public int actualizar(Proveedor proveedor);
    public int eliminar(Proveedor proveedor);
    
}

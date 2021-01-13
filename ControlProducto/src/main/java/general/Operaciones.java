package general;

import java.util.List;

public interface Operaciones {
    
    public List<Object> listar();
    public Object encontrar(Object object);
    public int insertar(Object object);
    public int actualizar(Object object);
    public int eliminar(Object object);
}

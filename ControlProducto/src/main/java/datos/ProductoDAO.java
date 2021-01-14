package datos;

import dominio.Producto;
import dominio.Proveedor;
import general.Operaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductoDAO implements Operaciones {

    private static final String SQL_SELECT = "SELECT "
            + " idproduct, nombre, codigo_barra, precio, categoria, caducidad, descripcion, id_proveedor "
            + " FROM producto";
    private static final String SQL_SELECT_BY_ID = "SELECT  nombre, codigo_barra, precio, categoria, caducidad, descripcion, id_proveedor "
            + " FROM producto WHERE idproduct = ?";
    private static final String SQL_INSERT = "INSERT INTO producto(nombre, codigo_barra, precio, categoria, caducidad, descripcion,id_proveedor) "
            + " VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE producto"
            + " SET nombre=?, codigo_barra=?, precio=?, categoria=?, caducidad=?, descripcion=?,id_proveedor=? WHERE idproduct=?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE idproduct=?";

    @Override
    public List<Object> listar() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto product = null;
        List<Object> productos = new ArrayList<>();
        // idproduct, nombre, codigo_barra, precio, categoria, caducidad, descripcion,id_proveedor
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("idproduct");
                String nombre = rs.getString("nombre");
                int codigobarra = rs.getInt("codigo_barra");
                double precio = rs.getDouble("precio");
                String categoria = rs.getString("categoria");
                Date caducidad = rs.getDate("caducidad");
                String description = rs.getString("descripcion");
                int idProvedor = (int) rs.getObject("id_proveedor");

                product = new Producto(idProduct, nombre, codigobarra, precio, categoria, caducidad, description, new Proveedor(idProvedor));
                productos.add(product);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    @Override
    public Object encontrar(Object object) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto product = null;
        Producto producto = (Producto) object;
        // 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, producto.getIdProducto());
            rs = stmt.executeQuery();
            rs.absolute(1); //nos posisionamos en el primer registro

                String nombre = rs.getString("nombre");
                int codigobarra = rs.getInt("codigo_barra");
                double precio = rs.getDouble("precio");
                String categoria = rs.getString("categoria");
                Date caducidad = rs.getDate("caducidad");
                String description = rs.getString("descripcion");
                Proveedor idProvedor = (Proveedor) rs.getObject("id_proveedor");

            product = new Producto(nombre, codigobarra, precio, categoria, caducidad, description, idProvedor);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return product;
    }

    @Override
    public int insertar(Object object) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Producto product = (Producto) object;
        // idproduct, nombre, codigo_barra, precio, categoria, caducidad, descripcion,id_proveedor
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, product.getNombre());
            stmt.setInt(2, product.getCodigoBarra());
            stmt.setDouble(3, product.getPrecio());
            stmt.setString(4, product.getCategoria());
            stmt.setDate(5, (java.sql.Date) product.getCaducidad());
            stmt.setString(6, product.getDescripcion());
            stmt.setObject(7, product.getIdProveedor());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int actualizar(Object object) {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Producto product = (Producto) object;
        //  idproduct, nombre, codigo_barra, precio, categoria, caducidad, descripcion,id_proveedor
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, product.getNombre());
            stmt.setInt(2, product.getCodigoBarra());
            stmt.setDouble(3, product.getPrecio());
            stmt.setString(4, product.getCategoria());
            stmt.setDate(5, (java.sql.Date) product.getCaducidad());
            stmt.setString(6, product.getDescripcion());
            stmt.setObject(7, product.getIdProveedor());
            stmt.setInt(8, product.getIdProducto());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    @Override
    public int eliminar(Object object) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Producto product = (Producto) object;
        // idproveedor, clave, nombre, telefono, credito, email
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, product.getIdProducto());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

}

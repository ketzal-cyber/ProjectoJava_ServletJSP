package datos;

import dominio.Proveedor;
import general.Operaciones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO implements Operaciones {

    private static final String SQL_SELECT = "SELECT idproveedor, clave, nombre, telefono, credito, email "
            + "FROM proveedor";
    private static final String SQL_SELECT_BY_ID = "SELECT clave, nombre, telefono, credito, email "
            + "FROM proveedor WHERE idproveedor = ?";
    private static final String SQL_INSERT = "INSERT INTO proveedor(clave,nombre,telefonno,credito,email "
            + "VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE proveedor"
            + "SET clave=?, nombre=?, telefono=?, credito=?, email=? WHERE idproveedor=?";
    private static final String SQL_DELETE = "DELETE FROM proveedor WHERE idproveedor=?";

    //Metodo para  listar todos los proveedores
    @Override
    public List<Object> listar() {
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedor proveedor = null;
        List<Object> provedores = new ArrayList<>();
        // idproveedor, clave, nombre, telefono, credito, email 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idProveedor = rs.getInt("idproveedor");
                String clave = rs.getString("clave");
                String nombre = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                int credito = rs.getInt("credito");
                String email = rs.getString("email");

                proveedor = new Proveedor(idProveedor, clave, nombre, telefono, credito, email);
                provedores.add(proveedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return provedores;
    }

    @Override
    public Object encontrar(Object object) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Proveedor provee = null;
        Proveedor proveedor = (Proveedor) object;
        // idproveedor, clave, nombre, telefono, credito, email 
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, proveedor.getIdProveedor());
            rs = stmt.executeQuery();
            rs.absolute(1); //nos posisionamos en el primer registro

            String clave = rs.getString("clave");
            String nombre = rs.getString("nombre");
            String telefono = rs.getString("telefono");
            int credito = rs.getInt("credito");
            String email = rs.getString("email");

            provee = new Proveedor(clave, nombre, telefono, credito, email);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return provee;
    }

    // 
    @Override
    public int insertar(Object object) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        Proveedor proveedor = (Proveedor) object;
        // idproveedor, clave, nombre, telefono, credito, email
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, proveedor.getClave());
            stmt.setString(2, proveedor.getNombre());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setInt(4, proveedor.getCredito());
            stmt.setString(5, proveedor.getEmail());

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
        Proveedor proveedor = (Proveedor) object;
        // idproveedor, clave, nombre, telefono, credito, email
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, proveedor.getClave());
            stmt.setString(2, proveedor.getNombre());
            stmt.setString(3, proveedor.getTelefono());
            stmt.setInt(4, proveedor.getCredito());
            stmt.setString(5, proveedor.getEmail());
            stmt.setInt(6, proveedor.getIdProveedor());

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
        Proveedor proveedor = (Proveedor) object;
        // idproveedor, clave, nombre, telefono, credito, email
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, proveedor.getIdProveedor());

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

package dominio;

import java.util.Date;

public class Producto {
    
    private int idProducto;
    private String nombre;
    private int codigoBarra;
    private double precio;
    private String categoria;
    private Date caducidad;
    private String descripcion;
    private Proveedor idProveedor;
    
    
    //CONSTRUCTOR
    public Producto(){}

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombre, int codigoBarra, double precio, String categoria, Date caducidad, String descripcion, Proveedor idProveedor) {
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
        this.categoria = categoria;
        this.caducidad = caducidad;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
    }

    public Producto(int idProducto, String nombre, int codigoBarra, double precio, String categoria, Date caducidad, String descripcion, Proveedor idProveedor) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.codigoBarra = codigoBarra;
        this.precio = precio;
        this.categoria = categoria;
        this.caducidad = caducidad;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(int codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", codigoBarra=" + codigoBarra + ", precio=" + precio + ", categoria=" + categoria + ", caducidad=" + caducidad + ", descripcion=" + descripcion + ", idProveedor=" + idProveedor + '}';
    }
    
    
    
    
    
    
}

package dominio;

public class Proveedor {
    
    private int idProveedor;
    private String clave;
    private String nombre;
    private String telefono;
    private int credito;
    private String email;
    
    public Proveedor() {}

    public Proveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(String clave, String nombre, String telefono, int credito, String email) {
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        this.credito = credito;
        this.email = email;
    }

    public Proveedor(int idProveedor, String clave, String nombre, String telefono, int credito, String email) {
        this.idProveedor = idProveedor;
        this.clave = clave;
        this.nombre = nombre;
        this.telefono = telefono;
        this.credito = credito;
        this.email = email;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", clave=" + clave + ", nombre=" + nombre + ", telefono=" + telefono + ", credito=" + credito + ", email=" + email + '}';
    }
    
    
    
}

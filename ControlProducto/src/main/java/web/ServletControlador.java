/*
* Anotacion para el Servlet Controlador
*/
package web;

import datos.ProductoDAO;
import datos.ProveedorDAO;
import dominio.Proveedor;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("action");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarProveedor(request, response);
                    break;
                case "eliminar":
                    this.eliminarProveedor(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            //System.out.println("else get = ");
            this.accionDefault(request, response);
        }
    }
    
    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Object> provedores = new ProveedorDAO().listar();
        List<Object> productos = new ProductoDAO().listar();
        //System.out.println("productos "+ productos);
        //System.out.println("proveedores "+ provedores);
        
        //cambiar alcance de request.setAttribute a sesion
        HttpSession session = request.getSession();
        session.setAttribute("proveedor", provedores);
        session.setAttribute("productos", productos);
        session.setAttribute("totalprovedor", provedores.size());
        session.setAttribute("creditoTotal", this.calcularCreditoTotal(provedores));
        //request.getRequestDispatcher("home.jsp").forward(request, response);  para que notifique al navegador y cambie url
        response.sendRedirect("home.jsp");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String accion = request.getParameter("action");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarProveedor(request, response);
                    break;
                case "modificar":
                    this.modificarProveedor(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
            
        }
    }
    
    private void insertarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //recuperamos los valores del formulario
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        int credito = 0;
        String creditoString = request.getParameter("credito");
        if (creditoString != null && !"".equals(creditoString)) {
            credito = Integer.parseInt(creditoString);
        }
        //creamos un objeto proveedor del modelo
        Proveedor newProvedor = new Proveedor(clave,nombre,telefono,credito,email);
        
        //insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ProveedorDAO().insertar(newProvedor);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //redirigimos a la accion por default
        this.accionDefault(request, response);
    }
    
    private void modificarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //recuperamos los valores del formulario de editar
        int idProved = 0;
        String idProString = request.getParameter("idProveedor");
        if(idProString != null && !"".equals(idProString)){
            idProved = Integer.parseInt(idProString);
        }
        String clave = request.getParameter("clave");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        int credito = 0;
        String creditoString = request.getParameter("credito");
        if (creditoString != null && !"".equals(creditoString)) {
            credito = Integer.parseInt(creditoString);
        }
        //creamos un objeto proveedor del modelo
        Proveedor newProvedor = new Proveedor(idProved,clave,nombre,telefono,credito,email);
        System.out.println("provedor = " + newProvedor);
        //actualiamos el nuevo objeto en la db
        int registrosModificados = new ProveedorDAO().actualizar(newProvedor);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //redirigimos a la accion por default
        this.accionDefault(request, response);
    }
    
    private void editarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // recuperar id proveedor
        int idProved = Integer.parseInt(request.getParameter("idProveedor"));
        Proveedor provedor = (Proveedor) new ProveedorDAO().encontrar(new Proveedor(idProved));
        //System.out.println("provedor = " + provedor);
        request.setAttribute("provedor", provedor);
        String jspEditar = "/WEB-INF/paginas/proveedor/editarProveedor.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //recuperamos los valores del formulario de editar
        int idProved = 0;
        String idProString = request.getParameter("idProveedor");
        if(idProString != null && !"".equals(idProString)){
            idProved = Integer.parseInt(idProString);
        }
        
        //creamos un objeto proveedor del modelo
        Proveedor newProvedor = new Proveedor(idProved);
        System.out.println("provedor = " + newProvedor);
        //eliminar el nuevo objeto en la db
        int registrosModificados = new ProveedorDAO().eliminar(newProvedor);
        System.out.println("registrosModificados = " + registrosModificados);
        
        //redirigimos a la accion por default
        this.accionDefault(request, response);
    }
    
    private int calcularCreditoTotal(List<Object> provedor){
        int creditoTotal = 0;
        for (Iterator<Object> it = provedor.iterator(); it.hasNext();) {
            Proveedor provee = (Proveedor) it.next();
            creditoTotal += provee.getCredito();
        }
        return creditoTotal;
    }
    
    
    
}

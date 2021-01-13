/*
* Anotacion para el Servlet Controlador
*/
package web;

import datos.ProveedorDAO;
import dominio.Proveedor;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Object> provedores = new ProveedorDAO().listar();
        System.out.println("proveedores "+ provedores);
        request.setAttribute("proveedor", provedores);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    
    
    
}

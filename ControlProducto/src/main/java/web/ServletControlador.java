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

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Object> provedores = new ProveedorDAO().listar();
        List<Object> productos = new ProductoDAO().listar();
        System.out.println("productos "+ productos);
        System.out.println("proveedores "+ provedores);
        request.setAttribute("proveedor", provedores);
        request.setAttribute("productos", productos);
        request.setAttribute("totalprovedor", provedores.size());
        request.setAttribute("creditoTotal", this.calcularCreditoTotal(provedores));
        request.getRequestDispatcher("home.jsp").forward(request, response);
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

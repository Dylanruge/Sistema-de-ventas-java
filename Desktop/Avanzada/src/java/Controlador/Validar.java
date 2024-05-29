package Controlador;

import Modelo.Empleado;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Modelo.EmpleadoDAO;
import java.security.MessageDigest;
import java.util.Base64;
import jakarta.servlet.http.HttpSession;

public class Validar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmpleadoDAO eDAO = new EmpleadoDAO();
        Empleado e = new Empleado();
        HttpSession sesion = request.getSession();
        String accion = request.getParameter("accion");

        if (accion.equals("Ingresar")) {
            String usuario = request.getParameter("usuario");
            String clave = asegurarClave(request.getParameter("clave"));

            e.setUsuario(usuario);
            e.setClave(clave);
            e = eDAO.validar(e);

            if (e.getUsuario() != null) {
                sesion.setAttribute("user", e);
                request.getRequestDispatcher("Controlador?menu=Principal").forward(request, response);
            } 
            else{
                sesion.removeAttribute("user");
                sesion.invalidate();
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } 
        else{ 
            sesion.removeAttribute("user");
            sesion.invalidate();
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
    
    private String asegurarClave(String clave){
        String claveSHA = null;
        
        try{
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256"); //Instanciamos el tipo de Hash
            sha256.update(clave.getBytes()); //Pasa la clave a bytes
            
            claveSHA = Base64.getEncoder().encodeToString(sha256.digest());
        } 
        catch(Exception e){
            System.out.println("ERROR en el SHA256\n"+e);
        }
        
        return claveSHA;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

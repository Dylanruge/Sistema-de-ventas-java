/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Config.Asignaciones;
import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;
import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.io.IOException;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Controlador extends HttpServlet {

    Empleado e = new Empleado();
    EmpleadoDAO eDAO = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cDAO = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pDAO = new ProductoDAO();
    int id;
    Empleado user;
    HttpSession sesion;
    LocalDate fecha = LocalDate.now();

    Venta v = new Venta();
    VentaDAO vDAO = new VentaDAO();
    ArrayList<Venta> listaV = new ArrayList<>();
    Asignaciones a = new Asignaciones();
    int cod,cant,item;
    String descripcion,noSerie;
    double precioP, subTotal, total;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String menu = request.getParameter("menu");

        if (menu.equals("Principal")) {
            HttpSession sesion = request.getSession();
            user = (Empleado) sesion.getAttribute("user");
            request.getRequestDispatcher("/Principal.jsp").forward(request, response);
        }

        if (menu.equals("Inicio")) {
            request.setAttribute("user",user);
            request.getRequestDispatcher("/Inicio.jsp").forward(request, response);
        }

        if (menu.equals("Empleado")) {
            request.setAttribute("user",user);
            
            switch (accion) {
                case "Listar":
                    ArrayList<Empleado> listaE = eDAO.listar();
                    request.setAttribute("listaE", listaE);
                    break;
                case "Agregar":
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    String tel = request.getParameter("tel");
                    String estado = request.getParameter("estado");
                    String usuario = request.getParameter("usuario");
                    String clave = asegurarClave(request.getParameter("clave"));
                    
                    e.setDni(dni);
                    e.setNombre(nombre);
                    e.setTel(tel);
                    e.setEstado(estado);
                    e.setUsuario(usuario);
                    e.setClave(clave);

                    eDAO.agregar(e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = Integer.parseInt(request.getParameter("id"));

                    e = eDAO.listarId(id);

                    request.setAttribute("empleado", e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("dni");
                    String nombre1 = request.getParameter("nombre");
                    String tel1 = request.getParameter("tel");
                    String estado1 = request.getParameter("estado");
                    String usuario1 = request.getParameter("usuario");
                    String clave1 = asegurarClave(request.getParameter("clave"));
                    id = Integer.parseInt(request.getParameter("ID"));

                    e.setDni(dni1);
                    e.setNombre(nombre1);
                    e.setTel(tel1);
                    e.setEstado(estado1);
                    e.setUsuario(usuario1);
                    e.setClave(clave1);
                    e.setId(id);

                    eDAO.actualizar(e);
                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    eDAO.eliminar(id);

                    request.getRequestDispatcher("Controlador?menu=Empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }

            request.getRequestDispatcher("/Empleado.jsp").forward(request, response);
        }

        if (menu.equals("Cliente")) {
            request.setAttribute("user",user);
            
            switch (accion) {
                case "Listar":
                    ArrayList<Cliente> listaC = cDAO.listar();
                    request.setAttribute("listaC", listaC);
                    break;
                case "Agregar":
                    String dni = request.getParameter("dni");
                    String nombre = request.getParameter("nombre");
                    String direccion = request.getParameter("direccion");
                    String estado = request.getParameter("estado");

                    c.setDni(dni);
                    c.setNombre(nombre);
                    c.setDireccion(direccion);
                    c.setEstado(estado);

                    cDAO.agregar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = Integer.parseInt(request.getParameter("id"));

                    c = cDAO.listarId(id);

                    request.setAttribute("c", c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("dni");
                    String nombre1 = request.getParameter("nombre");
                    String direccion1 = request.getParameter("direccion");
                    String estado1 = request.getParameter("estado");
                    id = Integer.parseInt(request.getParameter("id"));

                    c.setDni(dni1);
                    c.setNombre(nombre1);
                    c.setDireccion(direccion1);
                    c.setEstado(estado1);
                    c.setId(id);

                    cDAO.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    cDAO.eliminar(id);

                    request.getRequestDispatcher("Controlador?menu=Cliente&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }

            request.getRequestDispatcher("/Cliente.jsp").forward(request, response);
        }

        if (menu.equals("Producto")) {
            request.setAttribute("user",user);
            
            switch (accion) {
                case "Listar":
                    ArrayList<Producto> listaP = pDAO.listar();
                    request.setAttribute("listaP", listaP);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("nombre");
                    double precio = Double.parseDouble(request.getParameter("precio"));
                    int stock = Integer.parseInt(request.getParameter("stock"));
                    String estado = request.getParameter("estado");

                    p.setNombre(nombre);
                    p.setPrecio(precio);
                    p.setStock(stock);
                    p.setEstado(estado);

                    pDAO.agregar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    id = Integer.parseInt(request.getParameter("id"));

                    p = pDAO.listarId(id);

                    request.setAttribute("p", p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("nombre");
                    double precio1 = Double.parseDouble(request.getParameter("precio"));
                    int stock1 = Integer.parseInt(request.getParameter("stock"));
                    String estado1 = request.getParameter("estado");
                    id = Integer.parseInt(request.getParameter("id"));

                    p.setNombre(nombre1);
                    p.setPrecio(precio1);
                    p.setStock(stock1);
                    p.setEstado(estado1);
                    p.setId(id);

                    pDAO.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    pDAO.eliminar(id);

                    request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                    break;
                default:
                    break;
            }

            request.getRequestDispatcher("/Producto.jsp").forward(request, response);
        }

        if (menu.equals("NuevaVenta")) {
            request.setAttribute("user",user);
            
            switch (accion) {
                case "Buscar Cliente":
                    String dni = request.getParameter("codigoCliente");

                    c.setDni(dni);
                    c = cDAO.buscar(dni);

                    request.setAttribute("noSerie",noSerie);
                    request.setAttribute("c", c);
                    break;
                case "Buscar Producto":
                    id = Integer.parseInt(request.getParameter("codigoProducto"));

                    p = pDAO.listarId(id);
                    
                    request.setAttribute("noSerie",noSerie);
                    request.setAttribute("total", total);
                    request.setAttribute("listaV",listaV);
                    request.setAttribute("c", c);
                    request.setAttribute("p", p);
                    break;
                case "Agregar":
                    request.setAttribute("c", c);
                            
                    item += 1;
                    total = 0;
                    cod = Integer.parseInt(request.getParameter("codigoProducto"));
                    descripcion = request.getParameter("nombresProducto");
                    precioP = Double.parseDouble(request.getParameter("precio"));
                    cant = Integer.parseInt(request.getParameter("cant"));
                    subTotal = precioP * cant;

                    v = new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripcionP(descripcion);
                    v.setPrecio(precioP);
                    v.setCant(cant);
                    v.setSubTotal(subTotal);
                    listaV.add(v);
                    for (int i = 0; i<listaV.size(); i++)
                        total += listaV.get(i).getSubTotal();
                    
                    request.setAttribute("noSerie",noSerie);
                    request.setAttribute("total", total);
                    request.setAttribute("listaV",listaV);
                    break;
                case "Cancelar":
                    item = 0;
                    total = 0;
                    listaV.clear();
                    request.setAttribute("noSerie",noSerie);
                    break;
                case "Limpiar":
                    request.setAttribute("noSerie",noSerie);
                    request.setAttribute("c", c);
                    request.setAttribute("total", total);
                    request.setAttribute("listaV",listaV);
                    break;
                case "Generar Venta":
                    a.actualizarStrock(listaV);
                    
                    v.setIdCliente(c.getId());
                    v.setIdEmpleado(user.getId());
                    v.setNumSerie(noSerie);
                    v.setFecha(fecha.toString());
                    v.setMonto(total);
                    v.setEstado("1");
                    
                    vDAO.guardarVenta(v);
                         
                    int idVentas = Integer.parseInt(vDAO.idVentas());
                    
                    for(int i=0; i<listaV.size(); i++){
                        v = new Venta();
                        v.setId(idVentas);
                        v.setIdProducto(listaV.get(i).getIdProducto());
                        v.setCant(listaV.get(i).getCant());
                        v.setPrecio(listaV.get(i).getPrecio());
                        vDAO.guardarDetalleVenta(v);
                    }
                    
                    noSerie = a.noSerie();
                    request.setAttribute("noSerie",noSerie);
                    listaV.clear();
                    total = 0;
                    item = 0;
                    break;
                default:
                    noSerie = a.noSerie();
                    request.setAttribute("noSerie",noSerie);
                    
                    break;
            }
            
            request.getRequestDispatcher("/RegistrarVenta.jsp").forward(request, response);
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author dylan
 */
import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paginaDestino")
public class NominaCTO extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Recuperar los datos del formulario
            String nombre = request.getParameter("nombre");
            String identificacion = request.getParameter("identificacion");
            double salarioBasico = Double.parseDouble(request.getParameter("salario"));
            int diasTrabajados = Integer.parseInt(request.getParameter("diasTrabajados"));
            
            double salario = calcularSalario(salarioBasico, diasTrabajados);
            double salud = salario * 0.04;
            double pension = salario * 0.04;
            double auxilioTransporte = (salarioBasico <= 2000000) ? 106454 : 0;
            double netoPagar = salario - salud - pension + auxilioTransporte;
            
            // Formatear los valores en pesos colombianos
            NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
            String salarioFormateado = formatoMoneda.format(salario);
            String saludFormateado = formatoMoneda.format(salud);
            String pensionFormateado = formatoMoneda.format(pension);
            String auxilioTransporteFormateado = formatoMoneda.format(auxilioTransporte);
            String netoPagarFormateado = formatoMoneda.format(netoPagar);
            
            // Almacenar los resultados formateados en el objeto HttpServletRequest
            request.setAttribute("nombre", nombre);
            request.setAttribute("identificacion", identificacion);
            request.setAttribute("salario", salarioFormateado);
            request.setAttribute("salud", saludFormateado);
            request.setAttribute("pension", pensionFormateado);
            request.setAttribute("auxilioTransporte", auxilioTransporteFormateado);
            request.setAttribute("netoPagar", netoPagarFormateado);
            
            // Redirigir a la página de resultados
            String resultadoPage = request.getParameter("resultadoPage");
            request.getRequestDispatcher(resultadoPage).forward(request, response);
        } catch (NumberFormatException e) {
              
            // Manejar excepción de formato de número
            request.setAttribute("error", "Error en el formato de los datos");
            request.getRequestDispatcher("errorPage.jsp").forward(request, response);
        }
    }
    
    private double calcularSalario(double salarioBasico, int diasTrabajados) {
        double salarioDiario = salarioBasico / 30;
        return salarioDiario * diasTrabajados;
    }
    
}

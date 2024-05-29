/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Venta;
import Modelo.VentaDAO;
import java.util.ArrayList;

public class Asignaciones{
    Producto p;
    ProductoDAO pDAO = new ProductoDAO();
    String noSerie;
    VentaDAO vDAO = new VentaDAO();

    public String noSerie() {
        noSerie = vDAO.generarSerie();

        if (noSerie == null)
            noSerie = "000000001";
        else{
            int incrementar = Integer.parseInt(noSerie);
            GenerarSerie gs = new GenerarSerie();

            noSerie = gs.noSerie(incrementar);
        }

        return noSerie;
    }

    public void actualizarStrock(ArrayList<Venta> listaV){
        for(int i=0; i<listaV.size(); i++){
            p = new Producto();
            int cantidad = listaV.get(i).getCant();
            int idProducto = listaV.get(i).getIdProducto();

            p = pDAO.listarId(idProducto);
            int stockActualizado = p.getStock() - cantidad;

            pDAO.actualizarStock(idProducto, stockActualizado);
        }
    }
}

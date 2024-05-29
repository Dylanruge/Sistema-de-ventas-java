/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class VentaDAO{
    Conexion c = new Conexion();
    Connection con = c.conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r;
    
    public String generarSerie(){
        String noSerie = null;
        
        try{
            ps = con.prepareStatement("SELECT MAX(NumeroSerie) FROM Ventas");
            rs = ps.executeQuery();
            
            while(rs.next())
                noSerie = rs.getString(1);
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la tabla Ventas\n"+e);
        }
        
        return noSerie;
    }
    public String idVentas(){
        String idVentas = null;
        
        try{
            ps = con.prepareStatement("SELECT MAX(IdVentas) FROM Ventas");
            rs = ps.executeQuery();
            
            while(rs.next())
                idVentas = rs.getString(1);
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la tabla Ventas\n"+e);
        }
        
        return idVentas;
    }
    public int guardarVenta(Venta v){
        try{
            ps = con.prepareStatement("INSERT INTO Ventas (IdCliente,IdEmpleado,NumeroSerie,FechaVentas,Monto,Estado) VALUES (?,?,?,?,?,?)");
            ps.setInt(1,v.getIdCliente());
            ps.setInt(2,v.getIdEmpleado());
            ps.setString(3,v.getNumSerie());
            ps.setString(4,v.getFecha());
            ps.setDouble(5,v.getMonto());
            ps.setString(6,v.getEstado());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al insertar datos en la tabla Ventas\n"+e);
        }
        
        return r;
    }
    public int guardarDetalleVenta(Venta v){
        try{
            ps = con.prepareStatement("INSERT INTO Detalle_Ventas (IdVentas,IdProducto,Cantidad,PrecioVenta) VALUES (?,?,?,?)");
            ps.setInt(1,v.getId());
            ps.setInt(2,v.getIdProducto());
            ps.setInt(3,v.getCant());
            ps.setDouble(4,v.getPrecio());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al insertar datos en la tabla Detalle_Ventas\n"+e);
        }
        
        return r;
    }
}

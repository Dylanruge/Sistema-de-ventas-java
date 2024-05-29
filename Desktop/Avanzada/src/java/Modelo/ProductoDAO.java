/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductoDAO{
    Conexion c = new Conexion();
    Connection con = c.conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r;
        
    public int actualizarStock(int idProducto,int stock){
        try{
            ps = con.prepareStatement("UPDATE Producto SET Stock = ? WHERE (IdProducto = ?)");
            ps.setInt(1,stock);
            ps.setInt(2,idProducto);
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la Tabla producto\n"+e);
        }
        
        return r;
    }
    
    //Op. del CRUD
    
    public ArrayList<Producto> listar(){
        ArrayList<Producto> listaP = new ArrayList<Producto>();
        
        try{
            ps = con.prepareStatement("SELECT * FROM Producto");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Producto p = new Producto();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                
                listaP.add(p);
            }
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la Tabla\n"+e);
        }
        
        return listaP;
    }
    public int agregar(Producto p){        
        try{
            ps = con.prepareStatement("INSERT INTO Producto (Nombres,Precio,Stock,Estado)"
                +"VALUES (?,?,?,?)");
            ps.setString(1,p.getNombre());
            ps.setDouble(2,p.getPrecio());
            ps.setInt(3,p.getStock());
            ps.setString(4,p.getEstado());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al insertar datos en la BD\n"+e);
        }
        
        return r;
    }
    public Producto listarId(int id){
        Producto p = new Producto();
        
        try{
            ps = con.prepareStatement("SELECT * FROM Producto WHERE IdProducto = "+id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
            }
        } 
        catch(Exception e){
            System.out.println("ERROR a leer la Tabla - IdProd\n"+e);
        }
        
        return p;
    }
    public int actualizar(Producto p){        
        try{
            ps = con.prepareStatement("UPDATE Producto SET Nombres = ?,Precio = ?,Stock = ?,Estado = ? WHERE (IdProducto = ?)");
            ps.setString(1,p.getNombre());
            ps.setDouble(2,p.getPrecio());
            ps.setInt(3,p.getStock());
            ps.setString(4,p.getEstado());
            ps.setInt(5,p.getId());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al actualizar datos en la BD\n"+e);
        }
        
        return r;
    }
    public void eliminar(int id){        
        try{
            ps = con.prepareStatement("DELETE FROM Producto WHERE IdProducto = "+id);
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al eliminar datos en la BD\n"+e);
        }
    }
}

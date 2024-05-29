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

public class ClienteDAO{
    Conexion c = new Conexion();
    Connection con = c.conexion();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int r;
    
    public Cliente buscar(String dni){
        Cliente cl = new Cliente();
        
        try{
            ps = con.prepareStatement("SELECT * FROM Cliente WHERE Dni = "+dni);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        } 
        catch(Exception e){
            System.out.println("ERROR al buscar en la tabla Cliente\n"+e);
        }
        
        return cl;
    }
    
    //Op. del CRUD
    
    public ArrayList<Cliente> listar(){
        ArrayList<Cliente> listaC = new ArrayList<Cliente>();
        
        try{
            ps = con.prepareStatement("SELECT * FROM Cliente");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente();
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setEstado(rs.getString(5));
                
                listaC.add(c);
            }
        } 
        catch(Exception e){
            System.out.println("ERROR al leer la Tabla\n"+e);
        }
        
        return listaC;
    }
    public int agregar(Cliente cl){
        try{
            ps = con.prepareStatement("INSERT INTO Cliente (Dni,Nombres,Direccion,Estado)"
                +"VALUES (?,?,?,?)");
            ps.setString(1,cl.getDni());
            ps.setString(2,cl.getNombre());
            ps.setString(3,cl.getDireccion());
            ps.setString(4,cl.getEstado());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al insertar datos en la BD\n"+e);
        }
        
        return r;
    }
    public Cliente listarId(int id){
        Cliente cl = new Cliente();
        
        try{
            ps = con.prepareStatement("SELECT * FROM Cliente WHERE IdCliente = "+id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNombre(rs.getString(3));
                cl.setDireccion(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
        } 
        catch(Exception e){
            System.out.println("ERROR a leer la Tabla - IdCli\n"+e);
        }
        
        return cl;
    }
    public int actualizar(Cliente cl){        
        try{
            ps = con.prepareStatement("UPDATE Cliente SET Dni = ?,Nombres = ?, Direccion = ?,Estado = ? WHERE (IdCliente = ?)");
            ps.setString(1,cl.getDni());
            ps.setString(2,cl.getNombre());
            ps.setString(3,cl.getDireccion());
            ps.setString(4,cl.getEstado());
            ps.setInt(5,cl.getId());
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al actualizar datos en la BD\n"+e);
        }
        
        return r;
    }
    public void eliminar(int id){        
        try{
            ps = con.prepareStatement("DELETE FROM Cliente WHERE IdCliente = "+id);
            ps.executeUpdate();
        } 
        catch(Exception e){
            System.out.println("ERROR al eliminar datos en la BD\n"+e);
        }
    }
}

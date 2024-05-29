/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente{
    int id;
    String nombre,dni,direccion,estado;

    public Cliente(){
    }
    
    public Cliente(int id,String nombre,String dni,String direccion,String estado){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.estado = estado;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getDni(){
        return dni;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getEstado(){
        return estado;
    }
}

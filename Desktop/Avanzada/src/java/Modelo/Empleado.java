/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Empleado{
    int id;
    String nombre,dni,tel,estado,usuario,clave;

    public Empleado(){
    }
    
    public Empleado(int id,String nombre,String dni,String tel,String estado,String usuario,String clave){
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.tel = tel;
        this.estado = estado;
        this.usuario = usuario;
        this.clave = clave;
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
    public void setTel(String tel){
        this.tel = tel;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setClave(String clave){
        this.clave = clave;
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
    public String getTel(){
        return tel;
    }
    public String getEstado(){
        return estado;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getClave(){
        return clave;
    }
}

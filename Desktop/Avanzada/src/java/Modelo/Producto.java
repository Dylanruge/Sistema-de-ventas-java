/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Producto{
    int id,stock;
    double precio;
    String nombre,estado;

    public Producto(){
    }

    public Producto(int id,String nombre,double precio,int stock,String estado){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public void setId(int id){
        this.id = id;
    }
    public void setStock(int stock){
        this.stock = stock;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public void setPrecio(double precio){
        this.precio = precio;
    }

    public int getId(){
        return id;
    }
    public int getStock(){
        return stock;
    }
    public String getNombre(){
        return nombre;
    }
    public String getEstado(){
        return estado;
    }
    public double getPrecio(){
        return precio;
    }
}

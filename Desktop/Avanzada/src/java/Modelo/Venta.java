/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Venta{
    int id,item,cant,idCliente,idProducto,idEmpleado;
    String numSerie,descripcionP,fecha,estado;
    double precio,subTotal,monto;

    public Venta(){
    }

    public Venta(int id,int item,int cant,int idCliente,int idProducto,int idEmpleado,String numSerie,String descripcionP,String fecha,String estado,double precio,double subTotal,double monto){
        this.id = id;
        this.item = item;
        this.cant = cant;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.idEmpleado = idEmpleado;
        this.numSerie = numSerie;
        this.descripcionP = descripcionP;
        this.fecha = fecha;
        this.estado = estado;
        this.precio = precio;
        this.subTotal = subTotal;
        this.monto = monto;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId() {
        return id;
    }
    public int getItem() {
        return item;
    }
    public int getCant() {
        return cant;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public int getIdProducto() {
        return idProducto;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public String getNumSerie() {
        return numSerie;
    }
    public String getDescripcionP() {
        return descripcionP;
    }
    public String getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }
    public double getPrecio() {
        return precio;
    }
    public double getSubTotal() {
        return subTotal;
    }
    public double getMonto() {
        return monto;
    }
}

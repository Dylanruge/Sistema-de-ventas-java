/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

public class GenerarSerie{
    int dato;
    String noSerie;
    
    public String noSerie(int dato){
        this.dato = dato + 1;
        
        if((this.dato>=10000000) && (this.dato<=100000000))
            noSerie = ""+this.dato;
        
        if((this.dato>=1000000) && (this.dato<=10000000))
            noSerie = "0"+this.dato;
        
        if((this.dato>=100000) && (this.dato<=1000000))
            noSerie = "00"+this.dato;
        
        if((this.dato>=10000) && (this.dato<=100000))
            noSerie = "000"+this.dato;
        
        if((this.dato>=1000) && (this.dato<=10000))
            noSerie = "0000"+this.dato;
        
        if((this.dato>=100) && (this.dato<=1000))
            noSerie = "00000"+this.dato;
        
        if((this.dato>=10) && (this.dato<=100))
            noSerie = "000000"+this.dato;
        
        if(this.dato<10)
            noSerie = "00000000"+this.dato;
            
        return noSerie;
    }
}

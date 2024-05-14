package Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion{
    public Connection c;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/Ventas";
    private String user = "root";
    private String password = "Dylanruge1234";
    
    public Connection conexion(){
        try{
           Class.forName(driver);
           
           c = DriverManager.getConnection(url,user,password);
        } 
        catch(Exception e){
            System.out.println("ERROR en la conexión\n"+e);
        }
        
        return c;
    }
}

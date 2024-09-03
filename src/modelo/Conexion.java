/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Win11
 */
public class Conexion {
    /* nombre del servidor = localhost
    puerto = 3306 
    usuario = root
    contrasena = 12345
    Driver de Conexion = com.mysql.cj.jdbc.Driver
    url de Conexion (cadena de conexion) :
    tipo conector(jdbc),mysql,nombre del servidor,
    puerto,base de datos
    */
    
    private final String puerto = "3306";
    // (esto da error) puerto = "dkjdk;
    
    private final String bd = "db_empresa";
    
    private final String urlconexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC",puerto,bd);
    //"jdbc:mysql://localhost:3306/db_empresa2"
    
    private final String usuario = "root";
    
    private final String contra = "12345";
    
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    //jdbc = Driver
    
    public Connection conexionBD; 
    
    public void abrir_conexion(){
        try{
            //aca va el codigo
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlconexion, usuario, contra);
            System.out.println("Conexion Exitosa");
        } 
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Algo salio mal " + ex.getMessage());
        }
        
    }
    
    public void cerrar_conexion(){
        try{
            //aca va el codigo
            conexionBD.close();
        } 
        catch(SQLException ex){
            System.out.println("Algo salio mal " + ex.getMessage());
        }
        
    }
    
}

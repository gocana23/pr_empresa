/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;
import modelo.Conexion;
/**
 *
 * @author Win11
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Conexion cn = new Conexion();
        cn.abrir_conexion();
        cn.cerrar_conexion();*/
        
        frm_cliente frm = new frm_cliente();
        frm.show();
    }
    
}

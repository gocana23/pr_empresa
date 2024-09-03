/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @win11
 */
public class Cliente extends Persona {
    private String nit;
    private int id;

    Conexion cn;
    public Cliente(){}    
    public Cliente(String nit, String nombres, String apellidos, String direccion, String telefono, String fecha_nacimiento) {
        super(nombres, apellidos, direccion, telefono, fecha_nacimiento);
        this.nit = nit;
        this.id = id;
    }
    
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    @Override
    public void agregar(){
        try {
            PreparedStatement parametro;
            cn = new Conexion();
            cn.abrir_conexion();
            String query = "INSERT INTO db_empresa2.clientes(nit,nombres,apellidos,direccion,telefono,fecha_nacimiento) VALUES (?,?,?,?,?,?);";
            parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
            parametro.setString(1, getNit());
            parametro.setString(2, getNombres());
            parametro.setString(3, getApellidos());
            parametro.setString(4, getDireccion());
            parametro.setString(5, getTelefono());
            parametro.setString(6, this.getFecha_nacimiento());
            
            int executar = parametro.executeUpdate();
            System.out.println("Ingreso exitoso, ha afectado: "+ Integer.toString(executar));
            
            cn.cerrar_conexion();
                        
            
        } catch(SQLException ex){
            System.out.println("Algo salio mal" + ex.getMessage());
        }
         
    }

    /**
     *
     * @return
     */
    @Override
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new Conexion();
        cn.abrir_conexion();
        String query = "select * from clientes;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"id","nit","nombres","apellidos","direccion","telefono","nacimiento"};
        tabla.setColumnIdentifiers(encabezado);
        String datos[] = new String[7];
        while(consulta.next()){
            datos[0] = consulta.getString("id_cliente");
            datos[1] = consulta.getString("nit");
            datos[2] = consulta.getString("nombres");
            datos[3] = consulta.getString("apellidos");
            datos[4] = consulta.getString("direccion");
            datos[5] = consulta.getString("telefono");
            datos[6] = consulta.getString("fecha_nacimiento");
            
            tabla.addRow(datos);
            
        }
        
        cn.cerrar_conexion();
        
    } catch(SQLException ex){
        System.out.println("Error en leer " + ex.getMessage());
    }
    
    return tabla;
}
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

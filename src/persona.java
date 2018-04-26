
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;
import conexion.Conexion;
import java.sql.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class persona extends personaApp.personaPOA{
    private ORB orb;
    Conexion conex = new Conexion();
    
    @Override
    public boolean insertarPersona(int identifigacion, String nombre, String apellidos, int telefono, String direccion) {
        boolean resultado = false;
        
        try {
            String query = "insert into persona(identifigacion,nombre,apellidos,telefono,direccion)"
                    + "values ("+identifigacion+","+nombre+","+apellidos+","+telefono+","+direccion+")";
            conex.conexion();
            Statement st = conex.conex.createStatement();
            int valor = st.executeUpdate(query);
            if(valor>0){
                resultado = true;
            }
            //Cerramos los recursos.
            st.close();
            conex.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un Error"+e.getMessage());
                    
        }
        return resultado;
    }

    @Override
    public String consultarPersona(int identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarPersona(int identificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarPersona(int identifigacion, String nombre, String apellidos, int telefono, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String listarPersonas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

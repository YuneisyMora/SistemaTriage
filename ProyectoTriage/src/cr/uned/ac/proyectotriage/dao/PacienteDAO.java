/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.uned.ac.proyectotriage.dao;


import cr.uned.ac.proyectotriage.dominio.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PacienteDAO {
    
    private Connection con;

    public PacienteDAO() {
        try {
            Conexion conexion = new Conexion();
            con = conexion.conectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Error de conexión a Base de Datos", 
                    "Error DAO", 
                    JOptionPane.ERROR_MESSAGE
            );
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public void insertarPaciente(Paciente paciente) throws SQLException {
        String insert = "INSERT INTO paciente(nombre_completo, edad, motivo_consulta, "
                      + "temperatura_corp, freq_card, nivel_dolor, clasificacion, color) "
                      + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = con.prepareCall(insert);
        pst.setString(1, paciente.getNombre_completo());
        pst.setInt(2, paciente.getEdad());
        pst.setString(3, paciente.getMotivo_consulta());
        pst.setDouble(4, paciente.getTemperatura_corp());
        pst.setDouble(5, paciente.getFreq_card());
        pst.setInt(6, paciente.getNivel_dolor());
        pst.setString(7, paciente.getClasificacion());
        pst.setString(8, paciente.getColor());
        
        pst.execute();
    }
    
    
    public ArrayList<Paciente> obtenerPacientes() throws SQLException {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        
        String select = "SELECT * FROM paciente";
        PreparedStatement pstm = con.prepareCall(select);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            Paciente tmp = new Paciente();
            
            tmp.setId(rs.getInt("id"));
            tmp.setNombre_completo(rs.getString("nombre_completo"));
            tmp.setEdad(rs.getInt("edad"));
            tmp.setMotivo_consulta(rs.getString("motivo_consulta"));
            tmp.setTemperatura_corp(rs.getDouble("temperatura_corp"));
            tmp.setFreq_card(rs.getDouble("freq_card"));
            tmp.setNivel_dolor(rs.getInt("nivel_dolor"));
            tmp.setClasificacion(rs.getString("clasificacion"));
            tmp.setColor(rs.getString("color"));
            
            listaPacientes.add(tmp);
        }
        
        return listaPacientes;
    }
}


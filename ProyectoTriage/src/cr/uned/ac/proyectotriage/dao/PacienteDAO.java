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
    
        public ArrayList<Paciente> buscarPacientesPorNombre(String nombreBusqueda) throws SQLException {
        ArrayList<Paciente> lista = new ArrayList<>();

        
        String sql = "SELECT * FROM paciente WHERE LOWER(nombre_completo) LIKE ?";

        PreparedStatement pst = con.prepareCall(sql);
        pst.setString(1, "%" + nombreBusqueda.toLowerCase() + "%");

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            Paciente p = new Paciente();

            p.setId(rs.getInt("id"));
            p.setNombre_completo(rs.getString("nombre_completo"));
            p.setEdad(rs.getInt("edad"));
            p.setMotivo_consulta(rs.getString("motivo_consulta"));
            p.setTemperatura_corp(rs.getDouble("temperatura_corp"));
            p.setFreq_card(rs.getDouble("freq_card"));
            p.setNivel_dolor(rs.getInt("nivel_dolor"));
            p.setClasificacion(rs.getString("clasificacion"));
            p.setColor(rs.getString("color"));

            lista.add(p);
        }

        return lista;
    }
        
        public void actualizarPaciente(Paciente p) throws SQLException {
        String sql = "UPDATE paciente SET nombre_completo=?, edad=?, motivo_consulta=?, temperatura_corp=?, freq_card=?, nivel_dolor=?, clasificacion=?, color=? WHERE id=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, p.getNombre_completo());
        pst.setInt(2, p.getEdad());
        pst.setString(3, p.getMotivo_consulta());
        pst.setDouble(4, p.getTemperatura_corp());
        pst.setDouble(5, p.getFreq_card());
        pst.setInt(6, p.getNivel_dolor());
        pst.setString(7, p.getClasificacion());
        pst.setString(8, p.getColor());
        pst.setInt(9, p.getId());

        pst.executeUpdate();
    }
        
        public void eliminarPaciente(int idPaciente) throws SQLException {
        String sql = "DELETE FROM paciente WHERE id = ?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, idPaciente);

        pst.executeUpdate();
    }



}


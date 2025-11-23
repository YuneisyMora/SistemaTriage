/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.uned.ac.proyectotriage.dao;


import java.sql.*;


/**
 *
 */
public class Conexion {
    private String urlConexion="jdbc:derby://localhost:1527/TriageDB";
    private String userName="TriageDB";
    private String password="1234";
    
    
    /**
     * Metodo para conectarse a la base de datos
     * @return Connection
     * @throws SQLException 
     */
    public Connection conectar() throws SQLException{
        return DriverManager.getConnection(urlConexion, userName, password);
    }
}

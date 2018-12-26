/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author miguel
 */
public class estados {
    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString()
    {
        return nombre;
    }
    
    public Vector<estados> mostrarEstados()
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();
        
        Vector<estados> datos = new Vector<estados>();
        estados dat = null;
        
        try {
            String sql = "SELECT id_estado, estado FROM t_estado";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new estados();
            dat.setId(0);
            dat.setNombre("Selecciona Estado");
            datos.add(dat);
            
            //cbxEstados.addItem("Seleccione Estado");
            while (rs.next()) 
            {
                dat = new estados();
                dat.setId(rs.getInt("id_estado"));
                dat.setNombre(rs.getString("estado"));
                datos.add(dat);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        return datos;
    }
    
    
}

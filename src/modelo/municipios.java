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
public class municipios {
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
        return this.nombre;
    }
    
    public Vector<municipios> mostrarMunicipios(Integer idEstado)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion conn = new Conexion();
        Connection con = conn.getConnection();
        
        Vector<municipios> datos = new Vector<municipios>();
        municipios dat = null;
        
        try {
            String sql = "SELECT id_municipio, id_estado, municipio FROM t_municipio WHERE id_estado = " + idEstado;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new municipios();
            dat.setId(0);
            dat.setNombre("Selecciona Municipio");
            datos.add(dat);
            
            //cbxEstados.addItem("Seleccione Estado");
            while (rs.next()) 
            {
                dat = new municipios();
                dat.setId(rs.getInt("id_municipio"));
                dat.setNombre(rs.getString("municipio"));
                datos.add(dat);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
        return datos;
    }
    
    
}

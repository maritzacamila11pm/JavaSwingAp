
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camila.pe.cdatosdao;

import com.camila.pe.cmodelo.TipoDocumento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import javax.swing.JTable;

public class TipoDocumentoDao {
    private String mensaje;
    
    public String agregarTipoDocumento(Connection conn, TipoDocumento tipoDocumento ){
    PreparedStatement ps = null;
    String sql = "INSERT INTO TipoDocumento (nombre,siglas,nacionalidad,estado,fecha)"
            + "VALUES (?,?,?,?,?)";
    try {
        ps = conn.prepareStatement(sql);
        ps.setString(1,tipoDocumento.getNombre());
        ps.setString(2, tipoDocumento.getSiglas());
        ps.setString(3, tipoDocumento.getNacionalidad());
        ps.setString(4, tipoDocumento.getEstado());
        ps.setString(5, tipoDocumento.getFecha());
        ps.execute();
        ps.close();
        mensaje = "El tipo documento fue creado correctamente ";
    }catch (Exception e){
        mensaje = "Alto! error al crear tipo documento "+ e.getMessage();
        System.out.println(e.getMessage());
    }
    return mensaje;      
    }
    
//    SEGUNDO METODO ELIMINAR 
    public String eliminarTipoDocumento (Connection conn , TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "DELETE FROM TipoDocumento WHERE id_documento_identidad = ?";
        try{
        ps = conn.prepareStatement(sql);
        ps.setInt(1, tipoDocumento.getId_documento_identidad());
        ps.execute();
        ps.close();
        mensaje = "El tipo de documento fue eliminado correctamente";
        }catch (Exception e){
    mensaje = "Alto error al eliminar tipo documento " + e.getMessage();
        System.out.println(e.getMessage());
    }return mensaje;
  }
    
    //TERCER METODO MODIFICAR
     public String modificarTipoDocumento(Connection conn, TipoDocumento tipoDocumento){
        PreparedStatement ps = null;
        String sql = "UPDATE TipoDocumento"
                + " SET nombre =?,siglas=? , nacionalidad=?, estado=?,fecha=?"
                + " WHERE id_documento_identidad=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, tipoDocumento.getNombre());
            ps.setString(2, tipoDocumento.getSiglas());
            ps.setString(3, tipoDocumento.getNacionalidad());
            ps.setString(4, tipoDocumento.getEstado());
            ps.setString(5, tipoDocumento.getFecha());
            ps.setInt(6, tipoDocumento.getId_documento_identidad());
            ps.execute();
            ps.close();
            mensaje = "El tipo documento fue actualizado corectamente";
        } catch (Exception e) {
            mensaje = "Alto! error al actualizar tipo documento. " + e.getMessage();
            System.out.println(e.getMessage());
        }
        return mensaje;
    }
    
    //Cuarto Metodo - Listar Tipo Documento.
    public void listarTipoDocumento(Connection conn, JTable table){
        DefaultTableModel model;
        Statement statement = null;
        ResultSet resultSet = null;
        
        String[] columnas = {"id","Nombre","Sigla","Nacionalidad","estado","fecha"};
        model = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT * FROM TipoDocumento";
        String[] datosTP = new String[6];
        
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                TipoDocumento td = new TipoDocumento();
                td.setId_documento_identidad(resultSet.getInt("id_documento_identidad"));
                td.setNombre(resultSet.getString("nombre"));
                td.setSiglas(resultSet.getString("siglas"));
                td.setNacionalidad(resultSet.getString("nacionalidad"));
                td.setEstado(resultSet.getString("estado"));
                td.setFecha(resultSet.getString("fecha"));
                
                datosTP[0] = td.getId_documento_identidad()+"";
                datosTP[1] = td.getNombre()+"";
                datosTP[2] = td.getSiglas()+"";
                datosTP[3] = td.getNacionalidad()+"";
                datosTP[4] = td.getEstado()+"";
                datosTP[5] = td.getFecha()+"";

                model.addRow(datosTP);
            }
            table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
            System.out.println(e.getMessage());
        }
     }
}


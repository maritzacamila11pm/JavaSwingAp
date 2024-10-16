
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camila.pe.cnegocio;
import com.camila.pe.cdatosdao.TipoDocumentoDao;
import java.sql.Connection;
import com.camila.pe.cmodelo.TipoDocumento;
import com.maritza.pe.db.Conexion;
import java.sql.SQLException;
import javax.swing.JTable;

public class TipoDocumentoBO {
    private String mensaje ;
    TipoDocumentoDao tdd = new TipoDocumentoDao();
    
//    AGREGAR
    public String agregarTipoDocumento(TipoDocumento tipoDocumento)throws SQLException {
    Connection c = Conexion.getConnection();
    try{
       mensaje = tdd.agregarTipoDocumento(c, tipoDocumento);
       c.commit();
    }catch (Exception e ){
       c.rollback();
    }finally {
       c.close();
    }
    return mensaje;
    }
    
//    ELIMINAR
    public String eliminarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.eliminarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    MODIFICAR
    public String modificarTipoDocumento(TipoDocumento tipoDocumento) throws SQLException{
        Connection c = Conexion.getConnection();
        try {
            mensaje = tdd.modificarTipoDocumento(c, tipoDocumento);
            c.commit();
        } catch (Exception e) {
            c.rollback();
        } finally {
            c.close();
        }
        return mensaje;
    }
    
//    LISTAR
    public void listarTipoDocumento(JTable table){
        Connection c = Conexion.getConnection();
        tdd.listarTipoDocumento(c, table);
        try {
            c.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }
}

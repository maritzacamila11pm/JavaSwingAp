
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camila.pe.ctest;
import com.camila.pe.cmodelo.TipoDocumento;
import com.camila.pe.cnegocio.TipoDocumentoBO;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author Alumno-PB203
 */
public class Test {
     TipoDocumentoBO tdbo = new  TipoDocumentoBO();
    TipoDocumento td = new TipoDocumento();
    
    public  void insertar() throws SQLException, ParseException{
        td.setNombre("Documento");
        td.setSiglas("DNI");
        td.setNacionalidad("Peruana");
        td.setEstado("activo");
        td.setFecha("20-11-2024");

        tdbo.agregarTipoDocumento(td);
    }
    
    public  void eliminar() throws SQLException, ParseException{
        td.setId_documento_identidad(1);
        tdbo.eliminarTipoDocumento(td);
    }
    
    public  void modificar() throws SQLException, ParseException{
        td.setNombre("Carnet de extranjeria");
        td.setSiglas("CE");
        td.setNacionalidad("Extranjera");
        td.setEstado("Inactivo");
        td.setFecha("09-10-2024");
        td.setId_documento_identidad(2);
        
        tdbo.modificarTipoDocumento(td);
    }
    
    public static void main(String[] args) throws SQLException, ParseException {
        Test t = new  Test();
       t.insertar();
       // t.eliminar();
        t.modificar();
    }
}

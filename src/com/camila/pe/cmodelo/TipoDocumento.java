
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.camila.pe.cmodelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TipoDocumento {
    private int id_documento_identidad ;
    private String nombre;
    private String siglas;
    private String nacionalidad;
    private String estado;
    private Date fecha;

    public int getId_documento_identidad() {
        return id_documento_identidad;
    }

    public void setId_documento_identidad(int id_documento_identidad) {
        this.id_documento_identidad = id_documento_identidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     public String getFecha() {
        
        SimpleDateFormat dateformat  = new SimpleDateFormat("dd-MM-yyyy");
        return dateformat.format(fecha) ;
    }

    public void setFecha(String fecha)throws ParseException {
        SimpleDateFormat dateFormat  = new SimpleDateFormat("dd-MM-yyyy");
        this.fecha = dateFormat.parse(fecha);
    }
}

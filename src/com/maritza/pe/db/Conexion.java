
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maritza.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection con = null;
    private static String usuario = "TRABAJOF";
    private static String contraseña = "1234560";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConnection(){
    try{
        //cargar el controldador JDBC
        Class.forName("oracle.jdbc.OracleDriver");
        
        //Establecer la conexion con la base de datos
        con = DriverManager.getConnection(url,usuario,contraseña);
        con.setAutoCommit(false);
        
        System.out.println("Maritza ........");
        if(con != null ){
            System.out.println("Conexión exitosa good :)");
        }else{
            System.out.println("Error conexión fallida");
        }
        
    }catch(Exception e ){
        System.out.println("Error: "+e.getMessage());
    }
    return con;
    };
    public void closeConnection(){
        try{con.close();
        }catch (Exception e ){System.out.println("error al cerrar la conexion: "+ e.getMessage());
        
        }
    }
    public static void main (String[] args){
       // Conexion con = new Conexion();
     Conexion.getConnection();
        
    }
}

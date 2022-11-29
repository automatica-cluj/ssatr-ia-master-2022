/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.airticketreservationapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        try {
                //incarcare driver petru baza de date
                Class.forName("org.apache.derby.jdbc.ClientDriver");
 
                //conectare la baza de date            
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost/flightreservation;create=true","app","app");
                System.out.println("Conexiune la baza de date realizata.");
 
                //inchide cnexiune la baza de date
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
 
}
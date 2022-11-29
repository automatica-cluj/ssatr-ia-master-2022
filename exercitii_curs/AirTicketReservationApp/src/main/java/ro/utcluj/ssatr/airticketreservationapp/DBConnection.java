/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.airticketreservationapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mihai.hulea
 */
public class DBConnection {
     private Connection conn;
    
    public DBConnection() throws ClassNotFoundException, SQLException {
         Class.forName("org.apache.derby.jdbc.ClientDriver");
         conn = DriverManager.getConnection("jdbc:derby://localhost/flightreservation;create=true","app","app");
    }
    
    public void insertFlight(FlightInformation f) throws SQLException{
       Statement s = conn.createStatement();
       s.executeUpdate("INSERT INTO FLIGHTS(FLIGHTNUMBER, NOOFSEATS, DEPARTUREDATE) VALUES('"+f.getFlightNumber()+"',"+f.getNumberOfSeats()+",'"+f.getDepartureDate()+"')");
       s.close(); 
    }
//   
//    //OK
//    public void insertCar(Car e) throws SQLException{
//        Statement s = conn.createStatement();
//        s.executeUpdate("INSERT INTO PARKINGLOGS VALUES ('"+e.getPlateNumber()+"',"+e.getEntryTime()+",0)");        
//        s.close();
//    }
//    
//    //OK
    public FlightInformation findFlight(String flightNumber) throws SQLException{
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM FLIGHTS WHERE FLIGHTNUMBER='"+flightNumber+"'");
        if(rs.next()){
            return new FlightInformation(rs.getString("FLIGHTNUMBER"), rs.getInt("NOOFSEATS"),rs.getString("DEPARTUREDATE"));
        }else{
            return null;
        }           
    }
//    
//    public void deleteByPlateNumber(String plateNumber) throws SQLException{
//        Statement s = conn.createStatement();
//        s.executeUpdate("DELETE FROM CARACCESS WHERE PLATENUMBER='"+plateNumber+"'");        
//    }
    
//    
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        ParkingDbAccess db = new ParkingDbAccess();
////        db.insertCar(new Car("AB09BFG", System.currentTimeMillis()));
////        Car c1 = new Car("GL89ABF",System.currentTimeMillis());
////        db.insertCar(c1);
//        
//        Car gl = db.findByPlateNumber("GL81ABF");
//        
//        System.out.println(gl);
//        
//    }

    void updateSeats(String flightNumber, int noOfTikets) throws SQLException {
        Statement s = conn.createStatement();
        //UPDATE APP.FLIGHTS SET "NOOFSEATS" = 20 WHERE FLIGHTNUMBER = 'AAA';
        s.executeUpdate("UPDATE APP.FLIGHTS SET \"NOOFSEATS\" = "+noOfTikets+" WHERE FLIGHTNUMBER = '"+flightNumber+"'");
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBConnection db = new DBConnection();
        db.updateSeats("AAA", 1);
    }
}

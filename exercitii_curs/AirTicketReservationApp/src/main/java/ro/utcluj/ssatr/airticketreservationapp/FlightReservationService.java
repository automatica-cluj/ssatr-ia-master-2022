package ro.utcluj.ssatr.airticketreservationapp;

import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlightReservationService {
    DBConnection dbConn;
    
    private ArrayList<FlightInformation> list = new ArrayList<>();

    public FlightReservationService() {
        try {
            dbConn = new DBConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FlightReservationService.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        } catch (SQLException ex) {
            Logger.getLogger(FlightReservationService.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
    
    
    
    public void addNewFlight(String flightNumber, int noOfSeats, String departureDate){
        try {
            //....
            FlightInformation f = new FlightInformation(flightNumber,noOfSeats,departureDate);
            dbConn.insertFlight(new FlightInformation(flightNumber,noOfSeats,departureDate));
            list.add(new FlightInformation(flightNumber,noOfSeats,departureDate));
        } catch (SQLException ex) {
            Logger.getLogger(FlightReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean makeReservation(String flightNumber, int noOfTikets ){
        try {

            
            System.out.println("SERACH FLIGHT");
            FlightInformation f = dbConn.findFlight(flightNumber);
            System.out.println(f);
            if(f!=null){
                if(f.getNumberOfSeats()>=noOfTikets){
                    //........UPDATE ROW IN DATABASE
                    dbConn.updateSeats(flightNumber, f.getNumberOfSeats()-noOfTikets);
                    return true;
                }else{
                    System.out.println("Nomber of seats not available");
                }
            }else{
                System.out.println("No flight number found.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FlightReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
    public String getAllFlights(){
        String s = "";
        for(FlightInformation fi: list){
            s=s+fi.toString()+"\n";
        }
        s+="-------------------";
        return s;
    }
    
}

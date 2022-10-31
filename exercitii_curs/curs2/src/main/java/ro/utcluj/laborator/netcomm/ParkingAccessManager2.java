package ro.utcluj.laborator.netcomm;

import ro.utcluj.ssatr.curs2.parking.*;
import java.util.*;

public class ParkingAccessManager2 {
   
    //colectie care poate sotca un numar nelimita de masini 
    //daca dorim sa stocam elemente unice putem folosi HashSet
   private ArrayList<Car> list = new ArrayList<>(); 
   private ArrayList<Car> history = new ArrayList<>(); 
   
   
    public String handleCar(String msg) {
        Car c = new Car(msg);
        if(list.contains(c)){
            exitCar(msg);
            return "Car exited parking!";         
        }else{
            enterCar(c);
            return "Car parked!";
        }
    }
   
   //sa se modifice enterCar in asa fel incat sa nu permita adaugarea de elemente duplicat.
   public void enterCar(Car c){
       if(!list.contains(c)){
           c.setEntryTime(System.currentTimeMillis());
           list.add(c);
       }
       else
           System.out.println("Car already exists.");
   }

    void exitCar(String plateNumber) {
         //varianta 2
        Car tmp = new Car(plateNumber);
        int indx = list.indexOf(tmp);
        if(indx!=-1){
            Car c = list.get(indx);//metoda get NU sterge obiectul ci doar returneaza o referinta catre el.
            c.setExitTime(System.currentTimeMillis());
            System.out.println("Car is exiting. Payment required="+calculatePayment(c));
            list.remove(c); //dupa ce am calculat payment stergem obiectul din lista
            history.add(c);
        }

    }
    
    String getAllCarsAsString() {
        String s ="";
        for(Car c:list){
            s=s+c+"\n";
        }
        return s;
    }

    private int calculatePayment(Car c){
        return Math.round((c.getExitTime() - c.getEntryTime())/1000*3);     
    }

    String getAllHistoryCarsAsString() {
        String s ="";
        for(Car c:history){
            s=s+c+"\n";
        }
        return s;
    }


   
}

package ro.utcluj.ssatr.curs2.parking;

import java.util.*;

public class ParkingAccessManager2 {
   
    //colectie care poate sotca un numar nelimita de masini 
    //daca dorim sa stocam elemente unice putem folosi HashSet
    
   //ParkingDbAcess dbList;  
   private ArrayList<Car> current = new ArrayList<>(); 
   private ArrayList<Car> history = new ArrayList<>(); 
   
   //sa se modifice enterCar in asa fel incat sa nu permita adaugarea de elemente duplicat.
   public void enterCar(Car c){
       if(!current.contains(c)){
           c.setEntryTime(System.currentTimeMillis());
           current.add(c);
       }
       else
           System.out.println("Car already exists.");
   }

    void exitCar(String plateNumber) {
         //varianta 2
        Car tmp = new Car(plateNumber);
        int indx = current.indexOf(tmp);
        if(indx!=-1){
            Car c = current.get(indx);//metoda get NU sterge obiectul ci doar returneaza o referinta catre el.
            c.setExitTime(System.currentTimeMillis());
            System.out.println("Car is exiting. Payment required="+calculatePayment(c));
            current.remove(c); //dupa ce am calculat payment stergem obiectul din lista
            history.add(c);
        }

    }
    

    private int calculatePayment(Car c){
        return Math.round((c.getExitTime() - c.getEntryTime())/1000*3);     
    }
    
    String getAllCarsAsString() {
        String s ="";
        for(Car c:current){
            s=s+c+"\n";
        }
        return s;
    }

    String getAllHistoryCarsAsString() {
        String s ="";
        for(Car c:history){
            s=s+c+"\n";
        }
        return s;
    }

   
}

package ro.utcluj.laborator.netcomm;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ParkingAccessManager2 extends AbstractTableModel{
   
    //colectie care poate sotca un numar nelimita de masini 
    //daca dorim sa stocam elemente unice putem folosi HashSet
   private ArrayList<Car> list = new ArrayList<>(); 
   private ArrayList<Car> history = new ArrayList<>(); 
   
   
    public String handleCar(String msg) {
        Car c = new Car(msg);
        if(list.contains(c)){
            //int k = exitCar(msg);
            return "Exit car. Cost="+exitCar(msg);         
        }else{
            enterCar(c);
            return "Car parked!";
        }
    }
   
   //sa se modifice enterCar in asa fel incat sa nu permita adaugarea de elemente duplicat.
   public void enterCar(Car c){
       if(!list.contains(c)){
           c.setFreeParking(!history.contains(c));
           c.setEntryTime(System.currentTimeMillis());
           list.add(c);
       }
       else
           System.out.println("Car already exists.");
       fireTableDataChanged();
   }

    int exitCar(String plateNumber) {
         //varianta 2
        int cost = -1;
        Car tmp = new Car(plateNumber);
        int indx = list.indexOf(tmp);
        if(indx!=-1){
            Car c = list.get(indx);//metoda get NU sterge obiectul ci doar returneaza o referinta catre el.
            c.setExitTime(System.currentTimeMillis());
            cost = calculatePayment(c);
            System.out.println("Car is exiting. Payment required="+cost);
            list.remove(c); //dupa ce am calculat payment stergem obiectul din lista
            history.add(c);
        }
        fireTableDataChanged();
        return cost;
    }
    
    String getAllCarsAsString() {
        String s ="";
        for(Car c:list){
            s=s+c+"\n";
        }
        return s;
    }

    private int calculatePayment(Car c){
        return c.isFreeParking()?0:Math.round((c.getExitTime() - c.getEntryTime())/1000*3);     
    }

    String getAllHistoryCarsAsString() {
        String s ="";
        for(Car c:history){
            s=s+c+"\n";
        }
        return s;
    }

    ////////////////////////////////////////////

    @Override
    public int getRowCount() {
        return history.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       
        Car c = history.get(rowIndex);
        switch(columnIndex){
                case 0:return c.getPlateNumber();
                case 1:return ""+c.getEntryTime();
                case 2:return ""+c.getExitTime();
                case 3:return ""+c.isFreeParking();
        }
        return "N/A";
    }
    
    

   
}

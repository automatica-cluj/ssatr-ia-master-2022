/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.curs2.parking;


public class ParkingAccessManager {
    
    //java collections sunt alternative la array - in Curs 3 
    private Car[] cars = new Car[10]; // [null,null,null,....]
    
    
    
    /**
     * Car added in parking lot.
     * 
     * @param c - car to be added.
     */
    void enterCar(Car c){
        //parcurg lista si caut primul loc liber in care voi adauga obiectul de tip car. 
        //obiectul de tip car va trebuie sa stoceze ora de intrare
        
        for(int i=0;i<cars.length;i++){
            if(cars[i]==null){
                cars[i] = c;
                c.setEntryTime(System.currentTimeMillis());
                System.out.println("Car parked on slot "+i+".");
                return;
            }
        }
        System.out.println("No empty slot found for parking the car.");
    }
    
    /**
     * Car exit from parking.
     * 
     * @param plateNumber - car plate number which must be removed.
     * @return total payment.
     */
    int exitCar(String plateNumber){
        //parcurg lista de masin si caut masina cu numarul de inmatriculare cautat 
        //daca am gasit masina - fac diferenta dintre timpul curent si timpul de intrare al masinii,
        //calculez taxa de parcare, scot masina din parcare si returnez valoarea taxei
        
        for(int i=0;i<cars.length;i++){
            if(cars[i].getPlateNumber().equals(plateNumber)){
                //am gasit masina cautata
                cars[i].setExitTime(System.currentTimeMillis());
                int payment = calculatePayment(cars[i]);
                Car t = cars[i];
                cars[i] = null;               
                System.out.println("Car "+t+" has exited parking. Payment="+payment);
                return payment;
            }
        }//.
        return 0;
    }
    
    void listAllCars(){
        System.out.println("Cars in parking:");
        for(Car c:cars){
            System.out.println(c);
        }
        System.out.println("------------");
    }
    
    String getAllCarsAsString(){
        String s ="";
        for(Car c:cars){
            s=s+c+"\n";
        }
        return s;
    }
    
    private int calculatePayment(Car c){
        return Math.round((c.getExitTime() - c.getEntryTime())/1000*3);
        
    }
}

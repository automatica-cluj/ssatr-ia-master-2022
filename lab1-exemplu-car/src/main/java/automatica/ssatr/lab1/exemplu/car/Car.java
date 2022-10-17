
package automatica.ssatr.lab1.exemplu.car;

public class Car {
    private boolean status;
    private int speed;
    private String name;

    public Car(String name) {
        this.name = name;
    }
    
    void startCar(){
        System.out.println("Starting car!");
        status = true;
    }
    
    int accelerate(){
        if(status){
            speed++;
            System.out.println("Current speed= "+speed);
            return speed;
        }else{
            System.out.println("Car not started");
            return speed;
        }
    }
    
    String getName(){
        return name;
    }
      
    
}

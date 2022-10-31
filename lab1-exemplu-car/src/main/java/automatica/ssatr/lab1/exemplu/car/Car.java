
package automatica.ssatr.lab1.exemplu.car;

public class Car {
    private boolean status;
    private int speed;
    private String name;
    private Engine e;

    public Car(String name,Engine e) {
        this.name = name;
        //this.e = new Engine();
        this.e = e;
    }
    
    void startCar(){
        System.out.println("Starting car!");
        e.start();
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

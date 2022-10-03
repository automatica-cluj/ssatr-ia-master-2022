
package com.mycompany.lab1.exemple1;

public class Car {
   private Engine e;
   private String model;
   private int speed;
   
    public Car(Engine e) {
        this.e = e;
        this.speed = 0;
        this.model = "Dacia";
    }
   
   public void startCar(){
       e.startEngine();
       System.out.println("Car is starting.");
   }
   
   public void accelerate(){
       if(e.isStarted()){    
           speed++;
           System.out.println("Car is accelerating.spped="+speed);
       }else{
           System.out.println("Car engine not started. Cannot acccelerate.");
       }
   }
   
   
}

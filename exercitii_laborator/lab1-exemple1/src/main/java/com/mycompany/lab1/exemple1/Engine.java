package com.mycompany.lab1.exemple1;

public class Engine {
   private boolean state;
   private String type;

    public Engine(boolean state, String type) {
        this.state = state;
        this.type = type;
    }
    
    
    public void startEngine(){
        state = true;
        System.out.println("Engine started.");
    }
   
    public void stopEngine(){
        state = false;
        System.out.println("Engine stopped.");
    }
    
    public boolean isStarted(){
        return state;
    }
    
    public void displayInfo(){
        System.out.println("Engine "+type+" state="+state);
    }
   
}

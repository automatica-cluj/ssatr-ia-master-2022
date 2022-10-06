/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.curs1.oop;

/**
 *
 * @author mihai
 */
public class Factory {
    
    private String factoryName;
    private Robot machine1;
    private Robot machine2;

    public Factory(String factoryName) {
        this.factoryName = factoryName;
    }
    
    //ALT INSERT

    public void setMachine1(Robot machine1) {
        this.machine1 = machine1;
    }

    public void setMachine2(Robot machine2) {
        this.machine2 = machine2;
    }

    public String getFactoryName() {
        return factoryName;
    }
    
    
    public void process(String part){
        System.out.println("Factory is processing "+part);
        machine1.moveLeft();
        machine2.moveRight();
        System.out.println("End processing");
    }
    
}

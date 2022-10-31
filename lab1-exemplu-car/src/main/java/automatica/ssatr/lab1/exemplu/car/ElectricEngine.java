/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.lab1.exemplu.car;

/**
 *
 * @author mihai
 */
public class ElectricEngine extends Engine{
    
    @Override
    void stop() {
        System.out.println("Start ElectricEngine engine!");
    }

    @Override
    void start() {
        System.out.println("Stop ElectricEngine engine!");
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.curs1.oop;

/**
 *
 * @author mihai
 */
public class ExempluFactoryTest {
    public static void main(String[] args) {
        Factory f1 = new Factory("Factory AAA");
        
        f1.setMachine1(new Robot("A",1));
        f1.setMachine2(new Robot("B",1));
        
        f1.process("PART A");
        
        System.out.println(f1.getFactoryName());
        
    }
}

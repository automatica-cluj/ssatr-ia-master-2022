/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package automatica.ssatr.lab1.exemplu.car;

public class Lab1ExempluCar {

    public static void main(String[] args) {
        System.out.println("Hello Car!");
        Engine x = new Engine();
        Car c1 = new Car("AUDI",x);
        c1.accelerate();
        c1.startCar();
        c1.accelerate();
                
    }
}

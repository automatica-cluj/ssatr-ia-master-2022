/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.lab1.exemple1;

/**
 *
 * @author mihai
 */
public class Lab1Exemple1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Engine e1 = new Engine(false, "Electric");
        Engine e2 = new Engine(false, "Electric");
        e1.startEngine();
        
        e1.displayInfo();
        e2.displayInfo();
        
        System.out.println(e1);
        System.out.println(e2);
        
        e1 = e2;
        
        e2.displayInfo();
        
        //////////////////////////
        
        
        Car c1 = new Car(e1);
        c1.startCar();
        c1.accelerate();
        
        Car c2 = new Car(new Engine(false,"Diesel"));
        c2.startCar();
    }
}

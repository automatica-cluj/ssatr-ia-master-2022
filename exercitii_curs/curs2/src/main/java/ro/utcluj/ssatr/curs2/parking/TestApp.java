/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.curs2.parking;

/**
 *
 * @author mihai.hulea
 */
public class TestApp {
    public static void main(String[] args) throws InterruptedException {
        ParkingAccessManager pam = new ParkingAccessManager();
        Car c1 = new Car("CJ01BAA");
        Car c2 = new Car("CJ02CAA");
        Car c3 = new Car("CJ03DAA");
        pam.enterCar(c1);
        pam.enterCar(c2);
        pam.enterCar(c3);        
        pam.listAllCars();       
        Thread.sleep(5000); //sleep 5 secunde 
        pam.exitCar("CJ02CAA");
        pam.listAllCars();
        
    }
}

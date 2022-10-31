/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.curs2.agregare;

/**
 *
 * @author mihai.hulea
 */
public class Battery {
    private int capacity; //incapsulare prin delcare atribute private 

    public Battery(int capacity) {
        this.capacity = capacity;
    }
    
    //accesul la atribute se permite doar prin gettere si settere 

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Battery{" + "capacity=" + capacity + '}';
    }
    
    
    
}

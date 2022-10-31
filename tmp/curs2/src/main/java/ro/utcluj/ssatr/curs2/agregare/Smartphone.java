/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.curs2.agregare;

/**
 * Ilustrarea conceptului de agregare\compizitie. 
 * http://207.154.194.102/java1:oop:reutilizareaclaselor
 * 
 * pentru diferenta intre agregare si compozitie a se vedea cursul UML Class diagrams - Cursul 3 
 * @author mihai.hulea
 */
public class Smartphone {
    private Battery b;

    public Smartphone(Battery b) { //agregare 
        this.b = b;
    }
    
    public Smartphone() { //compozitie
        this.b = new Battery(100); 
    }
    
    public void call(){
        if(b.getCapacity()>1){
            System.out.println("Make call!");
            b.setCapacity(b.getCapacity()-1);
        }else{
            System.out.println("Battery low, no call possible!");
        }
    }

    @Override
    public String toString() {
        return "Smartphone{" + "b=" + b + '}';
    }
    
    
    
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone(new Battery(20));
        Smartphone s2 = new Smartphone(new Battery(20));
        
        s1.call();
        s1.call();
        
        System.out.println(s1);
    }
}

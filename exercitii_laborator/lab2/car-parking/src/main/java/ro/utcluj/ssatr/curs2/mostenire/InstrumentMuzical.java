/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.utcluj.ssatr.curs2.mostenire;

import java.util.Random;


//clasa de baza
public class InstrumentMuzical {
    
    void canta(){
        System.out.println("Instrumentul canta!");
    }
    
    public static void main(String[] args) {
        Random r = new Random();
        InstrumentMuzical[] orchestra = new InstrumentMuzical[10];
        for(int i=0;i<orchestra.length;i++){
            int x = r.nextInt(10); //random number in 0 - 10 
            if(x<5)
                orchestra[i] = new Pian();
            else
                orchestra[i] = new Vioara();
                        
        }
        
        //mecanismul de identificare la runtime a tipului concret al obicetului dintro ierarhie = polimorifsm 
        for(InstrumentMuzical k : orchestra){
            k.canta();
        }
        
    }
    
}
//..............................
class Pian extends InstrumentMuzical{
    void canta(){
        System.out.println("Pianul canta.");
    }
}

class Vioara extends InstrumentMuzical{

    @Override //adnotare - specifica compilatorului faptul ca dorim sa suprascriem o metoda din clasa de baza
    void canta() {
        System.out.println("Vioara canta."); 
   }
    
}

class Orchestra{
    InstrumentMuzical[] lista = new InstrumentMuzical[10];
}

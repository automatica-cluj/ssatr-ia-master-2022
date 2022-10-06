
package automatica.ssatr.curs1.oop;


public class Curs1Oop {

    public static void main(String[] args) {
        System.out.println("Hello Robots!");
        //obiectele sunt tipuri referinta
        Robot r1 = new Robot("ABC",10);
        r1.displayRobot();
      
        r1.moveLeft();
        
        System.out.println(r1);
        
        Robot r2 = new Robot("ABC",90);
        
        r2.displayRobot();
        
        
        Robot r3;
        
        r3 = r2;
        
        r3.moveLeft();
        
        r1 = r3;
        
        r1.moveLeft();
    }
}

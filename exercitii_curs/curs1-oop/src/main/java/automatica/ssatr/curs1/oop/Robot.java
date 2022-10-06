
package automatica.ssatr.curs1.oop;

public class Robot {
    
    private String name;
    private int x; 
    
    // ALT + Inser 

    public Robot(String name, int x) {
        this.name = name;
        this.x = x;
    }

    
    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }
    
    
    
    void moveLeft(){
        x = x-1;
        displayRobot();
    }
    
    void moveRight(){
        x+=1;
        displayRobot();
    }
    
    void displayRobot(){
        System.out.println("Robot[name="+name+" x="+x+"]");
    }
    
}

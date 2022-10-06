package automatica.ssatr.curs1.oop;


public class RobotXY extends Robot{
    
    private int y;

    public RobotXY(String name, int x, int y) {
        super(name, x);
        this.y = y;
    }
    
    public void moveYLeft(){
        y=y-1;
    }
    
    public void moveYRight(){
        y=y+1;
    }

    @Override
    void displayRobot() {
        System.out.println("Robot[name="+this.getName()+" x="+this.getX()+" y="+y+"]");
//        super.displayRobot();
//        System.out.println("y = "+y);

    
    }
    
    
    
}

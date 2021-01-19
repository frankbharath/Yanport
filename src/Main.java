import constants.VacuumConstants.*;

public class Main {
    public static void main(String[] args){
        Vacuum vacuum=new Vacuum(8,2,new Grid(10, 10), Orientation.NORTH);
        //vacuum.logActions(true);
        vacuum.executeInstructions("GADAAADAAGAGA");
        System.out.println("x="+vacuum.getX()+ " y="+vacuum.getY()+" orientation="+vacuum.getOrientationChar());
    }
}

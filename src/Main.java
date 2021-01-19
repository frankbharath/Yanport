import constants.VacuumConstants.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int status;
        do{
            System.out.println("Dimension de la grille:");
            System.out.print("x:");
            int gridX=scan.nextInt();
            System.out.print("y:");
            int gridY=scan.nextInt();
            System.out.println("Position initiale de l’aspirateur:");
            System.out.print("x:");
            int vacuumX=scan.nextInt();
            System.out.print("y:");
            int vacuumY=scan.nextInt();
            System.out.print("orientation:");
            char orientation=scan.next().charAt(0);
            System.out.print("Instructions:");
            String instructions=scan.next();
            Vacuum vacuum=new Vacuum(vacuumX, vacuumY, new Grid(gridX, gridY), Orientation.getValueForOrientation(orientation));
            vacuum.executeInstructions(instructions);
            System.out.println("x="+vacuum.getX()+ " y="+vacuum.getY()+" orientation="+vacuum.getOrientation());
            System.out.print("Press 1 to continue, 2 to exit...");
            status=scan.nextInt();
        }while(status==1);
        scan.close();
    }
}

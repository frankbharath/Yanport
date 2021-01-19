import constants.VacuumConstants.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VacuumTest {

    @Test
    public void testIfVacuumGoesOutOfGrid(){
        Vacuum vacuum=new Vacuum(0,0,new Grid(10,10), Orientation.WEST);
        Throwable exception = assertThrows(RuntimeException.class, () -> vacuum.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum1=new Vacuum(0,0,new Grid(10,10), Orientation.SOUTH);
        exception = assertThrows(RuntimeException.class, () -> vacuum1.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum2=new Vacuum(9,9,new Grid(10,10), Orientation.NORTH);
        exception = assertThrows(RuntimeException.class, () -> vacuum2.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum3=new Vacuum(9,9,new Grid(10,10), Orientation.EAST);
        exception = assertThrows(RuntimeException.class, () -> vacuum3.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());
    }

    @Test
    public void testVacuumForActions(){
        Vacuum vacuum=new Vacuum(5,5,new Grid(10,10), Orientation.NORTH);
        vacuum.executeInstructions("DADADADAA");
        assertEquals(vacuum.getX(), 5);
        assertEquals(vacuum.getY(), 6);
        assertEquals(vacuum.getOrientationChar(), 'N');

        vacuum=new Vacuum(0,0,new Grid(10,10), Orientation.NORTH);
        vacuum.executeInstructions("ADADAGAGA");
        assertEquals(vacuum.getX(), 2);
        assertEquals(vacuum.getY(), 1);
        assertEquals(vacuum.getOrientationChar(), 'N');

        vacuum=new Vacuum(8,2,new Grid(10,10), Orientation.WEST);
        vacuum.executeInstructions("GADAAADAAGAGA");
        assertEquals(vacuum.getX(), 4);
        assertEquals(vacuum.getY(), 2);
        assertEquals(vacuum.getOrientationChar(), 'S');

        vacuum=new Vacuum(1,1,new Grid(3,3), Orientation.EAST);
        vacuum.executeInstructions("AGAGAAGAA");
        assertEquals(vacuum.getX(), 0);
        assertEquals(vacuum.getY(), 0);
        assertEquals(vacuum.getOrientationChar(), 'S');
    }
}

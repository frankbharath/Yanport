import constants.VacuumConstants.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VacuumTest {

    @Test
    public void testIfVacuumGoesOutOfGrid(){
        Vacuum vacuum=new Vacuum(0,0,new Grid(10,10), Orientation.getOrientation('W'));
        Throwable exception = assertThrows(RuntimeException.class, () -> vacuum.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum1=new Vacuum(0,0,new Grid(10,10), Orientation.getOrientation('S'));
        exception = assertThrows(RuntimeException.class, () -> vacuum1.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum2=new Vacuum(9,9,new Grid(10,10), Orientation.getOrientation('N'));
        exception = assertThrows(RuntimeException.class, () -> vacuum2.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());

        Vacuum vacuum3=new Vacuum(9,9,new Grid(10,10), Orientation.getOrientation('E'));
        exception = assertThrows(RuntimeException.class, () -> vacuum3.executeInstructions("A"));
        assertEquals("Vacuum cleaner cannot move", exception.getMessage());
    }

    @Test
    public void testVacuumForActions(){
        Vacuum vacuum=new Vacuum(5,5,new Grid(10,10), Orientation.getOrientation('N'));
        vacuum.executeInstructions("DADADADAA");
        assertEquals(vacuum.getX(), 5);
        assertEquals(vacuum.getY(), 6);
        assertEquals(vacuum.getOrientation(), 'N');

        vacuum=new Vacuum(0,0,new Grid(10,10), Orientation.getOrientation('N'));
        vacuum.executeInstructions("ADADAGAGA");
        assertEquals(vacuum.getX(), 2);
        assertEquals(vacuum.getY(), 1);
        assertEquals(vacuum.getOrientation(), 'N');

        vacuum=new Vacuum(8,2,new Grid(10,10), Orientation.getOrientation('W'));
        vacuum.executeInstructions("GADAAADAAGAGA");
        assertEquals(vacuum.getX(), 4);
        assertEquals(vacuum.getY(), 2);
        assertEquals(vacuum.getOrientation(), 'S');

        vacuum=new Vacuum(1,1,new Grid(3,3), Orientation.getOrientation('E'));
        vacuum.executeInstructions("AGAGAAGAA");
        assertEquals(vacuum.getX(), 0);
        assertEquals(vacuum.getY(), 0);
        assertEquals(vacuum.getOrientation(), 'S');
    }
}

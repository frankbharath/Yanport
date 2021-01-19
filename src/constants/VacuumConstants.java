package constants;

/**
 * @author frank
 * @date 18/01/2021 19:00 PM
 * This class provides constant variables for Vacuum class.
 */

public class VacuumConstants {

    // Assigning numerical value for given directions
    public enum Orientation {
        NORTH(0, 'N'),
        EAST(1, 'E'),
        SOUTH(2, 'S'),
        WEST(3, 'W');
        public final int value;
        public final char key;
        Orientation(int value, char orientation){
            this.value=value;
            this.key=orientation;
        }
    }

    // There are two types of command i) Rotate vacuum cleaner to particular direction ii) Move the vacuum cleaner
    public enum CommandType{
        ROTATE, MOVE;
    }

    // As of now there are 3 commands D(Right), G(Left) and A(Move).
    public enum Command{
        RIGHT(1, CommandType.ROTATE, 'D'),
        LEFT(-1, CommandType.ROTATE, 'G'),
        MOVE(1, CommandType.MOVE, 'A');
        public final int value;
        public final CommandType commandType;
        public final char key;
        Command(int value, CommandType commandType, char command){
            this.value=value;
            this.commandType=commandType;
            this.key=command;
        }
    }

}

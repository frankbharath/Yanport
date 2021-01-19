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
        public static int getValueForOrientation(char orientation){
            for(Orientation o:Orientation.values()){
                if(o.key==orientation){
                    return o.value;
                }
            }
            throw new IllegalArgumentException("Orientation not found");
        }
        public static char getOrientationForValue(int value){
            for(Orientation o:Orientation.values()){
                if(o.value==value){
                    return o.key;
                }
            }
            throw new IllegalArgumentException("Orientation not found");
        }
        public static Orientation getOrientation(char orientation){
            for(Orientation o:Orientation.values()){
                if(o.key==orientation){
                    return o;
                }
            }
            throw new IllegalArgumentException("Orientation not found");
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
        public static Command getCommand(char c){
            for(Command command:Command.values()){
                if(command.key==c){
                    return command;
                }
            }
            throw new IllegalArgumentException("Command not found");
        }
    }

}

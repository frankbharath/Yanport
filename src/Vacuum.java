import constants.VacuumConstants.*;

/**
 * @author frank
 * @date 18/01/2021 18:30 PM
 * This class provides a Vacuum cleaner object, the goal of the object is to move across the grid based on instructions
 */
public class Vacuum {
    // x, y and orientation represents the position and orientation of the vacuum cleaner
    private int x, y, orientation;

    // gird represents the rectangle layout where the vacuum cleaner moves
    private final Grid grid;

    // customization option to log the current action of the vacuum cleaner
    private boolean log;

    // MOVE_X and MOVE_Y provides navigation value that will be used by vacuum cleaner to move towards particular
    // orientation. For example, if the orientation is set to NORTH, then the vacuum cleaner will use 0th index on both
    // MOVE_X and MOVE_Y to move towards NORTH of the grid.
    private static final int[] MOVE_X={0,1,0,-1};
    private static final int[] MOVE_Y={1,0,-1,0};

    // Total number of orientation is NORTH, SOUTH, WEST, EAST
    private static final int TOTAL_ORIENTATIONS=4;

    // returns initial or final X coordinate of the vacuum cleaner.
    public int getX() {
        return x;
    }

    // returns initial or final Y coordinate of the vacuum cleaner.
    public int getY() {
        return y;
    }

    // returns initial or final orientation of the vacuum cleaner.
    public char getOrientation(){
        return Orientation.getOrientationForValue(this.orientation);
    }

    // creates new object for vacuum cleaner, all the given parameters are mandatory for vacuum cleaner to work.
    public Vacuum(int x, int y, Grid grid, int orientation){
        // validating the state parameters of the vacuum cleaner to ensure
        // that we are dealing with sanitized value.
        String error="The argument %s is invalid";
        if(x<0){
            throw new IllegalArgumentException(String.format(error,"x"));
        }
        if(y<0) {
            throw new IllegalArgumentException(String.format(error, "y"));
        }
        if(grid==null){
            throw new IllegalArgumentException(String.format(error, "grid"));
        }
        this.x=x;
        this.y=y;
        this.grid=grid;
        this.orientation=orientation;
    }

    // Vacuum cleaner receives the commands that needs to be executed
    public void executeInstructions(String commands){
        char[] actionArray=commands.toCharArray();
        for(char c:actionArray){
            // There are 3 commands as of now D, G and A, and cross checking if the command exist or not
            Command command=Command.getCommand(c);
            if(command!=null){
                // checking the type of command here, if the command is to rotate, then I will change the
                // orientation of the vacuum cleaner.
                // If the command is to move the vacuum cleaner, then I will move the vacuum cleaner.
                if(command.commandType.equals(CommandType.ROTATE)){
                    changeDirection(command);
                }else{
                    moveVacuum(command);
                }
            }else{
                // exception will be thrown if command is not found.
                throw new IllegalArgumentException("The argument commands is invalid");
            }
        }
    }
    // Changes the direction of the vacuum cleaner
    private void changeDirection(Command command){
        // getting the current orientation of the vacuum cleaner to change.
        char old = Orientation.getOrientationForValue(this.orientation);
        // There are 4 directions as of now, i) North, ii) East, iii) South, iv) West. In numerical terms there are represented as 0(North), 1(East), 2(South), 3(West)
        // If the position of the vacuum cleaner is at North and the current command is 'G(rotate left)', then the vacuum should be
        // facing West, below line determines which direction the vacuum cleaner should face.
        this.orientation=(((this.orientation+command.value)%TOTAL_ORIENTATIONS)+TOTAL_ORIENTATIONS)%TOTAL_ORIENTATIONS;
        log("Vacuum cleaner rotated from "+old+" to "+Orientation.getOrientationForValue(this.orientation));
    }

    // Moves the vacuum cleaner in the current direction
    private void moveVacuum(Command command){
        int x=MOVE_X[this.orientation];
        int y=MOVE_Y[this.orientation];
        // Calculating new position for the vacuum.
        int newX=this.x+(x*(command.value));
        int newY=this.y+(y*(command.value));
        // If the new position is not inside the grid, then exception will be thrown.
        if(newX<0 || newX>=grid.x || newY<0 || newY>=grid.y){
            throw new RuntimeException("Vacuum cleaner cannot move");
        }
        int oldX=this.x;
        int oldY=this.y;
        this.x=newX;
        this.y=newY;
        log("Vacuum cleaner moved from "+oldX+", "+oldY+" to "+this.x+", "+this.y);
    }


    // Sets log variable to true or false.
    public void logActions(boolean log){
        this.log=log;
    }

    // Logs the vacuum actions based on the log variable.
    private void log(String message){
        if(this.log){
           System.out.println(message);
        }
    }
}


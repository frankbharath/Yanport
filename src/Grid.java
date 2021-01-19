/**
 * @author frank
 * @date 18/01/2021 19:30 PM
 * This class provides a Grid object, the object provides a layout for the Vacuum object where it can move.
 */
public class Grid {
    final int x;
    final int y;
    Grid(int x, int y){
        String error="The argument %s is invalid";
        if(x<0){
            throw new IllegalArgumentException(String.format(error,"x"));
        }
        if(y<0) {
            throw new IllegalArgumentException(String.format(error, "y"));
        }
        this.x=x;
        this.y=y;
    }
}

package spaceinvaders.data;
/**
 * This is a data class for player
 */
public class Player {
    
    public boolean moveRight;
    public boolean moveLeft;
    public boolean visible;
    public int x;
    public int y;
    public int s;
    
    public Player (int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
        moveLeft = false;
        moveRight = false;
        visible = true;
    }
}

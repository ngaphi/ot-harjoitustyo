package spaceinvaders.data;
/**
 * This is a data class for invader
 */
public class Invader{
    
    public boolean moveRight;
    public boolean moveLeft;
    public boolean visible;
    
    public int x;
    public int y;
    public int s;
    
    public Invader (int x, int y, int s) {  
        this.x = x;
        this.y = y;
        this.s = s;
        
        moveLeft = false;
        moveRight = true;
        visible = true;
    }
}

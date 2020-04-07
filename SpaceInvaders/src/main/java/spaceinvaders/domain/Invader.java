package spaceinvaders.domain;

public class Invader{
    
    public boolean moveRight;
    public boolean moveLeft;
    boolean isVisible;
    
    public int x;
    public int y;
    public int s;
    
    public Invader (int x, int y, int s) {  
        this.x = x;
        this.y = y;
        this.s = s;
        
        moveLeft = false;
        moveRight = true;
        isVisible = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getS() {
        return s;
    }
    
    
}

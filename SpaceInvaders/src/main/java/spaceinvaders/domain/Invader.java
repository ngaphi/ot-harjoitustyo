package spaceinvaders.domain;

public class Invader{
    
    public boolean moveRight;
    public boolean moveLeft;
    public boolean visible;
    public boolean disappear;
    
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getS() {
        return s;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void die() {
        visible = false;
    }

    public void setDisappear(boolean disappear) {
        this.disappear = disappear;
    }
    
    public boolean isDisappearing() {
        return this.disappear;
    }
}

package spaceinvaders.domain;

public class Player {
    
    public boolean moveRight;
    public boolean moveLeft;
    public boolean visible;
    int x;
    int y;
    int s;
    
    public Player (int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
        moveLeft = false;
        moveRight = false;
        visible = true;
    }
    
    public boolean MoveRight() {
        return moveRight;
    }
    
    public boolean MoveLeft() {
        return moveLeft;
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
}

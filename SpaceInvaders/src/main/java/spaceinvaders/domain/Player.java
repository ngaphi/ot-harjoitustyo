package spaceinvaders.domain;

public class Player {
    
    public boolean moveRight;
    public boolean moveLeft;
    int x;
    int y;
    int s;
    
    public Player (int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.s = s;
        moveLeft = false;
        moveRight = false;
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
    
    
}

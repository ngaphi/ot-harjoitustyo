package spaceinvaders.domain;

public class Bullet {
    int x;
    int y;
    int width;
    int height;
    boolean visible;
    boolean readyToFire, shot;
    
    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        visible = true;
        readyToFire = false;
        shot = false;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void die() {
        visible = false;
    }
}

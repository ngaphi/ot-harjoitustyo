package spaceinvaders.data;

public class Bullet{
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean visible;
    public boolean shot;
    
    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.visible = true;
        shot = true;
    }
}

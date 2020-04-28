package spaceinvaders.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import spaceinvaders.data.Bullet;
import spaceinvaders.data.Invader;
import spaceinvaders.data.Sizes;

public class BulletService {

    private final List<Bullet> bullets;
    private int deaths;
    private long lastBulletShot;

    public BulletService() {
        this.bullets = new ArrayList<>();
        this.deaths = 0;
        this.lastBulletShot = 0;
    }

    public List<Bullet> getBullets() {
        return this.bullets;
    }

    public void shoot(int x, int y) {
        if(System.currentTimeMillis() - lastBulletShot > Sizes.SHOT_DELAY){
            bullets.add(new Bullet(x + 13, y, 4, 8));
            lastBulletShot=System.currentTimeMillis();
        }
    }

    public void updateBullets() {
        ListIterator<Bullet> it = bullets.listIterator();

        while (it.hasNext()) {
            Bullet b = it.next();

            if (!b.visible) {
                it.remove();
            } else {
                b.y -= 10;
            }
        }
    }

    public boolean collision(List<Invader> in) {
        for (Bullet bullet : bullets) {
            for (Invader invader : in) {
                if (invader.visible && bullet.visible) {
                    int bulletX = bullet.x;
                    int bulletY = bullet.y;
                    int inX = invader.x;
                    int inY = invader.y;

                    if (bulletHitsInvader(bulletX, bulletY, inX, inY)) {
                        invader.visible = false;
                        bullet.visible = false;
                        deaths++;
                    }
                }
            }
        }

        return deaths == Sizes.NUMBER_OF_INVADERS_TO_DESTROY;
    }

    private boolean bulletHitsInvader(int bulletX, int bulletY, int inX, int inY) {
        return bulletX >= (inX)
                && bulletX <= (inX + Sizes.INVADER_WIDTH)
                && bulletY >= (inY)
                && bulletY <= (inY + Sizes.INVADER_HEIGHT);
    }
}

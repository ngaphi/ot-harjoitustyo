package spaveinvaders.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.controller.BulletService;
import spaceinvaders.controller.InvaderService;
import spaceinvaders.controller.PlayerService;

public class BulletServiceTest {
    BulletService b;
    InvaderService i;
    private int speed;

    @Before
    public void setUp() {
        b = new BulletService();
        i = new InvaderService(speed);
    }
    
    @Test
    public void shootingIsWorkingCorrectly() {
        
    }
    
    @Test
    public void bulletHittingInvaderIsWorkingCorrectly() {
        b.getBullets().get(0).x = 20;
        b.getBullets().get(0).y = 20;
        
        i.getInvaders().get(1).x = 20;
        i.getInvaders().get(1).y = 20;
        
        assertTrue(b.collision(i.getInvaders()));
    }
}


package spaveinvaders.controller;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.controller.InvaderService;
import spaceinvaders.data.Sizes;

public class InvaderServiceTest {
    InvaderService i;
    private int speed;

    @Before
    public void setUp() {
        i = new InvaderService(speed);
    }
    
    @Test
    public void invadersAreMovingLeftOrRightCorrectly() {
       //1. part
       i.getInvaders().get(0).moveRight=true;
       i.getInvaders().get(0).moveLeft=false;
       
       i.moveInvaders();
       
       assertEquals(10, i.getInvaders().get(0).x);
       assertEquals(10, i.getInvaders().get(0).y);
       
        //2. part     
        i.getInvaders().get(4).x = Sizes.BOARD_WIDTH-10;
        i.getInvaders().get(4).y = Sizes.BOARD_HEIGHT-20;
        
        i.getInvaders().get(4).moveRight=false;
        i.getInvaders().get(4).moveLeft=true;
        
        i.moveInvaders();
        
        assertEquals(490, i.getInvaders().get(4).x);
        assertEquals(480, i.getInvaders().get(4).y); 
    }
    
    @Test
    public void invadersAreMovingDownCorrectly() {
        i.getInvaders().get(4).x = 520;
        i.getInvaders().get(3).x = 480;
        i.getInvaders().get(2).x = 440;
        i.getInvaders().get(1).x = 400;
        i.getInvaders().get(0).x = 360;
        
        i.getInvaders().get(4).y = 10;
        i.getInvaders().get(3).y = 10;
        i.getInvaders().get(2).y = 10;
        i.getInvaders().get(1).y = 10;
        i.getInvaders().get(0).y = 10;
        
        i.getInvaders().get(9).x = 520;
        i.getInvaders().get(8).x = 480;
        i.getInvaders().get(7).x = 440;
        i.getInvaders().get(6).x = 400;
        i.getInvaders().get(5).x = 360;
        
        i.getInvaders().get(9).y = 50;
        i.getInvaders().get(8).y = 50;
        i.getInvaders().get(7).y = 50;
        i.getInvaders().get(6).y = 50;
        i.getInvaders().get(5).y = 50;
        
        i.moveInvaders();
        
        assertEquals(60, i.getInvaders().get(9).y);         
    }
    
    @Test
    public void invadersAreWinning() {
        i.getInvaders().get(9).y = 381;
        assertTrue(i.invadersWon());
        
        i.getInvaders().get(9).y = 370;
        assertFalse(i.invadersWon());
    }

}

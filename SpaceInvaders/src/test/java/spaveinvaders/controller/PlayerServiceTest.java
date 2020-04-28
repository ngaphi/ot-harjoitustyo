package spaveinvaders.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import spaceinvaders.controller.PlayerService;

public class PlayerServiceTest {
    
    PlayerService p;

    @Before
    public void setUp() {
        p = new PlayerService();
    }
    
    @Test
    public void playerIsMovingCorrectly() {
        p.movePlayer();
        assertEquals(235, p.getPlayerX());
        assertEquals(390, p.getPlayerY());
        
        //player is moving right correctly
        p.setMoveRight(true);
        p.setMoveLeft(false);
        p.movePlayer();
        assertEquals(235+p.getPlayerS(), p.getPlayerX());
        assertEquals(390, p.getPlayerY());
        
        //player is moving left correctly
        p.setMoveRight(false);
        p.setMoveLeft(true);
        p.movePlayer();
        assertEquals(235, p.getPlayerX());
        assertEquals(390, p.getPlayerY());
    }
     
    @Test
    public void playerStayingInBoard() {
        p.setMoveRight(true);
        p.setPlayerX(500);
        p.movePlayer();
        assertFalse(p.isMovingRight());
        
        p.setMoveLeft(true);
        p.setPlayerX(-1);
        p.movePlayer();
        assertFalse(p.isMovingLeft());
    }
    
}

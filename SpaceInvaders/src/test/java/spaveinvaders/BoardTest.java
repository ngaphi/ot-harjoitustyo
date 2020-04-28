package spaveinvaders;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import spaceinvaders.controller.Board;
import spaceinvaders.data.Sizes;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {
        board = new Board();
    }
//
//    @Test
//    public void playerIsMovingCorrectly() {
//        board.plamovePlayer();
//        assertEquals(235, board.player.getX());
//        assertEquals(380, board.player.getY());
//        
//        //player is moving right correctly
//        board.player.moveRight=true;
//        board.player.moveLeft=false;
//        board.movePlayer();
//        assertEquals(240, board.player.getX());
//        assertEquals(380, board.player.getY());
//        
//        //player is moving left correctly
//        board.player.moveLeft=true;
//        board.player.moveRight=false;
//        board.movePlayer();
//        assertEquals(235, board.player.getX());
//        assertEquals(380, board.player.getY());        
//    }
//    
//    @Test
//    public void invadersAreMovingCorrectly() {
//        //1. part
//        board.in[0].moveRight=true;
//        board.in[0].moveLeft=false;
//        
//        board.in[5].moveRight=true;
//        board.in[5].moveLeft=false;
//        
//        board.in[9].moveRight=true;
//        board.in[9].moveLeft=false;
//        
//        board.moveInvaders();
//       
//        assertEquals(13, board.in[0].getX());
//        assertEquals(10, board.in[0].getY());
//        
//        assertEquals(13, board.in[5].getX());
//        assertEquals(50, board.in[5].getY());
//        
//        assertEquals(173, board.in[9].getX());
//        assertEquals(50, board.in[5].getY());
//      
//        //2. part        
//        board.in[4].x=Sizes.BOARD_WIDTH-10;
//        
//        board.in[4].moveRight=false;
//        board.in[4].moveLeft=true;
//        
//        board.moveInvaders();
//       
//        assertEquals(487, board.in[4].getX());
//        assertEquals(15, board.in[4].getY());
//   
//    }
//
}

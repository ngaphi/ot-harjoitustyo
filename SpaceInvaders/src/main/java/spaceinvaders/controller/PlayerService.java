package spaceinvaders.controller;

import spaceinvaders.data.Player;
import spaceinvaders.data.Sizes;

/**
 * The class performs functionalities of player
 */
public class PlayerService {
    private final Player player;

    public PlayerService() {
        this.player = new Player(Sizes.BOARD_WIDTH / 2 - 15, Sizes.GROUND - 20, 10);
    }
    
    public int getPlayerX(){
        return player.x;
    }
    
    public int getPlayerY(){
        return player.y;
    }
    
    public int getPlayerS(){
        return player.s;
    }
    
    public void setMoveRight(boolean move) {
        player.moveRight = move;
    }
    
    public void setMoveLeft(boolean move) {
        player.moveLeft = move;
    }
    
    public void setPlayerX(int x) {
        player.x=x;
    }
    
    public boolean isMovingRight() {
        return player.moveRight;
    }
    
    public boolean isMovingLeft() {
        return player.moveLeft;
    }
    
    /*
     * This method enable the player to move left or right
     */
    public void movePlayer() {
        if (player.moveRight == true) {
            if (player.x >= Sizes.BOARD_WIDTH - Sizes.PLAYER_WIDTH) {
                player.moveRight = false;
                player.x = Sizes.BOARD_WIDTH - Sizes.PLAYER_WIDTH;
            } else {
                player.x += player.s;
            }

        } else if (player.moveLeft == true) {
            if (player.x <= 0) {
                player.moveLeft = false;
                player.x = 0;
            } else {
                player.x -= player.s;
            }
        }
    }
}

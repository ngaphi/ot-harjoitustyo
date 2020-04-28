
package spaceinvaders.controller;

import java.awt.Color;
import java.awt.Graphics;
import spaceinvaders.data.Player;
import spaceinvaders.data.Sizes;

class PlayerService {
    private Player player;

    public PlayerService() {
        this.player = new Player(Sizes.BOARD_WIDTH / 2 - 15, Sizes.GROUND - 20, 5);
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

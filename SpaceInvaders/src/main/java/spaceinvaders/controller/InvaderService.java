package spaceinvaders.controller;

import java.util.ArrayList;
import java.util.List;
import spaceinvaders.data.Invader;
import spaceinvaders.data.Sizes;

public class InvaderService {

    private final List<Invader> invaders;

    public InvaderService() {
        this.invaders = new ArrayList<>();

        for (int i = 0; i < Sizes.NUMBER_OF_INVADERS_TO_DESTROY; i++) {
            int row = i / 5;
            int column = i % 5;

            int inx = 10 + column * 40;
            int iny = 10 + row * 40;

            invaders.add(new Invader(inx, iny, 10));
        }
    }

    public List<Invader> getInvaders() {
        return this.invaders;
    }

    public void moveInvaders() {
        for (Invader in : invaders) {
            if (in.moveLeft == true) {
                in.x -= 3;
            }
            if (in.moveRight == true) {
                in.x += 3;
            }
        }

        Invader firstInvader = invaders.get(0);
        Invader lastInvader = invaders.get(invaders.size() - 1);

        if (lastInvader.x > Sizes.BOARD_WIDTH - Sizes.INVADER_WIDTH) {
            for (Invader in2 : invaders) {
                in2.moveLeft = true;
                in2.moveRight = false;
                in2.y += 10;
            }
        }
        if (firstInvader.x < 0) {
            for (Invader in2 : invaders) {
                in2.moveRight = true;
                in2.moveLeft = false;
                in2.y += 10;
            }
        }
    }

    boolean invadersWon() {

        for (Invader in : invaders) {
            if (in.visible && in.y > Sizes.GROUND - Sizes.INVADER_HEIGHT) {
                System.out.println(in.y);
                return true;
            }
        }
        return false;
    }

}

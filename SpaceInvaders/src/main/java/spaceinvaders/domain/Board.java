package spaceinvaders.domain;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;


import javax.swing.JPanel;

public class Board extends JPanel implements Runnable, MouseListener {

    private final Dimension d;
    boolean inGame = true;
    private Timer timer;
    private Thread animator;
    String message = "Click to Start";
    String name = "Space Invaders";
    public Player player;
    public Invader[] in = new Invader[10];

    public Board() {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        player = new Player(Sizes.BOARD_WIDTH / 2, Sizes.BOARD_HEIGHT - 120, 5);

        int inx = 10;
        int iny = 10;

        for (int i = 0; i < in.length; i++) {
            in[i] = new Invader(inx, iny, 10);
            inx += 40;
            if (i == 4) {
                inx = 10;
                iny += 40;
            }
        }

        if (animator == null || !inGame) {
            animator = new Thread(this);
            animator.start();
        }
        setDoubleBuffered(true);
    }

    @Override
    public void paint(Graphics g) {
        //set color for background
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, d.width, d.height);

        if (inGame) {
            //draw line fot ground
            g.setColor(Color.green);
            g.drawLine(0, Sizes.GROUND,
                    Sizes.BOARD_WIDTH, Sizes.GROUND);

            //represents player
            g.setColor(Color.red);
            g.fillRect(player.x, player.y, 20, 20);

            movePlayer();
            moveInvaders();

            //represents invaders
            g.setColor(Color.blue);
            for (Invader in1 : in) {
                g.fillRect(in1.x, in1.y, 30, 30);
            }

        } else {
            Font small = new Font("Helvetica", Font.BOLD, 20);
            FontMetrics metr = this.getFontMetrics(small);
            g.setColor(Color.white);
            g.setFont(small);
            g.drawString(message, 190, d.height - 200);

            //creates text "Space Invaders"
            Font big = new Font("Helvetica", Font.BOLD, 50);
            FontMetrics metrics = this.getFontMetrics(small);
            g.setColor(Color.blue);
            g.setFont(big);
            g.drawString(name, d.width - 430, d.height - 260);
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();
        int animationDelay = 20;
        long time
                = System.currentTimeMillis();
        while (true) {
            repaint();
            try {
                time += animationDelay;
                Thread.sleep(Math.max(0, time
                        - System.currentTimeMillis()));
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }

    public void movePlayer() {
        if (player.moveRight == true) {
            player.x += player.s;
        } else if (player.moveLeft == true) {
            player.x -= player.s;
        }
    }

    public void moveInvaders() {
        for (Invader in1 : in) {
            if (in1.moveLeft == true) {
                in1.x -= 3;
            }
            if (in1.moveRight == true) {
                in1.x += 3;
            }
        }

        for (Invader in1 : in) {
            if (in1.x > Sizes.BOARD_WIDTH) {
                for (Invader in2 : in) {
                    in2.moveLeft = true;
                    in2.moveRight = false;
                    in2.y += 5;
                }
            }
            if (in1.x < 0) {
                for (Invader in2 : in) {
                    in2.moveRight = true;
                    in2.moveLeft = false;
                    in2.y += 5;
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            player.moveRight = false;
            player.moveLeft = false;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                player.moveRight = true;
            }
            if (key == KeyEvent.VK_LEFT) {
                player.moveLeft = true;
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

}

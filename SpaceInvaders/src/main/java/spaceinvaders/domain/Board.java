package spaceinvaders.domain;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JPanel;

public final class Board extends JPanel implements MouseListener {

    private final Dimension d;
    private boolean inGame = true;
    private final Timer timer;
    private Thread animator;
    String message = "Click to Start";
    String name = "Space Invaders";
    public Player player;
    public Invader[] in = new Invader[Sizes.NUMBER_OF_INVADERS_TO_DESTROY];
    Bullet bullet;
    private int deaths = 0;

    public Board() {
        addKeyListener(new TAdapter());
        addMouseListener(this);
        setFocusable(true);
        d = new Dimension(Sizes.BOARD_WIDTH, Sizes.BOARD_HEIGHT);
        timer = new Timer(Sizes.DELAY, new GameCycle());
        timer.start();
        gameInit();

        setDoubleBuffered(true);
    }

    public void gameInit() {
        //represents player
        player = new Player(Sizes.BOARD_WIDTH / 2 - 15, Sizes.BOARD_HEIGHT - 120, 5);
        //represents shot
        bullet = new Bullet(player.x, player.y, 0, 0);

        //represents invaders
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

            //draw player
            paintPlayer(g);
            //draw invaders
            paintInvaders(g);
            //draw shot
            paintShot(g);
            //move player
            movePlayer();
            //move invaders
            moveInvaders();

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

    public void paintPlayer(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(player.x, player.y, Sizes.PLAYER_WIDTH, Sizes.PLAYER_HEIGHT);
    }

    public void paintInvaders(Graphics g) {
        g.setColor(Color.blue);
        for (Invader in1 : in) {
            if (in1.isVisible()) {
                g.fillRect(in1.x, in1.y, Sizes.INVADER_WIDTH, Sizes.PLAYER_HEIGHT);
            }
            if (in1.isDisappearing()) {
                in1.die();
            }
        }
    }

    public void paintShot(Graphics g) {
        if (bullet.shot) {
            g.setColor(Color.YELLOW);
            g.fillRect(bullet.x, bullet.y, 4, 8);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
            shoot();
            collision();
        }
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

    public void shoot() {
        if (bullet.shot) {
            bullet.y -= 10;
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
            if (in1.x > Sizes.BOARD_WIDTH - Sizes.INVADER_WIDTH) {
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

    public void collision() {
        if (deaths == Sizes.NUMBER_OF_INVADERS_TO_DESTROY) {
            inGame = false;
            timer.stop();
            message = "You won!";
        }
        if (bullet.isVisible()) {
            int bulletX = bullet.getX();
            int bulletY = bullet.getY();

            for (Invader invader : in) {
                int inX = invader.getX();
                int inY = invader.getY();

                if (invader.isVisible() && bullet.isVisible()) {
                    if (bulletX >= (inX)
                            && bulletX <= (inX + Sizes.INVADER_WIDTH)
                            && bulletY >= (inY)
                            && bulletY <= (inY + Sizes.INVADER_HEIGHT)) {
                        invader.setDisappear(true);
                        bullet = new Bullet(0, 0, 0, 0);
                        deaths++;
                        bullet.die();
                    }
                }
            }
        }
        List<Invader> invaders = Arrays.asList(in);
        Iterator<Invader> ins = invaders.iterator();

        while (ins.hasNext()) {
            Invader invader = ins.next();
            if (invader.isVisible()) {
                int y = invader.getY();

                if (y > Sizes.GROUND - Sizes.INVADER_HEIGHT) {
                    inGame = false;
                    message = "Invasion!";
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

            if (key == KeyEvent.VK_SPACE) {
                bullet.readyToFire = false;
                if (bullet.y <= -5) {
                    bullet = new Bullet(0, 0, 0, 0);
                    bullet.shot = false;
                    bullet.readyToFire = true;
                }
            }
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
            if (key == KeyEvent.VK_SPACE) {
                if (bullet == null) {
                    bullet.readyToFire = true;
                }
                if (!bullet.readyToFire) {
                    bullet = new Bullet(player.x + 13, player.y, 4, 8);
                    bullet.shot = true;
                }
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

package com.projects.personal;

import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    // 1 - Up, 2 - Down, 3 - Left, 4 - Right
    int direction = 2;

    int bulletX = 320;
    int bulletY = 320;

    int x = 256;
    int y = 256;

    void move(int direction) throws Exception {
        this.direction = direction;

        if (direction == 1) {
            y--;
        } else if (direction == 2) {
            y++;
        } else if (direction == 3) {
            x--;
        } else if (direction == 4) {
            x++;
        }
        Thread.sleep(13);
        repaint();
    }
    void runTheGame() throws Exception {
        while (y != BF_HEIGHT - 64){
            move(2);
        }
    }


    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.runTheGame();
    }

    public Main() {
        JFrame frame = new JFrame("2D Tanks");
        frame.setMinimumSize(new Dimension(BF_WIDTH + 22,BF_HEIGHT + 56));
        frame.getContentPane().add(this);
        frame.setLocation(0,0);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(x, y, 64, 64);

        g.setColor(Color.GREEN);
        if (direction == 1) {
            g.fillRect(x + 20, y - 10, 24, 44);
        } else if (direction == 2) {
            g.fillRect(x + 20, y + 30, 24, 44);
        } else if (direction == 3) {
            g.fillRect(x - 10, y + 20, 44, 24);
        } else if (direction == 4) {
            g.fillRect(x + 30, y + 20, 44, 24);
        }

        g.setColor(Color.YELLOW);
        g.fillRect(bulletX, bulletY, 14, 14);
    }



}

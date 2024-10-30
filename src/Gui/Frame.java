package Gui;

import javax.swing.*;
import java.awt.*;

public class Frame {
    private int HEIGHT = 800;
    private int WIDTH = 800;
    Thread thread;

    JFrame frame = new JFrame();

    public Frame(Draw draw) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Add the Draw instance to the JFrame
        frame.add(draw);
        draw.startGame(); // Start the game loop after adding the Draw panel
        //frame.pack(); // Adjust the frame size to fit the preferred size of the Draw panel
        frame.setVisible(true);
    }

    public int getHeight() {
        return HEIGHT;
    }
    public int getWidth() {
        return WIDTH;
    }
    public void setHeight(int height) {
        this.HEIGHT = height;
        frame.setSize(WIDTH, HEIGHT);
    }
    public void setWidth(int width) {
        this.WIDTH = width;
        frame.setSize(WIDTH, HEIGHT);
    }
}

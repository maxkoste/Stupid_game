package Gui;

import Entity.Enemy;
import Entity.Player;

import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel implements Runnable {

    private Color BACKGROUND_COLOR = Color.decode("#16C172");
    private Color SKY_COLOR = Color.decode("#2DE1FC");
    private Player player;
    private Enemy enemy;
    private Frame frame;
    KeyHandler keyHandler;
    boolean running = true;


    Thread gameThread;

    public Draw(){
        keyHandler = new KeyHandler(player);
        player = new Player(keyHandler);
        enemy = new Enemy(800, 800, player);
        //setPreferredSize(new Dimension(800, 800)); // Set preferred size for the JPanel
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        this.requestFocusInWindow(); // Ensure the panel can receive key events
        setPreferredSize(new Dimension(800, 800));
    }


    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        // Draw background color
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(BACKGROUND_COLOR);
        g2.fillRect(0, 0, getWidth(), getHeight());
        // Draw sky color in the upper half
        //g2.setColor(SKY_COLOR);
        //g2.fillRect(0, 0, getWidth(), getHeight() / 2);

        //Draw player
        player.draw(g);

        //draw enemy1
        enemy.draw(g);

    }

    public void update(){
        player.update();
        enemy.update(); //Något här gör så att jag inte kan göra repaint - Behöver debuggas
    }

    public void startGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        int targetFPS = 120; // Set your desired FPS
        long frameTime = 1000 / targetFPS; // Frame time in milliseconds

        while (running) {
            long startTime = System.currentTimeMillis(); // Start time of the frame

            update(); // Update the game state
            repaint(); // Render the game frame

            long endTime = System.currentTimeMillis(); // End time after rendering
            long deltaTime = endTime - startTime; // Time taken for this loop

            // If the loop was fast, sleep to maintain the target FPS
            if (deltaTime < frameTime) {
                try {
                    Thread.sleep(frameTime - deltaTime); // Sleep the remaining frame time
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

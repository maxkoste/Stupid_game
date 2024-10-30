package Gui;

import Entity.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    // Initialize the booleans directly
    public boolean upPressed = false;
    public boolean downPressed = false;
    public boolean leftPressed = false;
    public boolean rightPressed = false;
    Player player;

    public KeyHandler(Player player) {
        this.player = player; // Initialize with the Player instance
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // Set the appropriate boolean to true when a key is pressed
        if (code == KeyEvent.VK_W) {
            upPressed = true;
            System.out.println("UP PRESSED");
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
            System.out.println("DOWN PRESSED");
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = true;
            System.out.println("LEFT PRESSED");
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = true;
            System.out.println("RIGHT PRESSED");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        // Reset the appropriate boolean to false when a key is released
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}

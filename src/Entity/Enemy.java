package Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Enemy extends Entity {
    private int x;
    private int y;
    private final int HEIGHT = 16;
    private final int WIDTH = 16;
    private int speed = 1;
    private int health = 100;
    private int damage = 5;
    private Color color = Color.RED;
    private boolean dead;
    Player player;
    BufferedImage image;

    public Enemy(int panelWidth, int panelHeight, Player player) {
        //Generate random position within the panel's boundaries
        Random random = new Random();
        this.player = player;
        this.x = random.nextInt(panelWidth - WIDTH);
        this.y = random.nextInt(panelHeight - HEIGHT);
        getEnemyImage();
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //g2.setColor(color);
        //g2.fillRect(x, y, WIDTH, HEIGHT);
        BufferedImage image = down0;
        g2.drawImage(image, x, y, 64, 64, null);
    }

    public void update() {
        int playerX = player.getPositionX();
        int playerY = player.getPositionY();

        // Calculate direction vector
        int diffX = playerX - x;
        int diffY = playerY - y;

        // Calculate distance
        double distance = Math.sqrt(diffX * diffX + diffY * diffY);

        // Only move if the distance is greater than a minimum threshold to avoid flickering
        double minDistanceThreshold = 1.0;
        if (distance > minDistanceThreshold) {
            // Normalize the direction vector
            double moveX = (diffX / distance) * speed;
            double moveY = (diffY / distance) * speed;

            // Update position
            x = (int) (x + moveX);
            y = (int) (y + moveY);

            // Apply boundary constraints
            constrainToBounds();
        }
    }

    // New method to constrain the enemy within panel bounds
    private void constrainToBounds() {
        x = Math.max(0, Math.min(x, 800 - WIDTH));
        y = Math.max(0, Math.min(y, 800 - HEIGHT));
    }

    //Add enemy image here
    public void getEnemyImage(){
        try{
            up0 = ImageIO.read(new File("res/player_behind_0.png"));
            up1 = ImageIO.read(new File("res/player_behind_1.png"));
            down0 = ImageIO.read(new File("res/player_front_0.png"));
            down1 = ImageIO.read(new File("res/player_front_1.png"));
            left0 = ImageIO.read(new File("res/player_left_0.png"));
            left1 = ImageIO.read(new File("res/player_left_1.png"));
            right0 = ImageIO.read(new File("res/player_right_0.png"));
            right1 = ImageIO.read(new File("res/player_right_1.png"));

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }
    public int getWIDTH() {
        return WIDTH;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public boolean isDead() {
        return dead;
    }
}

package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Gui.KeyHandler;

import javax.imageio.ImageIO;

public class Player extends Entity {
    private final int PLAYERHEIGHT = 16; // Height of the player
    private final int PLAYERWIDTH = 16; // Width of the player
    private int positionX = 50; // Initial X position
    private int positionY = 50; // Initial Y position
    private int speed = 2; // Speed of movement
    private int health = 100;
    private int damage = 10;
    private boolean dead;
    private Color color = Color.WHITE; // Color of the player
    KeyHandler keyHandler;


    // Constructor
    public Player(KeyHandler keyHandler) {
        this.keyHandler = keyHandler; // Initialize KeyHandler
        getPlayerImage();
        direction = "down";
    }
    // Optional constructor for initial values
    public Player(int startX, int startY, Color color) {
        this.positionX = startX;
        this.positionY = startY;
        this.color = color;
        getPlayerImage();
        direction = "down";
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        g2.setColor(this.color);
//        g2.fillRect(positionX, positionY, PLAYERHEIGHT, PLAYERHEIGHT);

        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNumber == 1){
                image = up0;
                } else if(spriteNumber == 2){
                    image = up1;
                }
                break;
            case "down":
                if(spriteNumber == 1){
                    image = down0;
                }else if(spriteNumber == 2){
                    image = down1;
                }
                break;
            case "left":
                if(spriteNumber == 1){
                    image = left0;
                } else if(spriteNumber == 2){
                    image = left1;
                }
                break;
            case "right":
                if(spriteNumber == 1){
                    image = right0;
                } else if(spriteNumber == 2){
                    image = right1;
                }
                break;
            default:
                image = down0;
                break;
        }
        g2.drawImage(image, positionX, positionY, 64, 64, null);

    }

    public void getPlayerImage(){
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

    public void update(){

        if(keyHandler.upPressed
                || keyHandler.downPressed
                || keyHandler.leftPressed
                || keyHandler.rightPressed){

            if(keyHandler.upPressed){
                direction = "up";
                positionY = positionY - speed;
            }
            if(keyHandler.downPressed){
                direction = "down";
                positionY = positionY + speed;
            }
            if(keyHandler.leftPressed){
                direction = "left";
                positionX = positionX - speed;
            }
            if(keyHandler.rightPressed){
                direction = "right";
                positionX = positionX + speed;
            }

            if(spriteCounter > 30){
                if(spriteNumber == 1){
                    spriteNumber = 2;
                } else if(spriteNumber == 2){
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }
        }
        spriteCounter++;
            System.out.println(spriteCounter);
            System.out.println(spriteNumber);

    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPlayerHeight() {
        return PLAYERHEIGHT; // Return player height
    }

    public int getPlayerWidth() {
        return PLAYERWIDTH; // Return player width
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

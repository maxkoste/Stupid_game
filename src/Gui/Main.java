package Gui;


public class Main {
    public static void main(String[] args) {
        Draw draw = new Draw(); // Create Draw instance
        Frame frame = new Frame(draw); // Pass the Draw instance to Frame
        draw.startGame(); // Start the game loop
    }
}
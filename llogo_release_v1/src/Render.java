import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
import java.io.IOException;

import ast.*;

public class Render {
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 768;

    private boolean penDown;
    private int x;
    private int y;
    private int angle;
    private List<Instruction> instructions;

    public Render(List<Instruction> instructions) {
        this.penDown = true;
        this.x = WINDOW_WIDTH / 2;
        this.y = WINDOW_HEIGHT / 2;
        this.angle = 0;
        this.instructions = instructions; 
    }

    private class RenderWindow extends JPanel {

        private void renderInstructions(Graphics g) {
            throw new RuntimeException("renderInstructions (Render.java): fill me in");
        }

        private void drawTurtle(Graphics g) {
            Image turtleImage;
            try {
                turtleImage = ImageIO.read(new java.io.File("turtle.png"));
            } catch (IOException e) {
                turtleImage = null;
            }
            if (turtleImage != null) {
                Graphics2D g2 = (Graphics2D) g;
                AffineTransform old = g2.getTransform();
                g2.translate(x, y);
                g2.rotate(Math.toRadians(angle));
                g2.scale(0.75, 0.75);
                int w = turtleImage.getWidth(null);
                int h = turtleImage.getHeight(null);
                g2.drawImage(turtleImage, -w/2, -h/2, null);
                g2.setTransform(old);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            renderInstructions(g);
        }
    }

    public void run() {
        JFrame frame = new JFrame("Turtle Graphics");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.add(new RenderWindow());
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }

}

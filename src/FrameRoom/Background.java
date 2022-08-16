package FrameRoom;

import Core.Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Background extends JPanel {
    private final BufferedImage image;
    public Background(Frame frame){
        try {
            image = ImageIO.read(new File("images/background.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.add(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
}

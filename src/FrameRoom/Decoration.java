package FrameRoom;

import Core.Frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Decoration extends JPanel {
    private final int size = 50;
    public int angle = 0;
    private final DecorationThread decorationTHR;
    public Decoration(Frame frame){
        int width = 300, height = 50;
        setBackground(new Color(0,0,0,10));
        setBounds(frame.getWidth()/2 - width/2, 0, width, height);
        frame.add(this);
        decorationTHR = new DecorationThread(this);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        AffineTransform at = new AffineTransform(g2.getTransform());
        at.rotate(Math.toRadians(angle), getWidth()/2, getHeight()/2);
        g2.setTransform(at);
        g2.setFont(new Font("Times New Roman", Font.BOLD, size));
        g2.setColor(Color.WHITE);
        g2.drawString("JUST DO IT!", 0, size);
    }
    public void change_angle(boolean flag){
        if(flag)
            angle = 0;
        else
            angle = 180;
    }
}

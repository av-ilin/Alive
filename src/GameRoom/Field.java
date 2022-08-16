package GameRoom;

import Core.Frame;

import javax.swing.*;
import java.awt.*;

public class Field extends JPanel {
    public final int cell = 20;
    public Field(Frame frame){
        int width = 640, height = 480;
        setBounds(frame.getWidth()/2 - width/2, frame.getHeight()/2 - height/2, width, height);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.GRAY);
        for(int i = 0; i < getWidth(); i += cell)
            for(int j = 0; j < getHeight(); j += cell)
                g2.fill3DRect(i,j,cell,cell, true);
    }
}

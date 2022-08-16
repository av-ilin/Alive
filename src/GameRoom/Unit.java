package GameRoom;

import Core.Game;

import javax.swing.*;
import java.awt.*;

public class Unit extends JPanel {
    private final int cell;
    private int x, y;
    private final int up_border, down_border, left_border, right_border;
    public Unit(Game game){
        x = game.field.getLocation().x;
        y = game.field.getLocation().y;
        cell = game.field.cell;

        up_border = game.field.getLocation().y;
        down_border = game.field.getLocation().y + game.field.getHeight();
        left_border = game.field.getLocation().x;
        right_border = game.field.getLocation().x + game.field.getWidth();

        setBounds(x, y, cell, cell);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.GREEN);
        g2.fill3DRect(0, 0, cell, cell, true);
    }
    public void up(){
        if(y - cell >= up_border)
            y -= cell;
        setLocation(x, y);
    }
    public void down(){
        if(y + cell <= down_border - cell)
            y += cell;
        setLocation(x, y);
    }
    public void left(){
        if(x - cell >= left_border)
            x -= cell;
        setLocation(x, y);
    }
    public void right(){
        if(x + cell <= right_border - cell)
            x += cell;
        setLocation(x, y);
    }
}

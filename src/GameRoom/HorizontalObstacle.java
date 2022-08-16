package GameRoom;


import Core.Game;

import javax.swing.*;
import java.awt.*;

public class HorizontalObstacle extends JPanel {
    private final int cell;
    public final int size;
    private int x, y;
    private final int left_border, right_border;
    private final HObstacleThread threadHO;
    public HorizontalObstacle(Game game){
        cell = game.field.cell;
        size = (int) (5 * Math.random() + 1) * cell;
        x = game.field.getLocation().x + (int)((game.field.getWidth()/cell - size/cell) * Math.random()) * cell;
        y = game.field.getLocation().y + (int)((game.field.getHeight()/cell - 2) * Math.random()) * cell + cell;
        left_border = game.field.getLocation().x;
        right_border = game.field.getLocation().x + game.field.getWidth();
        threadHO = new HObstacleThread(this, game.speed);
        setBounds(x, y, size, cell);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.RED);
        for (int i = 0; i < getWidth(); i+=10)
            g2.fill3DRect(i, 0, cell, cell, true);
    }
    public void left(){
        if(x - cell >= left_border)
            x -= cell;
        else
            threadHO.reverse = !threadHO.reverse;
        setLocation(x, y);
    }
    public void right(){
        if(x + cell <= right_border - size)
            x += cell;
        else
            threadHO.reverse = !threadHO.reverse;
        setLocation(x, y);
    }
}

package GameRoom;

import Core.Game;

import javax.swing.*;
import java.awt.*;

public class VerticalObstacle extends JPanel {
    private final int cell;
    public final int size;
    private int x, y;
    private final int up_border, down_border;
    private final VObstacleThread threadVO;
    public VerticalObstacle(Game game){
        cell = game.field.cell;
        size = (int) (5 * Math.random() + 1) * cell;
        y = game.field.getLocation().y + (int)((game.field.getHeight()/cell - size/cell) * Math.random()) * cell;
        x = game.field.getLocation().x + (int)((game.field.getWidth()/cell - 2) * Math.random()) * cell + cell;
        up_border = game.field.getLocation().y;
        down_border = game.field.getLocation().y + game.field.getHeight();
        threadVO = new VObstacleThread(this, game.speed);
        setBounds(x, y, cell, size);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.RED);
        for (int i = 0; i < getHeight(); i+=10)
            g2.fill3DRect(0, i, cell, cell, true);
    }
    public void up(){
        if(y - cell >= up_border)
            y -= cell;
        else
            threadVO.reverse = !threadVO.reverse;
        setLocation(x, y);
    }
    public void down(){
        if(y + cell <= down_border - size)
            y += cell;
        else
            threadVO.reverse = !threadVO.reverse;
        setLocation(x, y);
    }
}

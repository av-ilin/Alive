package GameRoom;

import Core.Game;

import javax.swing.*;
import java.awt.*;

public class Exit extends JPanel {
    private final int cell;
    private final int x, y;
    private final int up_border, down_border, left_border, right_border;
    public Exit(Game game){
        cell = game.field.cell;
        x = game.field.getLocation().x + game.field.getWidth() - cell;
        y = game.field.getLocation().y + game.field.getHeight() - cell;;

        up_border = game.field.getLocation().y;
        down_border = game.field.getLocation().y + game.field.getHeight();
        left_border = game.field.getLocation().x;
        right_border = game.field.getLocation().x + game.field.getWidth();

        setBounds(x, y, cell, cell);
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        g2.setColor(Color.YELLOW);
        g2.fill3DRect(0, 0, cell, cell, true);
    }
}

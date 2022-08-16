package Core;

import GameRoom.Field;
import GameRoom.Unit;
import GameRoom.Exit;
import GameRoom.HorizontalObstacle;
import GameRoom.VerticalObstacle;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    private final Frame frame;
    public final int count_obstacle, speed;
    public final Field field;
    public final Unit unit;
    public final Exit exit;
    public final ArrayList<HorizontalObstacle> hObstacles;
    public final ArrayList<VerticalObstacle> vObstacles;
    private final GameThread gameTHR;
    Game(Frame frame){
        this.frame = frame;
        count_obstacle = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter number of obstacles:"));
        speed = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter speed of obstacles:"));

        field = new Field(frame);
        exit = new Exit(this);
        hObstacles = new ArrayList<>(count_obstacle);
        for (int i = 0; i < count_obstacle; i++) {
            hObstacles.add(i, new HorizontalObstacle(this));
            frame.add(hObstacles.get(i));
        }
        vObstacles = new ArrayList<>(count_obstacle);
        for (int i = 0; i < count_obstacle; i++) {
            vObstacles.add(i, new VerticalObstacle(this));
            frame.add(vObstacles.get(i));
        }
        unit = new Unit(this);
        frame.add(exit);
        frame.add(unit);
        frame.add(field);
        gameTHR = new GameThread(this);
    }
    public void end(boolean result){
        if(result)
            JOptionPane.showMessageDialog(frame,"You win!");
        else
            JOptionPane.showMessageDialog(frame,"You lose!");
        System.exit(0);
    }
}

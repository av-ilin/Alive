package Core;

import FrameRoom.Background;
import FrameRoom.Decoration;
import UI.Unit_Listener;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
    private final int width = 800, height = 600;
    private final RepaintThread repaintTHR;
    private final Background background;
    private final Decoration decoration;
    public final Game game;
    private Frame(){
        super("Alive");
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int scr_width = (int)(screen.getWidth());
        int scr_height = (int)(screen.getHeight());
        setBounds(scr_width/2 - width/2, scr_height/2 - height/2,width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        game = new Game(this);
        decoration = new Decoration(this);
        background = new Background(this);
        repaintTHR = new RepaintThread(this);

        addKeyListener(new Unit_Listener(this));
        setVisible(true);
    }
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}

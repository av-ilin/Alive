package UI;

import Core.Frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Unit_Listener implements KeyListener {
    private final Frame frame;
    public Unit_Listener(Frame frame){
        this.frame = frame;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key){
            case 87: frame.game.unit.up(); break;
            case 83: frame.game.unit.down(); break;
            case 65: frame.game.unit.left(); break;
            case 68: frame.game.unit.right(); break;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

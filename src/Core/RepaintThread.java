package Core;

public class RepaintThread extends Thread{
    private final Frame frame;
    RepaintThread(Frame frame){
        this.frame = frame;
        start();
    }
    @Override
    public void run() {
        while (true){
            frame.repaint();
            try {
                sleep(16);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

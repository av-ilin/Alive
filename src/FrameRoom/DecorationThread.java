package FrameRoom;

public class DecorationThread extends Thread{
    private boolean flag = true;
    private final Decoration decoration;
    DecorationThread(Decoration decoration){
        this.decoration = decoration;
        start();
    }
    @Override
    public void run() {
        while (true){
            decoration.change_angle(flag);
            flag = !flag;
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

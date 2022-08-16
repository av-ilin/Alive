package GameRoom;

public class HObstacleThread extends Thread{
    private final HorizontalObstacle hObstacle;
    private final int speed;
    public boolean reverse;
    HObstacleThread(HorizontalObstacle hObstacle, int speed){
        this.hObstacle = hObstacle;
        this.speed = speed;
        reverse = Math.random() > 0.5;
        start();
    }
    @Override
    public void run() {
        while (true){
            if(reverse)
                hObstacle.right();
            else
                hObstacle.left();
            try {
                sleep(1000/speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

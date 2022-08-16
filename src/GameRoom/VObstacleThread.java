package GameRoom;

public class VObstacleThread extends Thread{
    private final VerticalObstacle vObstacle;
    private final int speed;
    public boolean reverse;
    VObstacleThread(VerticalObstacle vObstacle, int speed){
        this.speed = speed;
        this.vObstacle = vObstacle;
        reverse = Math.random() > 0.5;
        start();
    }
    @Override
    public void run() {
        while (true){
            if(reverse)
                vObstacle.down();
            else
                vObstacle.up();
            try {
                sleep(1000/speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

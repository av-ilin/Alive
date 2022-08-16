package Core;

public class GameThread extends Thread{
    private final Game game;
    GameThread(Game game){
        this.game = game;
        start();
    }
    private void check(){
        int result = 0;
        int unit_x = game.unit.getX();
        int unit_y = game.unit.getY();
        for(int i = 0; i < game.count_obstacle; i++){
            int obstacle_x = game.vObstacles.get(i).getX();
            int obstacle_y = game.vObstacles.get(i).getY();
            int size = game.vObstacles.get(i).size;
            if(unit_x == obstacle_x)
                if(unit_y >= obstacle_y && unit_y <= obstacle_y + size){
                    result = -1;
                    break;
                }
            obstacle_x = game.hObstacles.get(i).getX();
            obstacle_y = game.hObstacles.get(i).getY();
            size = game.hObstacles.get(i).size;
            if(unit_y == obstacle_y)
                if(unit_x >= obstacle_x && unit_x <= obstacle_x + size){
                    result = -1;
                    break;
                }
        }

        int exit_x = game.exit.getX();
        int exit_y = game.exit.getY();
        if(unit_x == exit_x && unit_y == exit_y)
            result = 1;

        if(result == 1)
            game.end(true);
        else if(result == -1)
            game.end(false);
    }
    @Override
    public void run() {
        while (true){
            check();
            try {
                sleep(500/game.speed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

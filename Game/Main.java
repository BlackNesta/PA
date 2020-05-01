package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        while(true) {
            Game game = new Game(200, 10, 2, playerList);
            game.Simulate();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

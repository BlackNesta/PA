package Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player implements  Runnable{
    String name;
    int score;
    Board board;
    int order;
    Game game;
    int prog;
    List<Token> tokens;

    public Player(String name) {
        this.name = name;
    }

    public void Set(int order, Game game) {
        this.order = order;
        this.board = game.board;
        this.game = game;
        score = 0;
        tokens = new ArrayList<>();
    }


    @Override
    public void run() {
        synchronized (this) {
            while(!game.IsEnd()) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (game.turn != order) { // astept cat timp nu e timpul meu
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (game.IsEnd())
                        return;
                }
                if (!game.IsEnd()) {
                    this.tokens.add(board.Extract(1));
                    prog = game.ProgMax((ArrayList<Token>) this.tokens);
                    game.turn = (order + 1) % game.nrPlayers;
                } else
                    return;
            }
        }
    }
}

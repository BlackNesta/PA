package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Game {
    int n, k;
    int turn;
    int nrPlayers;
    Board board;

    List<Player> playerList;
    List<Thread> threadList;

    public Game(int n, int k, int nrPlayers, List<Player> playerList) {
        this.n = n;
        this.k = k;
        this.nrPlayers = nrPlayers;
        this.playerList = playerList;
        board = new Board(n);
        int turn = 0;
        for (Player player : playerList) {
            player.Set(turn, this);
            turn++;
        }
        turn %= nrPlayers;
        System.out.println("---------New Game---------");
    }

    public boolean IsEnd() {
        if (board.EmptyList())
            return true;
        // verific daca a castigat doar jucatorul din tura trecuta
        return playerList.get((turn + nrPlayers - 1) % nrPlayers).prog >= k;

    }
    synchronized public int ProgMax(List<Token> tokensPlayer) {
        int n = tokensPlayer.size();
        int[][] L = new int[n][n];
        Token[] set = tokensPlayer.toArray(new Token[0]);
        int k;
        int prog = 2;

        for (int i = 0; i < n; i++)
            L[i][n - 1] = 2;

        for (int j = n - 2; j >= 1; j--) {
            int i = j - 1;
            k = j + 1;
            while (i >= 0 && k <= n - 1) {
                if (set[i].getValue() + set[k].getValue() < 2 * set[j].getValue())
                    k++;
                else if (set[i].getValue() + set[k].getValue() > 2 * set[j].getValue()) {
                    L[i][j] = 2;
                    i--;

                }
                else {
                    L[i][j] = L[j][k] + 1;
                    if (prog < L[i][j]) {
                        prog = L[i][j];
                    }
                    i--;
                    k++;
                }
            }
        }
        return prog;
    }

    private void EndGame() {
        System.out.println("--------- End Game ---------");

        int maxProg = 0;
        Player winer = playerList.get(0);
        for (Player player : playerList) {
            if (maxProg < player.prog) {
                maxProg = player.prog;
                winer = player;
            }
        }

        if (maxProg >= k) {
            System.out.print("Winner: " + winer.name);
            winer.score += n;
        }
        if (maxProg < k) {
            System.out.println("No Winner");
            for (Player player : playerList) {
                player.score += ProgMax(player.tokens);
                System.out.println(player);
            }
        }
    }
    public void Simulate() throws InterruptedException {

        System.out.println("Simulating...");
        for (Player player : playerList)
            threadList.add(new Thread(player, player.name));
        for (Thread thread : threadList)
            thread.start();
        EndGame();
    }
}

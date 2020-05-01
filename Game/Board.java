package Game;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Token> tokens = new ArrayList<>();

    public Board( int n)
    {
        tokens.clear();
        for( int i = 1; i <=n; i++)
            tokens.add(new Token(i));
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(int n) {
        for(int i = 0; i < n; i++) {
            tokens.add(new Token(i));
        }
    }

    public boolean EmptyList() {
        return tokens.isEmpty();
    }

    public synchronized Token Extract(int index) {
        return tokens.remove(index);
    }
}

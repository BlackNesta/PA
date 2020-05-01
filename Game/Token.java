package Game;

import java.util.Objects;
import java.util.Random;

public class Token {
    int value;

    public Token(int m) {
        this.value = m;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int m) {
        this.value = m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return value == token.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int compareTo(Object o) {
        Token t = (Token) o;
        if (this.getValue() > t.getValue())
            return 1;
        if (this.getValue() == t.getValue())
            return 0;
        return -1;
    }
}

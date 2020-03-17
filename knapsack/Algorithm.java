package knapsack;

import java.util.List;

abstract public class Algorithm {
    List<Item> items;
    Knapsack knapsack;

    public Algorithm(List<Item> items, Knapsack knapsack) {
        this.items = items;
        this.knapsack = knapsack;
    }

    public void Solve() {

    }
}

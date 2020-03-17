package knapsack;

import java.util.ArrayList;
import java.util.List;

public class Digraph extends  Algorithm {
    List<Item>[] list;
    public Digraph(List<Item> items, Knapsack knapsack) {
        super(items, knapsack);
        list = new List[items.size()];
        for (int i = 0; i < items.size(); i++) {
            int j = 0;
            for (Item item : items) {
                if (i != j) {
                    list[i].add(item);
                }
                j++;
            }
        }
    }

    @Override
    public void Solve() {
        int n = list.length;
        int dp[][] = new int[n][];
    }
}

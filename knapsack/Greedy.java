package knapsack;

import java.util.List;

public class Greedy extends Algorithm {
    public Greedy(List<Item> items, Knapsack knapsack) {
        super(items, knapsack);
    }

    @Override
    public void Solve() {
        items.sort(Item::compareTo);
        int size = 0;
        for (Item item : items) {
            if (item.getWeight() + size <= knapsack.getCapacity()) {
                knapsack.addItem(item);
                size = (int) (size + item.getWeight());
            }
        }
    }
}

package knapsack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        Book book1 = new Book("Dragon Rising", 3, 5);
        Book book2 = new Book("A Blade in the Dark", 3, 5);
        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 5);
        Weapon weapon = new Weapon(WeaponType.sword, 5, 10);
        items.add(book1);
        items.add(book2);
        items.add(food1);
        items.add(food2);
        items.add(weapon);
        Knapsack knapsack1 = new Knapsack(10);
        Greedy greedy = new Greedy(items, knapsack1);
        greedy.Solve();
        System.out.println(knapsack1);
        Knapsack knapsack2 = new Knapsack(10);
        DynamicProgramming dynamicProgramming = new DynamicProgramming(items, knapsack2);
        dynamicProgramming.Solve();
        System.out.println(dynamicProgramming.maxValue);
    }
}

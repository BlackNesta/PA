package knapsack;

import java.util.List;

public class DynamicProgramming extends Algorithm {
    int[][] dp;
    int maxValue;
    public DynamicProgramming(List<Item> items, Knapsack knapsack) {
        super(items, knapsack);
    }

    @Override
    public void Solve() {
        dp = new int[2][(int)knapsack.getCapacity()];
        int line = 1;
        for (Item item : items) {
            line  = 1 - line;
            for (int j = 0; j <= knapsack.getCapacity(); j++) {
                dp[line][j] = dp[1 - line][j];
                if (j >= item.getWeight()) {
                    dp[line][j] = Math.max(dp[line][j], dp[1 - line][j - (int)item.getWeight()] + (int)item.getValue());
                }
            }
        }
        maxValue= dp[line][0];
        for (int i = 1; i <= knapsack.getCapacity(); i++) {
            maxValue = Math.max(maxValue, dp[line][i]);
        }
    }
}

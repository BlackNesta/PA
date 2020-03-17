package knapsack;

public interface Item {
    String getName();
    double getValue();
    double getWeight();
    default double profitFactor() {
        return getValue() / getWeight();
    }

    default public int compareTo(Item u) {
        if (u.getValue() == getValue()) return (int) (getWeight() - u.getWeight());
        return (int) (u.getValue() - getValue());
    }



}

package array.dp.knapsack01;

import java.util.HashMap;
import java.util.Map;

/**
 * for each item 'i'
 *   create a new set which INCLUDES item 'i' if the total weight does not exceed the capacity, and
 *      recursively process the remaining capacity and items
 *   create a new set WITHOUT item 'i', and recursively process the remaining items
 * return the set from the above two sets with higher profit
 */

class Knapsack {

    public int solveKnapsackRecursively(int[] profits, int[] weights, int capacity) {
        return this.knapsackRecursive(profits, weights, capacity, 0);
    }

    public int solveKnapsackMemoization(int[] profits, int[] weights, int capacity) {
        Map<String, Integer> memo = new HashMap<>();
        return knapsackMemo(profits, weights, capacity, 0, memo);

    }
    private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
        // base checks
        if (capacity <= 0 || currentIndex >= profits.length)
            return 0;

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackRecursive(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

        return Math.max(profit1, profit2);
    }

    private int knapsackMemo(int[] profits, int[] weights, int capacity, int currentIndex, Map<String, Integer> memo) {
        if (capacity <= 0 || currentIndex >= profits.length) return 0;

        String key = currentIndex + ":" + capacity;
        //System.out.println (key);
        if(memo.containsKey(key)) return memo.get(key);


        int profit1 = 0;
        // if we have enough capacity, include item
        if( weights[currentIndex] <= capacity )
            profit1 = profits[currentIndex] + knapsackMemo(profits, weights, capacity - weights[currentIndex], currentIndex + 1, memo);
        //exclude item
        int profit2 = knapsackMemo(profits, weights, capacity, currentIndex + 1, memo);

        int profit = Math.max(profit1, profit2);
        memo.put(key, profit);
        //System.out.println(profit + "");
        return profit;

    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsackRecursively(profits, weights, 7);
        System.out.println("Total knapsack profit recursively ---> " + maxProfit);
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 7);
        System.out.println("Total knapsack profit memoization ---> " + maxProfit);
        maxProfit = ks.solveKnapsackRecursively(profits, weights, 6);
        System.out.println("Total knapsack profit recursively ---> " + maxProfit);
        maxProfit = ks.solveKnapsackMemoization(profits, weights, 6);
        System.out.println("Total knapsack profit memoization---> " + maxProfit);
    }
}
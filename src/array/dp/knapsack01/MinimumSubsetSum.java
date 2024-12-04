package array.dp.knapsack01;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubsetSum {
    //private int min = Integer.MAX_VALUE;

    public int minSubsetSum(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int total = 0;
        for(int n : nums) total += n;
        //return minSubsetSumRecursive(nums, 0, 0, total);
        Map<String, Integer> memo = new HashMap<>();
        return minSubsetSumMemo(nums, 0, 0, total, memo);
    }

    private int minSubsetSumRecursive(int[] nums, int currentIdx, int currentSum, int total) {
        if(currentIdx == nums.length) {
            return Math.abs(currentSum - (total - currentSum));
        }

        int include = minSubsetSumRecursive(nums, currentIdx + 1, currentSum + nums[currentIdx], total);

        int exclude = minSubsetSumRecursive(nums, currentIdx + 1, currentSum, total);

        return Math.min(include, exclude);
    }

    private int minSubsetSumMemo(int[] nums, int currentIdx, int currentSum, int total, Map<String, Integer> memo) {
        String key = currentIdx + "-" + currentSum;
        if(memo.containsKey(key)) return memo.get(key);

        if(currentIdx == nums.length) {
            return Math.abs(currentSum - (total - currentSum));
        }

        int include = minSubsetSumMemo(nums, currentIdx + 1, currentSum + nums[currentIdx], total, memo);

        int exclude = minSubsetSumMemo(nums, currentIdx + 1, currentSum, total, memo);

        memo.put(key, Math.min(include, exclude));
        return memo.get(key);
    }

    public static void main(String[] args) {
        MinimumSubsetSum ps = new MinimumSubsetSum();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.minSubsetSum(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.minSubsetSum(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.minSubsetSum(num));
    }

}

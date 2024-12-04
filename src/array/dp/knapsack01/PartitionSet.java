package array.dp.knapsack01;


import java.util.HashMap;
import java.util.Map;

/**
 * for each number 'i'
 *   create a new set which INCLUDES number 'i' if it does not exceed 'S/2', and recursively
 *       process the remaining numbers
 *   create a new set WITHOUT number 'i', and recursively process the remaining items
 * return true if any of the above sets has a sum equal to 'S/2', otherwise return false
 */
public class PartitionSet {
    private boolean canPartition(int[] nums) {
        if(nums == null || nums.length < 2) return false;
        // if sum of elements of the array is odd, we can't partition
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;

        //return canPartitionRecursively(nums, 0, 0, sum/2);
        Map<String, Boolean> memo = new HashMap<>();
        return canPartitionMemo(nums, 0, 0, sum/2, memo);
    }

    private boolean canPartitionMemo(int[] nums, int current , int sum, int target, Map<String, Boolean> memo) {
        if(sum == target) return true;
        if(current == nums.length) return false;

        String key = current + String.valueOf(sum);
        if(memo.containsKey(key)) return memo.get(key);

        // if we can add current, add it and recurse
        if(sum + nums[current] <= target)
            if (canPartitionRecursively(nums, current + 1, sum  + nums[current], target)) {
                memo.put(key, true);
                return true;
            }
        // exclude current
        boolean result = canPartitionRecursively(nums, current + 1, sum, target);
        memo.put(key, result);
        return result;
    }

    private boolean canPartitionRecursively(int[] nums, int current, int sum, int target) {
        if(sum == target) return true;

        if (current == nums.length) return false;

        // if we can add current, add it and recurse
        if(sum + nums[current] <= target)
            if (canPartitionRecursively(nums, current + 1, sum  + nums[current], target)) return true;
        // exclude current
        return canPartitionRecursively(nums, current + 1, sum, target);
    }

    public static void main(String[] args) {
        PartitionSet ps = new PartitionSet();
        int[] num = {1, 2, 3, 4};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 1, 3, 4, 7};
        System.out.println(ps.canPartition(num));
        num = new int[]{2, 3, 4, 6};
        System.out.println(ps.canPartition(num));
    }
}

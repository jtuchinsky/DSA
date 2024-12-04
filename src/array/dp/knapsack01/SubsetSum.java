package array.dp.knapsack01;

/**
 * for each number 'i'
 *   create a new set which INCLUDES number 'i' if it does not exceed 'S', and recursively
 *      process the remaining numbers
 *   create a new set WITHOUT number 'i', and recursively process the remaining numbers
 * return true if any of the above two sets has a sum equal to 'S', otherwise return false
 */
public class SubsetSum {
    public boolean canPartition(int[] num, int sum) {
        return canPartitionRecursive(num, sum, 0);
    }

    private boolean canPartitionRecursive(int[] num, int sum, int current) {
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(current == num.length) return sum == 0;

        if (canPartitionRecursive(num, sum - num[current], current + 1)) return true;
        return canPartitionRecursive(num, sum, current + 1);
    }

    public static void main(String[] args) {
        SubsetSum ss = new SubsetSum();
        int[] num = { 1, 2, 3, 7 };
        System.out.println(ss.canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(ss.canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(ss.canPartition(num, 6));
    }
}

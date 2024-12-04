package array.dp.knapsack01;

import java.util.HashSet;
import java.util.Set;

public class CountOfSubsetSums {
    public int countSums(int[] arr, int S) {
        if(arr == null || arr.length == 0) return 0;

        return countSumsRecursive(arr, S, 0);
    }

    private int countSumsRecursive(int[] arr, int sum, int index) {
        if(sum == 0) return 1;
        if(index == arr.length) return 0;


        int include = 0;
        if (arr[index] <= sum) {
            include = countSumsRecursive(arr, sum - arr[index], index + 1);
        }
        int exclude = countSumsRecursive(arr, sum, index + 1);

        return include + exclude;
    }

    public static void main(String[] args) {
        CountOfSubsetSums ss = new CountOfSubsetSums();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSums(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSums(num, 9));
    }
}

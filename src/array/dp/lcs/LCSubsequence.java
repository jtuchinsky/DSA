package array.dp.lcs;

import java.util.Arrays;

class LCSubsequence {
    public int findLCSLength(String s1, String s2) {
        int[][] memo = new int[s1.length() + 1][s2.length() + 1];
        for(int[] row : memo){
            Arrays.fill(row, -1); // Initialize memo array with -1 to indicate uncomputed values
        }
        return lcsMemo(s1, s2, s1.length(), s2.length(), memo);
    }

    private int lcsMemo(String s1, String s2, int ind1, int ind2, int[][] memo) {
        if (ind1 == 0 || ind2 == 0) return 0; // Corrected base case
        if (memo[ind1][ind2] != -1) return memo[ind1][ind2]; // Check memo array for computed value

        if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
            memo[ind1][ind2] = 1 + lcsMemo(s1, s2, ind1 - 1, ind2 - 1, memo);
        } else {
            memo[ind1][ind2] = Math.max(
                    lcsMemo(s1, s2, ind1 - 1, ind2, memo),
                    lcsMemo(s1, s2, ind1, ind2 - 1, memo)
            );
        }
        return memo[ind1][ind2];
    }

    private int lcsTab(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store results of subproblems
        int dp[][] = new int[n + 1][m + 1];

        // Initialize the dp array with -1 to indicate that subproblems are not solved yet
        for (int rows[] : dp)
            Arrays.fill(rows, -1);

        // Initialize the first row and first column with zeros since LCS with an empty string is zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        LCSubsequence lcs = new LCSubsequence();
        System.out.println(lcs.findLCSLength("abdca", "cbda")); // Output should be 2 ("bd")
        System.out.println(lcs.findLCSLength("passport", "ppsspt")); // Output should be 4 ("pspt")
        System.out.println(lcs.lcsTab("abdca", "cbda")); // Output should be 2 ("bd")
        System.out.println(lcs.lcsTab("passport", "ppsspt")); // Output should be 4 ("pspt")
    }
}
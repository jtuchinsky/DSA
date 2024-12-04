package array.dp.lcs;

public class LCSubstring {
    public int findLCSLength(String s1, String s2) {
        // TODO: Write your code here
        if (s1 == null || s2 == null) return 0;

        int ans = 0;

        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LCSubstring lcs = new LCSubstring();
        System.out.println(lcs.findLCSLength("abdca", "cbda"));
        System.out.println(lcs.findLCSLength("passport", "ppsspt"));
    }
}

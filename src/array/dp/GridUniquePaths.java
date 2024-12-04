package array.dp;

import java.util.Arrays;

public class GridUniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];

        for (int[] row: mem)
            Arrays.fill(row, -1);

        //return rec(m, n, 1, 1);

        return dp_mem(m, n, 0, 0, mem);
    }

    private int rec(int m, int n, int r, int c){
        if(r == m && c == n) return 1;
        if(r > m || c > n) return 0;

        return rec(m, n, r, c+1) + rec(m, n, r + 1, c);
    }

    private int dp_mem(int m, int n, int r, int c, int[][] mem){
        if(r == m - 1 && c == n - 1) return 1;
        if(r >= m || c >= n) return 0;

        if(mem[r][c] != -1) return mem[r][c];
        else return mem[r][c] = dp_mem(m, n, r, c+1, mem) + dp_mem(m, n, r + 1, c, mem);
    }
}

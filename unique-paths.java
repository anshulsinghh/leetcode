class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        
        for (int row = 0; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                if (row == 0 && col == 0) continue;
                int up = 0, left = 0;
                if (row - 1 >= 0) up = dp[row - 1][col];
                if (col - 1 >= 0) left = dp[row][col - 1];
                dp[row][col] = up + left;
            }
            System.out.println(Arrays.toString(dp[row]));
        }

        return dp[n - 1][m - 1];
    }
}

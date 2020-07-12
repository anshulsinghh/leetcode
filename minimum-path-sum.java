class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == 0 && col == 0) continue;
                
                int above = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
                
                if (row - 1 >= 0) above = dp[row - 1][col] + grid[row][col];
                if (col - 1 >= 0) left = dp[row][col - 1] + grid[row][col];
                    
                dp[row][col] = Math.min(above, left);
            }
        }
        
        return dp[grid.length - 1][grid[0].length - 1];
    }
}

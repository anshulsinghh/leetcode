  class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
            
        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            
            for (int j = 1; j < (i/2+1); j++) {
                int bestApproach = Math.max(dp[i-j], i-j);
                max = Math.max(max, j * bestApproach);
            }
            
            dp[i] = max;
            
        }
        
        return dp[n];
    }
}

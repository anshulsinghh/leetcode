class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 1;
        
        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        
        return memo[n - 1] + memo[n - 2];        
    }
}

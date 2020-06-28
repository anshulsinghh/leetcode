class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        
        int[] memo = new int[nums.length];
        memo[0] = 1;
        
        int globalLIS = 1;
        for (int i = 1; i < memo.length; i++) {
            int LIS = 1;
            
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && memo[j] + 1 > LIS) {
                    LIS = memo[j] + 1;
                }
            }
            
            memo[i] = LIS;
            globalLIS = Math.max(LIS, globalLIS);
        }
        
        
        return globalLIS;
    }
}

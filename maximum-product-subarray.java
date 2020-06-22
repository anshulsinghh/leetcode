class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];
        
        if (nums.length == 0) return 0;
        if (nums.length == 1) return globalMax;
        
        for (int i = 1; i < nums.length; i++) {
            int temp = currMin;
            
            currMin = Math.min(Math.min(currMin*nums[i], nums[i]), currMax*nums[i]);
            currMax = Math.max(Math.max(temp*nums[i], nums[i]), currMax*nums[i]);
            
            if (currMax > globalMax) globalMax = currMax;
        }
        
        return globalMax;
    }
}

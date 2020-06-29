class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int loot = 0;
        
        int[] dpTable = new int[nums.length + 1];
        dpTable[1] = nums[0];
        
        for (int i = 2; i < dpTable.length; i++) {
            dpTable[i] = Math.max(nums[i-1] + dpTable[i-2], dpTable[i-1]);
        }
        
        return dpTable[dpTable.length - 1];
    }
}

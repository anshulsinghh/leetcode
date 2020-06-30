class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        
        int tmp = nums[0];
        nums[0] = 0;
        int didRob = houseRobber(nums);
        
        nums[0] = tmp;
        nums[nums.length - 1] = 0;
        int didntRob = houseRobber(nums);
        
        return Math.max(didRob, didntRob);
    }
    
    public int houseRobber(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dpTable = new int[nums.length + 1];
        dpTable[1] = nums[0];
        
        for (int i = 2; i < dpTable.length; i++) {
            dpTable[i] = Math.max(nums[i-1] + dpTable[i-2], dpTable[i-1]);
        }
        
        return dpTable[dpTable.length - 1];
    }
}

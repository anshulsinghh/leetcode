class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        arr[0] = 1;
        int accumulate = 1;
        for (int i = 1; i < nums.length; i++) {
            accumulate *= nums[i-1];
            arr[i] = accumulate;
        }
        
        accumulate = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            accumulate *= nums[i+1];
            arr[i] *= accumulate;
        }
        return arr;
    }
}

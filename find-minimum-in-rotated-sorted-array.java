class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        
        if (nums[0] < nums[nums.length-1]) {
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            
            if (nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            
            if (nums[mid] < nums[left]) {
                right = mid;
            }
            
            if (nums[mid] > nums[right]) {
                left = mid;
            }
        }   
        return -1;
    }
}

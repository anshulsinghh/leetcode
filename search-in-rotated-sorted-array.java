class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) {
            return 0;
        } else if (nums.length == 1) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        if (nums[left] <= nums[right]) {
            // Array is not rotated, so perform binary search
            while (right >= left) {
                int mid = left + (right - left) / 2;
                
                if (target == nums[mid]) return mid;
                
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        else {
            // Array is rotated
            while (right >= left) {
                int mid = left + (right - left) / 2;
                
                if (target == nums[mid]) return mid;
                
                boolean leftSideNormal = nums[left] <= nums[mid];
                boolean rightSideNormal = nums[mid] <= nums[right];
                
                if (rightSideNormal && nums[mid] <= target && target <= nums[right]) {
                    // Search right
                    left = mid + 1;
                }
                
                else if (rightSideNormal) {
                    // Search left
                    right = mid - 1;
                    continue;
                }
                
                if (leftSideNormal && target <= nums[mid] && nums[left] <= target) {
                    // Search left
                    right = mid - 1;
                }
                
                else if (leftSideNormal) {
                    // Search right
                    left = mid + 1;
                }
            }
        }
        
        return -1;
    }
}

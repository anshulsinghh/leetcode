class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr_num_ones = 0;
        
        for (int i : nums) {
            if (i == 1) {
                max = Math.max(max, ++curr_num_ones);
            } else {
                curr_num_ones = 0;
            }
        }
        
        return max;
    }
}

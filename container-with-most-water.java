class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for (int l = 0, r = height.length - 1; l < r;) {
            int currArea = Math.min(height[l], height[r]) * (r - l);
            maxArea = Math.max(maxArea, currArea);
            
            if (height[l] < height[r]) l++;
            else r--;
        }
        return maxArea;
    }
}

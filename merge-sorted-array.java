class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[nums1.length];
        
        int mm = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[mm] = nums1[i++];
            } else {
                merged[mm] = nums2[j++];
            }
            mm++;
        }
        
        while (i < m) {
            merged[mm++] = nums1[i];
            i++;
        }
        
        while (j < n) {
            merged[mm++] = nums2[j];
            j++;
        }
        
        for (i = 0; i < merged.length; i++) {
            nums1[i] = merged[i];
        }
    }
}

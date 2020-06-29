class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dpTable = new int[target + 1];
        for (int i = 1; i < dpTable.length; i++) {
            int combos = 0;
            for (int n : nums) {
                if (i - n == 0) combos++;
                else if (i - n > 0) combos += dpTable[i - n];
            }
            dpTable[i] = combos;
        }
        
        return dpTable[dpTable.length - 1];
    }
}

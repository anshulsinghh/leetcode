class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] changeTable = new int[amount + 1];

        for (int i = 1; i < changeTable.length; i++) {
            int fewestCoins = -1;
            for (int c : coins) {
                int searchIndex = i - c;
                if (searchIndex >= 0 && changeTable[searchIndex] != -1 && (fewestCoins == -1 || changeTable[searchIndex] + 1 < fewestCoins)) {
                    fewestCoins = changeTable[searchIndex] + 1;
                }
            }
            
            changeTable[i] = fewestCoins;
        }
        
        
        return changeTable[amount];
    }
}

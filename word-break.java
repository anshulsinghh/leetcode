class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;
        
        boolean[] dpTable = new boolean[s.length() + 1];
        for (int i = 1; i < dpTable.length; i++) {
            String segment = s.substring(0, i);
            
            for (String word : wordDict) {
                if (word.equals(segment)) {
                    dpTable[i] = true;
                } else if (segment.endsWith(word)) {
                    dpTable[i] = dpTable[segment.length() - word.length()];
                    if (dpTable[i]) break;
                }
            }
        }
        
        return dpTable[dpTable.length - 1];
    }
}

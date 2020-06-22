class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int globalLen = 1;
        
        int firstIdx = 0;
        HashSet<Character> db = new HashSet<Character>();

        for (int i = 0; i < s.length(); i++) {
            while(db.contains(s.charAt(i))) {
                    db.remove(s.charAt(firstIdx));
                    firstIdx++;
            }
            db.add(s.charAt(i));
            int len = i - firstIdx + 1;
            if (len > globalLen) globalLen = len;
        }
        
        return globalLen;
        
    }
}

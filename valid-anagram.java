class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i))) {
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }
        
        for (int i = 0; i < t.length(); i++) {
            if (!sMap.containsKey(t.charAt(i))) return false;
            
            sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
        }
        
        for (int i : sMap.values()) { if(i != 0) return false; }
        
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (sMap.containsKey(c)) sMap.replace(c, sMap.get(c)+1);
            else sMap.put(c, 1);
        }
        
        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c)) sMap.replace(c, sMap.get(c)-1);
            else return false;
            
            if (sMap.get(c) == 0) sMap.remove(c);
        }
        
        return sMap.isEmpty();
    }
}

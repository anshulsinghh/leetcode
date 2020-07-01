class Solution {
    public int numDecodings(String s) {
        if (s.length() < 1) return 0;
        
        int[] dpTable = new int[s.length() + 1];
        for (int i = 1; i < dpTable.length; i++) {
            String substr = s.substring(0, i);
            
            int count = 0;
            for (int j = 1; j <= 26; j++) {
                String alphabetString = j + "";
                
                if (alphabetString.equals(substr)) {
                    count++;
                }
                else if (substr.endsWith(alphabetString)) {
                    count += dpTable[substr.length() - alphabetString.length()];
                }
            }
            
            dpTable[i] = count;
        }

        return dpTable[dpTable.length - 1];
    }
}

// This is a question from MongoDB
// Replace all occurrences of s2 in s1 with s3

public class MyClass {
    public static void main(String args[]) {
      System.out.println(replace("hahafarty", "ha", "farty"));
    }
    
    public static String replace(String s1, String s2, String s3) {
        // Replace all occurrences of s2 in s1 with s3
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < s1.length(); i++) {
            String check = "";
            
            if (i+s2.length() <= s1.length()) {
                check = s1.substring(i, i+s2.length());
            }
            
            if (check.equals(s2)) {
                res.append(s3);
                i+=s2.length()-1;
            } else {
                res.append(s1.charAt(i));
            }
        }
        
        return res.toString();
    }
}

class Solution {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        
        HashSet<String> sentEmails = new HashSet<String>();
        
        for (String email : emails) {
            String[] components = email.split("@"); //O(M)
            
            if (components.length != 2) continue;
            
            String localName = components[0];
            String domainName = components[1];
            
            if (localName.indexOf("+") != -1) { //O(M)
                localName = localName.substring(0, localName.indexOf("+")); //O(M)
            }
            
            localName = localName.replace(".", ""); //O(M)
            
            sentEmails.add(localName + "@" + domainName); //O(M)            
        }
        
        return sentEmails.size();
    }
}

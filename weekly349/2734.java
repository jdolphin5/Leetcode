class Solution {
    public String smallestString(String s) {
        StringBuilder myString = new StringBuilder();
        
        boolean changed = false;
        
        for (int i = 0; i < s.length(); i++) {
            
            if (s.charAt(i) != 'a') {
                char c = s.charAt(i);
                c--;
                myString.append(c);
                changed = true;
            }
            else {
                if (changed) {
                    myString.append(s.substring(i, s.length()));
                    break;
                } else {
                    if (i == s.length()-1) {
                        myString.append('z');
                    }
                    else {
                        myString.append('a');
                    }

                }
            }
        }
        
        return new String(myString);
    }
}
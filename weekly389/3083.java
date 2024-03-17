class Solution {
    public boolean isSubstringPresent(String s) {
        List<String> sSubstrings = new ArrayList<>();
        
        for (int i = 0; i < s.length()-1; i++) {
            sSubstrings.add(s.substring(i, i+2));
        }
        
        StringBuilder sReverseSB = new StringBuilder();
        sReverseSB.append(s);
        sReverseSB.reverse();
        String rev = sReverseSB.toString();
        
        for (int i = 0; i < rev.length()-1; i++) {
            for (String x : sSubstrings) {
                if (rev.substring(i, i+2).equals(x)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
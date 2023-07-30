class Solution {
    
    String res = "";
    int len = Integer.MAX_VALUE;
    
    private void combine2(String a, String b, Set<String> mySet) {
        int i = 0;
        int j = 0;
        if (a.contains(b)) {
            String found = a;
            if (found.length() < len) {
                len = found.length();
                res = found;
            }
            else if (found.length() == len) {
                if (found.compareTo(res) < 0) {
                    res = found;
                }
            }
        }
        
        StringBuilder check = new StringBuilder(a);
        while (j < b.length() && i <= j) {
            check.append(b.charAt(j));
            if (check.indexOf(b) != -1) {
                //System.out.println(b.substring(i, j+1));
                String found = new String(check);
                if (found.length() < len) {
                    len = found.length();
                    res = found;
                }
                else if (found.length() == len) {
                    if (found.compareTo(res) < 0) {
                        res = found;
                    }
                }
                
                
                i++;
                j = i;
                check = new StringBuilder(a);
                continue;
            }
            
            j++;
            if (j == b.length()) {
                i++;
                j = i;
                check = new StringBuilder(a);
            }
        }
    }
    
    private void combine(String a, String b, Set<String> mySet) {
        int i = 0;
        int j = 0;
        if (a.contains(b)) mySet.add(a);
        
        StringBuilder check = new StringBuilder(a);
        while (j < b.length() && i <= j) {
            check.append(b.charAt(j));
            if (check.indexOf(b) != -1) {
                //System.out.println(b.substring(i, j+1));
                mySet.add(new String(check));
            }
            
            j++;
            if (j == b.length()) {
                i++;
                j = i;
                check = new StringBuilder(a);
            }
        }
    }
    
    public String minimumString(String a, String b, String c) {
        
        int len = Integer.MAX_VALUE;
        String best = "";
        
        Set<String> mySet = new HashSet<>();
        
        combine(a, b, mySet);
        combine(b, a, mySet);
        
        Set<String> ret = new HashSet<>();
        
        
        for (String ele : mySet) {
            combine2(ele, c, ret);
            combine2(c, ele, ret);
        }
        
        Set<String> mySet2 = new HashSet<>();
        
        combine(a, c, mySet2);
        combine(c, a, mySet2);
        
        Set<String> ret2 = new HashSet<>();
        
        
        for (String ele : mySet2) {
            combine2(ele, b, ret2);
            combine2(b, ele, ret2);
        }
        
        
        return res;
        
    }
}
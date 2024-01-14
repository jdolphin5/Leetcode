class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> aIndices = new ArrayList<>();
        List<Integer> bIndices = new ArrayList<>();
        
        int ax = 0;
        int bx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == a.charAt(ax)) {
                ax++;
            }
            else {
                ax = 0;
                if (s.charAt(i) == a.charAt(ax)) ax++;
            }
            if (s.charAt(i) == b.charAt(bx)) {
                bx++;
            }
            else {
                bx = 0;
                if (s.charAt(i) == b.charAt(bx)) bx++;
            }
            
            if (ax == a.length()) {
                aIndices.add(i+1-ax);
                ax = 0;
            }
            if (bx == b.length()) {
                bIndices.add(i+1-bx);
                bx = 0;
            }
        }
        
        List<Integer> ret = new ArrayList<>();
        
        for (int i = 0; i < aIndices.size(); i++) {
            int aIndex = aIndices.get(i);
            
            for (int j = 0; j < bIndices.size(); j++) {
                int bIndex = bIndices.get(j);
                
                if (Math.abs(aIndex - bIndex) <= k) {
                    ret.add(aIndex);
                    break;
                }
            }
        }
        
        //System.out.println(aIndices.toString());
        //System.out.println(bIndices.toString());

        return ret;
    }
}
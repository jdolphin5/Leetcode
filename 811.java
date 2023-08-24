class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> myMap = new HashMap<>();
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < cpdomains.length; i++) {
            int x = 0;
            String y = cpdomains[i];
            String xString;
            int xIndex = 0;

            xIndex = y.indexOf(' ');
            xString = y.substring(0, xIndex);
            x = Integer.parseInt(xString);
            y = y.substring(xIndex+1, y.length());
            myMap.put(y, myMap.getOrDefault(y, 0)+x);

            while (y.indexOf('.') != -1) {
                y = y.substring(y.indexOf('.')+1, y.length());
                myMap.put(y, myMap.getOrDefault(y, 0)+x);                
            }
        }

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            String s = entry.getKey();
            int x = (int)entry.getValue();
            String a = x + " " + s;
            ret.add(a);
        }

        return ret;
    }
}
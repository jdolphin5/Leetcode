class Solution {
    private boolean tryBreak(String a, String b) {
        TreeMap<Character, Integer> myTreeMap = new TreeMap<>();

        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            
            myTreeMap.put(c, myTreeMap.getOrDefault(c, 0) + 1);
        }
        
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            
            Character key = myTreeMap.ceilingKey(c);

            if (key == null) {
                return false;
            }
            else {
                myTreeMap.put(key, myTreeMap.get(key) - 1);
                if (myTreeMap.get(key) == 0) {
                    myTreeMap.remove(key);
                }
            }
        }

        return true;
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        return tryBreak(s1, s2) || tryBreak(s2, s1);
    }
}
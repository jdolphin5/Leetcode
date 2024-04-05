class Solution {
    public String makeGood(String s) {

        if (s.length() == 1) return s;

        int i = 0;
        int j = 1;

        Set<Integer> removedSet = new HashSet<>();

        while (j < s.length()) {
            while (i < 0 || removedSet.contains(i))
                i++;

            if (i == s.length() - 1)
                break;

            if (i == j) j++;

            //System.out.println("i: " + i + " j: " + j);

            char c = s.charAt(i);
            char d = s.charAt(j);

            if (Character.toLowerCase(c) == Character.toLowerCase(d) && c != d) {
                removedSet.add(i);
                removedSet.add(j);
                while (removedSet.contains(i))
                    i--;
                j++;
            }
            else {
                i++;
                j++;
            }
        }

        StringBuilder ret = new StringBuilder();

        for (int x = 0; x < s.length(); x++) {
            if (!removedSet.contains(x)) {
                ret.append(s.charAt(x));
            }
        }
        
        return ret.toString();
    }
}
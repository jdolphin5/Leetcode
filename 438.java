class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        char pArr[] = p.toCharArray();
        char sArr[] = s.toCharArray();
        if (pArr.length > sArr.length) return result;

        int[] pArrCount = new int[26];
        for (char c : pArr) {
            pArrCount[c-'a']++;
        }

        for (int i = 0; i < sArr.length-pArr.length+1; i++) {
            char[] checkArr = new char[pArr.length];
            for (int m = 0; m < pArr.length; m++) {
                checkArr[m] = sArr[i+m];
            }

            int[] checkArrCounts = new int[26];
            for (char c : checkArr) {
                checkArrCounts[c-'a']++;
            }

            if (Arrays.equals(pArrCount, checkArrCounts)) {
                result.add(i);
            }
        }
        return result;
    }
}
class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] sArr = s.toCharArray();
        boolean exists = true;
        int res = 0;
        while (exists) {
            exists = false;
            //System.out.println(Arrays.toString(sArr));
            for (int i = 0; i < s.length()-1; i++) {
                if (sArr[i] == '0' && sArr[i+1] == '1') {
                    exists = true;
                    sArr[i] = '1';
                    sArr[i+1] = '0';
                    i++;
                }
            }
            if (exists) res++;
        }

        return res;
    }
}
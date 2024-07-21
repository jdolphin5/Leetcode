class Solution {
    public int minChanges(int n, int k) {
        String nString = Integer.toBinaryString(n);
        String kString = Integer.toBinaryString(k);

        if (k > n) return -1;

        System.out.println(nString);
        System.out.println(kString);

        if (kString.length() > nString.length()) {
            return -1;
        }

        while (kString.length() < nString.length()) {
            kString = "0" + kString;
        }

        int ret = 0;

        for (int i = 0; i < nString.length(); i++) {
            char nChar = nString.charAt(i);
            char kChar = kString.charAt(i);

            if (kChar == '1' && nChar == '0') {
                return -1;
            }

            else if (kChar != nChar) {
                ret++;
            }
        }

        return ret;
    }
}
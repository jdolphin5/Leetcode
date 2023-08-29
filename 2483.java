class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        
        int[] yArray = new int[n+1];
        int[] nArray = new int[n+1];

        int yTotal = 0;
        int nTotal = 0; // not used

        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);

            if (c == 'Y') {
                yTotal++;
            }
            else if (c == 'N') {
                nTotal++;
            }
        }

        int yCount = 0;
        int nCount = 0;

        for (int i = 0; i < n; i++) {
            char c = customers.charAt(i);

            yArray[i] = yTotal - yCount;
            nArray[i] = nCount;

            if (c == 'Y') {
                yCount++;
            }
            else if (c == 'N') {
                nCount++;
            }
        }

        yArray[n] = yTotal - yCount;
        nArray[n] = nCount;

        int min = Integer.MAX_VALUE;
        int ret = -1;

        for (int i = 0; i < n+1; i++) {
            int val = yArray[i] + nArray[i];
            if (val < min) {
                min = val;
                ret = i;
            }
        }

        return ret;
    }
}
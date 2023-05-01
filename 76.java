class Solution {
    public String minWindow(String s, String t) {
        int[] checkArr = new int[128];
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        for (char cur : tArray) {
            checkArr[cur]++;
        }

        int i = 0;
        int j = 0;

        int minLength = Integer.MAX_VALUE;
        String result = "";
        int counter = 0;

        while (j < sArray.length) {
            char cur = sArray[j];
            if (--checkArr[cur] >= 0) {
                counter++;
            }
            while (counter == tArray.length) {
                int curWindow = j - i + 1;
                if (curWindow < minLength) {
                    minLength = curWindow;
                    result = s.substring(i, j + 1);
                }
                char leftChar = sArray[i];
                if (++checkArr[leftChar] > 0) {
                    counter--;
                }
                i++;
            }
            j++;
        }
        
        return result;

    }
}
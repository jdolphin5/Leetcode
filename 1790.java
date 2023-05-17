class Solution {

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        if (Arrays.equals(s1Arr, s2Arr)) return true;

        //if every swap checked in one string, don't need to check other one
        for (int i = 0; i < s1Arr.length; i++) {
            for (int j = i+1; j < s1Arr.length; j++) {
                char temp = s1Arr[i];
                s1Arr[i] = s1Arr[j];
                s1Arr[j] = temp;
                if (Arrays.equals(s1Arr, s2Arr)) return true;
                s1Arr[j] = s1Arr[i];
                s1Arr[i] = temp;
            }
        }
        return false;
    }
}
class Solution {

    private void swap (char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        if (Arrays.equals(s1Arr, s2Arr)) return true;

        for (int i = 0; i < s1Arr.length; i++) {
            for (int j = i+1; j < s1Arr.length; j++) {
                swap(s1Arr, i, j);
                if (Arrays.equals(s1Arr, s2Arr)) return true;
                swap(s1Arr, i, j);
            }
        }

        for (int i = 0; i < s2Arr.length; i++) {
            for (int j = i+1; j < s2Arr.length; j++) {
                swap(s2Arr, i, j);
                if (Arrays.equals(s1Arr, s2Arr)) return true;
                swap(s2Arr, i, j);
            }
        }
        return false;
    }
}
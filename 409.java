class Solution {
    public int longestPalindrome(String s) {
        int[] bucket = new int[100];

        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'A']++;
        }

        boolean oddExists = false;
        int evenCt = 0;

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] % 2 == 1) {
                oddExists = true;
            }

            //minus one from the ct if the ct is odd
            evenCt += (bucket[i] / 2) * 2;
        }

        return oddExists ? evenCt + 1 : evenCt;
    }
}
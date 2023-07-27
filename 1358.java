class Solution {

    private boolean atLeastThree(int[] charCount) {
        return (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0);
    }

    public int numberOfSubstrings(String s) {
        int[] charCount = new int[3];
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < s.length()) {
            charCount[s.charAt(j)-'a']++;
            while (atLeastThree(charCount)) {
                //System.out.println(s.substring(i, j));
                count += s.length()-j;
                charCount[s.charAt(i)-'a']--;
                i++;
            }
            j++;

        }

        return count;
    }
}
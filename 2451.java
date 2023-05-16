class Solution {
    public String oddString(String[] words) {
        int[][] difference = new int[words.length][words.length];
        int[] diffCount = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            int size = words[i].length();
            for (int j = 0; j < size-1; j++) {
                difference[i][j] = words[i].charAt(j+1) - words[i].charAt(j);
            }
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (Arrays.equals(difference[i], difference[j])) {
                    diffCount[i]++;
                    diffCount[j]++;
                }
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            if (diffCount[i] == 0) {
                return words[i];
            }
        }
        return words[0];
    }
}
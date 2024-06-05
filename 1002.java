class Solution {
    public List<String> commonChars(String[] words) {
        int wordCt = words.length;
        int[][] wordBucket = new int[wordCt][26];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordBucket[i][words[i].charAt(j)-'a']++;
            }
        }

        List<String> ret = new ArrayList<>();

        for (int i = 0; i < wordBucket[0].length; i++) {
            int ct = Integer.MAX_VALUE;

            for (int j = 0; j < wordCt; j++) {
                ct = Math.min(ct, wordBucket[j][i]); 
            }

            while (ct-- > 0) {
                ret.add(String.valueOf((char)('a'+i)));
            }
        }
        
        return ret;
    }
}
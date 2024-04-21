class Solution {
    public int numberOfSpecialChars(String word) {
        int[] wordBucket = new int[100];
        
        //System.out.println('a'-'A');
        
        for (int i = 0; i < word.length(); i++) {
            wordBucket[word.charAt(i)-'A']++;
        }
        
        int ret = 0;
        
        //System.out.println(Arrays.toString(wordBucket));
        
        for (int i = 0; i < wordBucket.length-32; i++) {
            ret += Math.min(1, Math.min(wordBucket[i], wordBucket[i+32]));
        }
        
        return ret;
    }
}
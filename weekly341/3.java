class Solution {
    public int addMinimum(String word) {
        
        if (word.length() == 1) return 2;
        
        int count = 0;
        
        //if you can find substring abc then remove it
        //if you can find substring ab or bc then remove it and count++
        //else each letter is count+=2
        
        
        char[] wordArr1 = word.toCharArray();
        char[] wordArr = new char[wordArr1.length+2];
        wordArr[wordArr.length-1] = '0';
        wordArr[wordArr.length-2] = '0';
        for (int i = 0; i < wordArr1.length; i++) {
            wordArr[i] = wordArr1[i];
        }
        for (int i = 0; i < wordArr.length-2; i++) {
            if (wordArr[i] == 'a') {
                if (wordArr[i+1] == 'b') {
                    if(wordArr[i+2] == 'c') {
                        wordArr[i] = '0';
                        wordArr[i+1] = '0';
                        wordArr[i+2] = '0';
                        count--;
                    }
                    wordArr[i] = '0';
                    wordArr[i+1] = '0';
                    count++;
                }
                else if(wordArr[i+1] == 'c') {
                    wordArr[i] = '0';
                    wordArr[i+1] = '0';
                    count++;
                }
                else {
                    wordArr[i] = '0';
                    count += 2;
                }
            }
            else if (wordArr[i] == 'b') {
                if (wordArr[i+1] == 'c') {
                    wordArr[i] = '0';
                    wordArr[i+1] = '0';
                    count++;
                }
                else {
                    wordArr[i] = '0';
                    count += 2;
                }
            }
            else if (wordArr[i] == 'c') {
                wordArr[i] = '0';
                count += 2;
            }
        }
        
        
        return count;
    }
}
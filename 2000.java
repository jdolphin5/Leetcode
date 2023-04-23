class Solution {
    public String reversePrefix(String word, char ch) {

        int chIndex = -1;
        char[] wordArr = word.toCharArray();

        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i] == ch) {
                chIndex = i;
                break;
            }
        }
        if (chIndex == -1) return word;

        System.out.println(chIndex);

        for (int i = 0; i < chIndex/2+1; i++) {
            char temp;
            temp = wordArr[i];
            wordArr[i] = wordArr[chIndex-i];
            wordArr[chIndex-i] = temp; 
        }
        return String.valueOf(wordArr);

    }
}
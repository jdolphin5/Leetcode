class StreamChecker {

    char[][] wordsArr;
    int[] wordLen;
    CopyOnWriteArrayList<Integer>[] myListArr;

    private boolean checkChar(char letter, char letter2) {
        if (letter == letter2)
            return true;

        return false;
    }

    public StreamChecker(String[] words) {
        wordsArr = new char[words.length][202];
        myListArr = new CopyOnWriteArrayList[words.length];
        wordLen = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            char[] wordArr = words[i].toCharArray();
        
            for (int j = 0; j < wordArr.length; j++) {
                wordsArr[i][j] = wordArr[j];
            }

            myListArr[i] = new CopyOnWriteArrayList<>();
            wordLen[i] = words[i].length();
        }
    }
    
    public boolean query(char letter) {
        boolean ret = false;

        for (int i = 0; i < wordsArr.length; i++) {
            for (int index : myListArr[i]) {
                if (wordsArr[i][index] == letter) {
                    myListArr[i].add(index+1);
                    myListArr[i].remove(new Integer(index));
                    if (index+1 == wordLen[i]) {
                        myListArr[i].remove(new Integer(index+1));
                        ret = true;
                    }
                }
                else {
                    myListArr[i].remove(new Integer(index));
                }
            }

            if (letter == wordsArr[i][0]) {
                myListArr[i].add(1);
                if (1 == wordLen[i]) {
                    ret = true;
                }
            }
        }

        return ret;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
class Solution {
    public int characterReplacement(String s, int k) {
        char[] sArray = s.toCharArray();
        int maxCount = 0;
        int mostFreq = 0;
        int leftPtr = 0;
        int rightPtr = 0;

        Map<Character, Integer> myMap = new HashMap<Character, Integer>();

        while (rightPtr < sArray.length) {
            //add 1 to char counter and expand the window
            myMap.put(sArray[rightPtr], myMap.getOrDefault(sArray[rightPtr], 0) + 1);
            mostFreq = Math.max(myMap.get(sArray[rightPtr]), mostFreq);

            //shrink window if:
            if ((rightPtr - leftPtr + 1) - mostFreq > k) {
                //decrease count of char at left pointer
                myMap.put(sArray[leftPtr], myMap.get(sArray[leftPtr]) - 1);
                leftPtr++;
            }

            maxCount = Math.max(maxCount, rightPtr - leftPtr + 1);
            rightPtr++;

        }
        return maxCount;
    }
}
class Solution {
    public int longestPalindrome(String[] words) {
        boolean doubleFound = false;
        String reverseWord = "";
        int palLetterCount = 0;
        Map<String, Integer> myMap = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            reverseWord = String.valueOf(words[i].charAt(1)) + String.valueOf(words[i].charAt(0));
            if (myMap.containsKey(reverseWord)) {
                //remove from hashmap or decrement
                int value = myMap.get(reverseWord);
                if (value == 1) {
                    myMap.remove(reverseWord);
                }
                else {
                    myMap.put(reverseWord, myMap.get(reverseWord) - 1);
                }
                palLetterCount += 4;
            }
            else {
                myMap.put(words[i], myMap.getOrDefault(words[i], 0) + 1);
            }
        }

        for (String key: myMap.keySet()) {
            if (key.charAt(1) == key.charAt(0) && !doubleFound) {
                doubleFound = true;
                palLetterCount += 2;
            }
        }       

        return palLetterCount;
    }
}
class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int ret = 0;
        int numberOfPairs = 0;
        int numberOfSingles = 0;
        
        List<Integer> sizeOfWords = new ArrayList<>();
        
        Map<Character, Integer> charMap = new HashMap<>();
        
        for (String word : words) {
            sizeOfWords.add(word.length());
            for (int i = 0; i < word.length(); i++) {
                charMap.put(word.charAt(i), charMap.getOrDefault(word.charAt(i), 0) + 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            
            numberOfPairs += (value / 2);
            numberOfSingles += (value % 2);
        }
        
        Collections.sort(sizeOfWords);
        
        for (int size : sizeOfWords) {
            boolean good = true;
            
            if (size % 2 == 1) {
                if (numberOfSingles > 0) {
                    numberOfSingles--;
                }
                else if (numberOfPairs > 0) {
                    numberOfPairs--;
                    numberOfSingles++;
                }
                else {
                    good = false;
                    break;
                }
            }
            
            int pairNeeded = size / 2;
            
            if (numberOfPairs >= pairNeeded) {
                numberOfPairs -= pairNeeded;
            }
            else {
                good = false;
                break;
            }
            if (good) {
                ret++;
            }
            //System.out.println("pair:" + numberOfPairs);
            //System.out.println("single: " + numberOfSingles);
        }
        
        return ret;
    }
}
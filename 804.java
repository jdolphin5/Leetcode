class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] concTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseSet = new HashSet<>();
        for (String word : words) {
            String morseWord = "";
            for (int i = 0; i < word.length(); i++) {
                morseWord += concTable[word.charAt(i)-'a'];
            }
            morseSet.add(morseWord);
        }

        return morseSet.size();
    }
}
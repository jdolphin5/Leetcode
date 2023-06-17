class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] concTable = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> morseSet = new HashSet<>();
        for (String word : words) {
            StringBuilder morseWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                morseWord.append(concTable[word.charAt(i)-'a']);
            }
            morseSet.add(new String(morseWord));
        }

        return morseSet.size();
    }
}
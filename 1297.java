class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> occurrences = new HashMap<>();
        int uniqueLetters = 0;
        int[] letters = new int[26];

        int i = 0;
        int j = 0;

        while (j < s.length()) {

            if (letters[s.charAt(j)-'a'] == 0) uniqueLetters++;
            letters[s.charAt(j)-'a']++;
            j++;

            //decrease window
            while (j - i >= minSize && j - i <= maxSize) {
                if (uniqueLetters <= maxLetters) {
                    String subs = s.substring(i, j);
                    occurrences.put(subs, occurrences.getOrDefault(subs, 0) + 1);
                }

                letters[s.charAt(i)-'a']--;
                if (letters[s.charAt(i)-'a'] == 0) uniqueLetters--;
                i++;
            }
            
        }

        return occurrences.entrySet().stream().map(Map.Entry::getValue).max(Comparator.naturalOrder()).orElse(0);

    }
}
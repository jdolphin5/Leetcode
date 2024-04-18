class Solution {
    public class Letter {
        int c;
        int count;

        public Letter (int c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private int recur(String[] words, int i, Map<String, Integer> wordToScoreMap, Map<String, List<Letter>> wordToLetterMap, int[] lettersAvailable, int totalScore) {
        if (i == words.length) {
            return totalScore;
        }

        int score = wordToScoreMap.get(words[i]);
        List<Letter> lettersList = wordToLetterMap.get(words[i]);

        int ans = 0;

        ans = Math.max(ans, recur(words, i+1, wordToScoreMap, wordToLetterMap, lettersAvailable, totalScore));

        for (int j = i; j < words.length; j++) {
            boolean good = true;

            for (int x = 0; x < lettersList.size(); x++) {
                lettersAvailable[lettersList.get(x).c] -= lettersList.get(x).count;
                if (lettersAvailable[lettersList.get(x).c] < 0) {
                    good = false;
                }
            }

            if (good) {
                ans = Math.max(ans, recur(words, j+1, wordToScoreMap, wordToLetterMap, lettersAvailable, totalScore+score));
            }
            
            for (int x = 0; x < lettersList.size(); x++) {
                lettersAvailable[lettersList.get(x).c] += lettersList.get(x).count;
            }
        }

        return ans;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        Map<String, Integer> wordToScoreMap = new HashMap<>();
        Map<String, List<Letter>> wordToLetterMap = new HashMap<>();

        for (String word : words) {
            int wordScore = 0;
            int[] bucket = new int[26];

            for (int i = 0; i < word.length(); i++) {
                wordScore += score[word.charAt(i)-'a'];
                bucket[word.charAt(i)-'a']++;
            }

            wordToScoreMap.put(word, wordScore);
            
            List<Letter> letterList = new ArrayList<>();

            for (int i = 0; i < 26; i++) {
                if (bucket[i] > 0) {
                    letterList.add(new Letter(i, bucket[i]));
                }
            }

            wordToLetterMap.put(word, letterList);
        }

        int[] lettersAvailable = new int[26];

        for (int i = 0; i < letters.length; i++) {
            lettersAvailable[letters[i]-'a']++;
        }

        return recur(words, 0, wordToScoreMap, wordToLetterMap, lettersAvailable, 0);
    }
}
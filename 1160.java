class Solution {
    public int countCharacters(String[] words, String chars) {
        int ret = 0;

        int[] bucket = new int[26];

        for (int i = 0; i < chars.length(); i++) {
            bucket[chars.charAt(i)-'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            boolean good = true;
            int[] copyArr = bucket.clone();

            for (int j = 0; j < words[i].length(); j++) {
                int letter = words[i].charAt(j) - 'a';
                if (--copyArr[letter] < 0) {
                    good = false;
                    break;
                }
            }

            if (good) ret += words[i].length();
        }

        return ret;
    }
}
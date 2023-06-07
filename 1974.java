class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == 0) {
                time += 1;
                time += Math.min(word.charAt(i) - 'a', 1+'z' - word.charAt(i));
                continue;
            }
            char c1 = word.charAt(i-1);
            char c2 = word.charAt(i);
            int forwardTurn = ('z'+1 - c1 + c2 - 'a') % 26;
            int backwardTurn = (c1 - 'a' + 'z'+1 - c2) % 26;
            time += Math.min(forwardTurn, backwardTurn);
            time += 1;
        }
        return time;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];

        for (char myChar : tasks) {
            charMap[myChar-'A']++;
        }
        Arrays.sort(charMap);

        // most frequent task
        int mostFreq = charMap[25] - 1;

        int idleCount = mostFreq * n;

        for (int i=24; i >= 0; i--) {
            idleCount -= Math.min(charMap[i], mostFreq);
        }

        return idleCount > 0 ? idleCount + tasks.length : tasks.length;

    }
}
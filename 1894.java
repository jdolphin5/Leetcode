class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sumOfChalk = 0;

        for (int c : chalk) {
            sumOfChalk += c;
        }

        k %= sumOfChalk;

        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }

            k -= chalk[i];
        }

        return chalk.length-1;
    }
}
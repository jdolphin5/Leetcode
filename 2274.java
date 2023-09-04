class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int max = 0;
        Arrays.sort(special);

        max = special[0] - bottom;
        max = Math.max(max, top - special[special.length-1]);

        for (int i = 1; i < special.length; i++) {
            int diff = special[i] - special[i-1] - 1;
            max = Math.max(max, diff);
        }

        return max;
    }
}
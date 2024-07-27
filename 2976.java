class Solution {
    private void computeCost(int original, int changed, int cost, int[][] charMapping) {
        charMapping[original][changed] = Math.min(charMapping[original][changed], cost);

        //back up the chain from all of the already set char i -> char original
        for (int i = 0; i < charMapping.length; i++) {
            if (charMapping[i][original] != Integer.MAX_VALUE && charMapping[i][changed] > cost + charMapping[i][original]) {
                computeCost(i, changed, cost + charMapping[i][original], charMapping);
            }
        }

        //down the chain from the already set char changed -> char i
        for (int i = 0; i < charMapping[0].length; i++) {
            if (charMapping[changed][i] != Integer.MAX_VALUE && charMapping[original][i] > cost + charMapping[changed][i]) {
                computeCost(original, i, cost + charMapping[changed][i], charMapping);
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] charMapping = new int[26][26];

        for (int[] arr : charMapping) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        for (int i = 0; i < original.length; i++) {
            int orig = original[i]-'a';
            int chang = changed[i]-'a';
            int co = cost[i];

            computeCost(orig, chang, co, charMapping);
        }

        //System.out.println(Arrays.toString(charMapping[3]));

        long ret = 0;

        for (int i = 0; i < source.length(); i++) {
            int s = source.charAt(i)-'a';
            int t = target.charAt(i)-'a';

            if (s == t) continue;

            if (charMapping[s][t] == Integer.MAX_VALUE) {
                return -1L;
            }
            else {
                ret += charMapping[s][t];
            }

            //System.out.println(ret);
        }

        return ret;
    }
}
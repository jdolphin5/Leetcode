class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> posNums = new ArrayList();
        List<Integer> negNums = new ArrayList();

        for (int val : nums) {
            if (val >= 0) {
                posNums.add(val);
            }
            else {
                negNums.add(val);
            }
        }

        int x = posNums.size();
        int y = negNums.size();
        

        int[] result = new int[x+y];
        int p = 0;

        for (int i = 0, j = 0; p < x + y;) {
            if (i < x) result[p] = posNums.get(i);
            i++;
            p++;
            if (j < y) result[p] = negNums.get(j);
            j++;
            p++;
        }
        return result;
    }
}
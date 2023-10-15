class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        Pair<Integer, Integer>[] pairArr = new Pair[nums.length];
       
        for (int i = 0; i < nums.length; i++) {
            pairArr[i] = new Pair(i, nums[i]);
        }
        
        Arrays.sort(pairArr, (a, b) -> a.getValue() - b.getValue());
        
        int i = 0;
        
        while (i < nums.length && Math.abs(pairArr[i].getValue() - pairArr[nums.length-1].getValue()) >= valueDifference) {
            for (int j = nums.length-1; j >= 0; j--) {
                if (Math.abs(pairArr[i].getValue() - pairArr[j].getValue()) >= valueDifference) {
                    if (Math.abs(pairArr[i].getKey() - pairArr[j].getKey()) >= indexDifference) {
                        //System.out.println(pairArr[i].getValue() + " + " + pairArr[j].getValue());
                        return new int[] {pairArr[j].getKey(), pairArr[i].getKey()};
                    }
                }
                else {
                    break;
                }
            }
            i++;
        }
        
        return new int[]{-1, -1};
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] bucket = new int[201];

        for (int num : nums) {
            bucket[num+100]++;
        }

        int[] ret = new int[nums.length];
        int x = 0;

        for (int i = 1; i < 101; i++) {
            List<Integer> myList = new ArrayList<>();

            for (int j = 0; j < 201; j++) {
                if (bucket[j] == i) {
                    myList.add(j);
                }
            }

            Collections.sort(myList, Collections.reverseOrder());
            
            for (int num : myList) {
                for (int p = 0; p < i; p++)
                    ret[x++] = num-100;
            }
        }

        return ret;
    }
}
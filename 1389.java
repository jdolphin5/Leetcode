class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {

        List<Integer> myList = new ArrayList<>();
        int[] target = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            myList.add(index[i], nums[i]);
        }

        for (int i = 0; i < myList.size(); i++) {
            target[i] = myList.get(i);
        }

        return target;

    }
}
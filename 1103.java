class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] nums = new int[num_people];
        int count = 0;
        while (candies > 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies < 1 || candies < ((count * num_people) + (i+1))) {
                    nums[i] += candies;
                    candies = 0;
                    break;
                }
                candies -= (count * num_people) + (i+1);
                nums[i] += (count * num_people) + (i+1);
                //System.out.println(candies);
                //System.out.println(Arrays.toString(nums));
            }
            count++;
        }
        return nums;
    }
}
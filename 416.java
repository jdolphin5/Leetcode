class Solution {
    public boolean canPartition(int[] nums) {

        int target = 0;
        for (int i : nums) {
            target += i;
        }

        if (target % 2 != 0) return false;
        target = target / 2; //set target to half of total sum of array

        Set<Integer> mySet = new HashSet<>();

        for (int num : nums) {
            mySet.add(0);
            List<Integer> myList = new ArrayList(); //list to store set in
            Iterator<Integer> iterator = mySet.iterator();

            while(iterator.hasNext()) {
                Integer element = iterator.next();
                myList.add(element); // cannot add to set directly while iterating
            }

            for (int element : myList) {
                mySet.add(num + element); //add the cur num to every element in set to try find target as a subarray
            }

            if (mySet.contains(target)) return true;
        }

        return false;
    }
}
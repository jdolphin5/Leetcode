class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> myList = new ArrayList<>();

        for (int num : nums) {
            List<Integer> tempList = new ArrayList<>();
            while (num > 0) {
                tempList.add(num % 10);
                num = num / 10;
            }
            for (int i = tempList.size()-1; i >= 0; i--) {
                myList.add(tempList.get(i));
            }
        }

        int[] result = new int[myList.size()];
        for (int i = 0; i < myList.size(); i++) {
            result[i] = myList.get(i);
        }

        return result;

    }
}
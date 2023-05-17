class Solution {
    public int countDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        int res = 0;

        int nums = num;
        while (nums > 0) {
            digits.add(nums % 10);
            nums /= 10;
        }
        for (int i : digits) {
            if (num % i == 0) {
                res++;
            }
        }

        return res;
    }
}
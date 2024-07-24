class Solution {
    public class MappedNumber {
        int original;
        int mapped;

        public MappedNumber (int original, int mapped) {
            this.original = original;
            this.mapped = mapped;
        }
    }

    private MappedNumber mapNumber(int[] mapping, int num) {
        int[] mappedNumberArr = new int[mapping.length];
        int original = num;

        if (num == 0) {
            return new MappedNumber(original, mapping[0]);
        }

        int i = mapping.length-1;
        while (num > 0) {
            int x = num % 10;
            mappedNumberArr[i--] = mapping[x];
            num /= 10;
        }

        //System.out.println(Arrays.toString(mappedNumberArr));

        int ret = 0;
        int x = 0;

        for (int j = mappedNumberArr.length - 1; j >= 0; j--) {
            ret += Math.pow(10, x++) * mappedNumberArr[j];
        }

        //System.out.println("original: " + original + " ret: " + ret);

        return new MappedNumber(original, ret);
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        MappedNumber[] mappedArr = new MappedNumber[nums.length];

        for (int i = 0; i < mappedArr.length; i++) {
            mappedArr[i] = mapNumber(mapping, nums[i]);
        }

        Arrays.sort(mappedArr, (a, b) -> a.mapped - b.mapped);

        int[] ret = new int[nums.length];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = mappedArr[i].original;
        }

        return ret;
    }
}
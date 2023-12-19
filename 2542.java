class Solution {
    public class Nums {
        int nums1;
        int nums2;
        int i;

        public Nums(int nums1, int nums2, int i) {
            this.nums1 = nums1;
            this.nums2 = nums2;
            this.i = i;
        }
    }
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Nums[] numsArr = new Nums[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            numsArr[i] = new Nums(nums1[i], nums2[i], i);
        }

        Arrays.sort(numsArr, (a, b) -> b.nums2 - a.nums2);

        long ret = 0;

        long nums1Sum = 0;
        int minNums2 = Integer.MAX_VALUE;

        int j = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        while (j < numsArr.length) {
            pq.offer(numsArr[j].nums1);
            nums1Sum += numsArr[j].nums1;

            if (pq.size() > k) {
                nums1Sum -= pq.poll();
            }
            
            minNums2 = Math.min(minNums2, numsArr[j].nums2);

            j++;

            if (pq.size() == k) {
                ret = Math.max(ret, nums1Sum * (long)minNums2);
            }
        }

        return ret;
    }
}
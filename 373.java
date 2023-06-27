class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ret = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> a[0] + a[1] - b[1] - b[0]);
        Set<String> visited = new HashSet<>();
        pq.offer(new int[] { nums1[0], nums2[0], 0, 0 });
        visited.add("0,0");

        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            List<Integer> curList = new ArrayList<>();
            curList.add(cur[0]);
            curList.add(cur[1]);
            ret.add(curList);
            k--;

            int i = cur[2];
            int j = cur[3];

            if (i < nums1.length-1 && !visited.contains((i + 1) + "," + j)) {
                pq.offer(new int[] { nums1[i+1], nums2[j], i+1, j });
                visited.add((i+1) + "," + j);
            }
            if (j < nums2.length-1 && !visited.contains(i + "," + (j + 1))) {
                pq.offer(new int[] { nums1[i], nums2[j+1], i, j+1 });
                visited.add(i + "," + (j+1));
            }
        }

        return ret;
    }
}
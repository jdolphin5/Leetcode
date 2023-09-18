class Solution {
    public class rowClass {
        int soldierCount;
        int index;

        public rowClass(int soldierCount, int index) {
            this.soldierCount = soldierCount;
            this.index = index;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<rowClass> pq = new PriorityQueue<>((a, b) -> a.soldierCount == b.soldierCount ? a.index - b.index : a.soldierCount - b.soldierCount);

        for (int i = 0; i < mat.length; i++) {
            int soldierCount = 0;

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    soldierCount++;
                }
            }

            pq.offer(new rowClass(soldierCount, i));
        }

        int[] ret = new int[k];

        for (int i = 0; i < k; i++) {
            ret[i] = pq.poll().index;
        }

        return ret;
    }
}
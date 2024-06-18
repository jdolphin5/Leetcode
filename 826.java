class Solution {
    public class Job {
        int difficulty;
        int profit;

        public Job (int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }

        public String toString() {
            return "diff: " + difficulty + " profit: " + profit;
        }
    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Job[] jobArr = new Job[difficulty.length];
        
        for (int i = 0; i < difficulty.length; i++) {
            jobArr[i] = new Job(difficulty[i], profit[i]);
        }

        Arrays.sort(jobArr, (a, b) -> b.profit - a.profit);

        //System.out.println(Arrays.toString(jobArr));

        int ret = 0;

        for (int w : worker) {
            for (int i = 0; i < jobArr.length; i++) {
                if (w >= jobArr[i].difficulty) {
                    ret += jobArr[i].profit;
                    break;
                }
            }
        }

        return ret;
    }
}
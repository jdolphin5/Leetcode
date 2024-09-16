class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minsArr = new int[timePoints.size()];
        Collections.sort(timePoints);


        for (int i = 0; i < timePoints.size(); i++) {
            String[] split = timePoints.get(i).split(":", 0);
            minsArr[i] = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
        }

        int ret = Integer.MAX_VALUE;

        for (int i = 0; i < minsArr.length-1; i++) {
            ret = Math.min(ret, minsArr[i+1] - minsArr[i]);
        }

        ret = Math.min(ret, (minsArr[0] + (24 * 60)) - minsArr[minsArr.length-1]);

        return ret;
    }
}
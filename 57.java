class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

       ArrayList<int[]> myList = new ArrayList<>();

        for(int i = 0 ; i < intervals.length ; i++){
            if (intervals[i][1] < newInterval[0]) myList.add(intervals[i]);
            else if (intervals[i][0] > newInterval[1]) {
                myList.add(newInterval);
                newInterval = intervals[i];
            }
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        myList.add(newInterval);
        int result[][]  = new int[myList.size()][2];

        for(int i = 0; i < myList.size() ; i++){
            result[i] = myList.get(i);
        }
        return result;

    }
}
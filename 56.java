class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b)-> {
            if(a[0] == b[0]){
                return a[1] - b[1];
         }
         return a[0] - b[0];
        });

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            List<Integer> myList = new ArrayList<>();
            myList.add(intervals[i][0]);
            myList.add(intervals[i][1]);
            for (int j = i+1; j < intervals.length; j++) {
                if (intervals[j][0] <= myList.get(1)) {
                    int val = Math.max(myList.get(1), intervals[j][1]);
                    myList.remove(1);
                    myList.add(val);
                    i++;
                }
            }
            result.add(myList);
        }
        
        int[][] resultArr = new int[result.size()][2];

        for (int i = 0; i < result.size(); i++) {
            List<Integer> myList = result.get(i);
            resultArr[i][0] = myList.get(0);
            resultArr[i][1] = myList.get(1);
        }

        return resultArr;
    }
}
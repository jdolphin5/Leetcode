class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length-1; i++) {
            int currDiff = Math.abs(arr[i+1] - arr[i]);
            if (minDiff > currDiff) {
                minDiff = currDiff;
                result.clear();
                List<Integer> myList = new ArrayList();
                myList.add(arr[i]);
                myList.add(arr[i+1]);
                result.add(myList);
            } 
            else if (minDiff == currDiff) {
                List<Integer> myList = new ArrayList();
                myList.add(arr[i]);
                myList.add(arr[i+1]);
                result.add(myList);
            }
        }
        return result;
    }
}
class Solution {
    public int getWinner(int[] arr, int k) {
        int winCount = 0;
        int curWinner = 0;
        int max = 0;
        for (int num : arr) {
            if (num > max) max = num;
        }

        List<Integer> myList = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());;
        while (winCount < k) {
            int a = myList.get(0);
            int b = myList.get(1);
            if (a > b) {
                winCount++;
                myList.remove(1);
                myList.add(myList.size(), b);
                curWinner = a;
            }
            else {
                winCount = 1;
                myList.remove(0);
                myList.add(myList.size(), a);
                curWinner = b;
            }
            if (curWinner == max) return max;
        }
        return curWinner;
    }
}
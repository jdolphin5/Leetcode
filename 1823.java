class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> myList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            myList.add(i);
        }

        int cur = 0;

        while (myList.size() > 1) {
            int x = myList.size();
            cur = (cur + (k-1)) % x;
            myList.remove(cur);
        }

        return myList.get(0);
    }
}
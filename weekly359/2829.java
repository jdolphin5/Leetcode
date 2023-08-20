class Solution {
    public int minimumSum(int n, int k) {
        List<Integer> myList = new ArrayList<>();
        int i = 0;
        int sum = 0;
        int a = 1;
        while (i < n) {
            if (!myList.contains(k-a)) {
                myList.add(a);
                sum += a;
                i++;
            }
            a++;
        }
        return sum;
    }
}
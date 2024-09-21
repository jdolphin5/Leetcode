class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> myList = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            myList.add(i);
        }

        Collections.sort(myList, (a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));

        return myList;
    }
}
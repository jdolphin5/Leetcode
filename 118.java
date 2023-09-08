class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        ret.add(new ArrayList<>(myList));

        if (numRows == 1) return ret;

        myList.add(1);
        ret.add(new ArrayList<>(myList));

        if (numRows == 2) return ret;

        for (int i = 3; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < myList.size()-1; j++) {
                cur.add(myList.get(j) + myList.get(j+1));
            }
            cur.add(1);
            ret.add(cur);
            myList = cur;
        }

        return ret;
    }
}
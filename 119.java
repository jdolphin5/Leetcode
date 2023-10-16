class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> cur = new ArrayList<>();

        cur.add(1);
        if (rowIndex == 0) {
            return cur;
        }

        cur.add(1);
        if (rowIndex == 1) {
            return cur;
        }

        for (int i = 2; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>();
            next.add(1);

            for (int x = 0; x < cur.size()-1; x++) {
                next.add(cur.get(x)+cur.get(x+1));
            }

            next.add(1);
            cur = next;
        }

        return cur;
    }
}
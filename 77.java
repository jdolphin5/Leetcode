class Solution {
    private void recur(int n, int k, Set<List<Integer>> ret, List<Integer> cur, int a, int last) {
        if (a == k) {
            List<Integer> toAdd = new ArrayList<>();
            for (int num : cur) {
                toAdd.add(num);
            }
            ret.add(toAdd);
        }

        for (int i = 1; i <= n; i++) {
            if (last >= i || cur.contains(i)) continue;
            cur.add(i);
            recur(n, k, ret, cur, a+1, i);
            cur.remove(new Integer(i));
        }


    }

    public List<List<Integer>> combine(int n, int k) {
        Set<List<Integer>> ret = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        recur(n, k, ret, cur, 0, 0);
        return new ArrayList<>(ret);
    }
}
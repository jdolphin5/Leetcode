class Solution {
    private void recur(int low, int high, String cur, List<Integer> ret) {
        int curInt = Integer.parseInt(cur);

        if (curInt > high) {
            return;
        }
        if (curInt >= low) {
            ret.add(curInt);
        }

        int last = curInt % 10;

        if (last != 9)
            recur(low, high, cur + String.valueOf(last+1), ret);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ret = new ArrayList<>();
        
        for (int i = 1; i <= 9; i++) {
            recur(low, high, String.valueOf(i), ret);
        }

        Collections.sort(ret);

        return ret;
    }
}
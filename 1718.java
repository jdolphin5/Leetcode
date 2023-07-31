class Solution {
    private boolean backtrack(int[] arr, int n, Set<Integer> used, int i, List<int[]> retList) {
        if (used.size() == n) {
            retList.add(arr.clone());
            return true;
        }

        if (arr[i] == 0 || arr[i] == 1) {
            for (int j = n-1; j >= 1; j--) {
                if (!used.contains(j)) {
                    if (j > 1 && (i+j) < 2*n-1 && arr[i+j] == 0) {
                        arr[i] = j;
                        arr[i+j] = j;
                        used.add(j);
                        if (backtrack(arr, n, used, i+1, retList)) return true;
                        arr[i] = 0;
                        arr[i+j] = 0;
                        used.remove(j);
                    }
                    else if (j == 1) {
                        arr[i] = j;
                        used.add(j);
                        if (backtrack(arr, n, used, i+1, retList)) return true;
                        arr[i] = 0;
                        used.remove(j);
                    }
                }
            }
        }
        else {
            if (backtrack(arr, n, used, i+1, retList)) return true;
        }

        return false;
    }

    public int[] constructDistancedSequence(int n) {
        if (n == 1) return new int[] {1};
        Set<Integer> used = new HashSet<>();
        int[] arr = new int[2*n-1];
        arr[0] = n;
        arr[n] = n;
        used.add(n);

        List<int[]> retList = new ArrayList<>();

        backtrack(arr, n, used, 1, retList);

        return retList.get(0);

    }
}
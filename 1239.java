class Solution {
    private int recur(List<String> arr, Set<Character> charSet, int i) {
        if (i == arr.size()) {
            return 0;
        }

        int take = 0;
        int leave = 0;

        Set<Character> copySet = new HashSet<>(charSet);

        for (int j = 0; j < arr.get(i).length(); j++) {
            if (!copySet.add(arr.get(i).charAt(j))) {
                take = -1;
                break;
            }
        }

        if (take != -1) {
            take = arr.get(i).length() + recur(arr, copySet, i+1);
        }

        leave = recur(arr, charSet, i+1);

        return Math.max(take, leave);
    }

    public int maxLength(List<String> arr) {
        return recur(arr, new HashSet<>(), 0);
    }
}
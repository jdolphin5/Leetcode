class Solution {
    private void recur(int[] candidates, int target, int sum, int i, Set<List<Integer>> ret, List<Integer> curList) {
        if (sum == target) {
            Collections.sort(curList);
            ret.add(new ArrayList<>(curList));
            return;
        }
        
        if (i == candidates.length || sum > target) {
            return;
        }

        for (int j = i; j < candidates.length; j++) {
            if (j > i && candidates[j] == candidates[j-1])
                continue;
            curList.add(candidates[j]);
            recur(candidates, target, sum + candidates[j], j+1, ret, curList);
            curList.remove(curList.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ret = new HashSet<>();
        Arrays.sort(candidates);

        recur(candidates, target, 0, 0, ret, new ArrayList<>());

        return new ArrayList<>(ret);
    }
}
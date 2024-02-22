class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1)
            return 1;

        Set<Integer>[] personTrustSet = new HashSet[n+1];
        for (int i = 0; i < personTrustSet.length; i++) {
            personTrustSet[i] = new HashSet<>();
        }

        for (int[] t : trust) {
            personTrustSet[t[1]].add(t[0]);
        }

        List<Integer> trustedByEveryoneList = new ArrayList<>();

        for (int i = 0; i < personTrustSet.length; i++) {
            if (personTrustSet[i].size() == n-1) trustedByEveryoneList.add(i);
        }

        for (int potentialJudge : trustedByEveryoneList) {
            boolean good = true;
            
            for (Set<Integer> mySet : personTrustSet) {
                if (mySet.contains(potentialJudge))
                    good = false;
            }

            if (good) return potentialJudge;
        }

        return -1;
    }
}
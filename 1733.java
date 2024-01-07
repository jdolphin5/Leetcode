class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        //try all languages from 1 to n
        //see how many users need to learn that language

        Set<Integer>[] languagesOfUsers = new HashSet[languages.length];

        for (int i = 0; i < languagesOfUsers.length; i++) {
            languagesOfUsers[i] = new HashSet<>();
            for (int j = 0; j < languages[i].length; j++) {
                languagesOfUsers[i].add(languages[i][j]);
            }
        }

        boolean[] canCommunicate = new boolean[friendships.length];

        for (int i = 0; i < friendships.length; i++) {
            Set<Integer> mySet = new HashSet<>(languagesOfUsers[friendships[i][0]-1]);
            mySet.retainAll(languagesOfUsers[friendships[i][1]-1]);

            if (mySet.size() > 0) canCommunicate[i] = true;
        }

        int ret = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(canCommunicate));

        for (int i = 1; i <= n; i++) {
            int count = 0;

            boolean[] taughtLanguage = new boolean[languages.length];

            for (int j = 0; j < canCommunicate.length; j++) {
                if (canCommunicate[j]) continue;

                int friend1 = friendships[j][0]-1;
                int friend2 = friendships[j][1]-1;

                if (!taughtLanguage[friend1] && !languagesOfUsers[friend1].contains(i)) {
                    taughtLanguage[friend1] = true;
                    count++;
                }

                if (!taughtLanguage[friend2] && !languagesOfUsers[friend2].contains(i)) {
                    taughtLanguage[friend2] = true;
                    count++;
                }
            }

            ret = Math.min(ret, count);
        }

        return ret;
    }
}
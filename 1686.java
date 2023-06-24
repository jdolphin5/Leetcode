class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        int aliceScore = 0;
        int bobScore = 0;
        boolean[] visited = new boolean[n];

        //map of<Sum of values, indexes of specific sum of values>
        Map<Integer, List<Integer>> stoneMap = new HashMap<>(); 
        //map of <index, bobValues>
        Map<Integer, Integer> bobMap = new HashMap<>();
        //a + b = total value of each stone for either alice of bob
        int[] sumArr = new int[n];

        for (int i = 0; i < n; i++) {
            List<Integer> stoneList = stoneMap.getOrDefault(aliceValues[i]+bobValues[i], new ArrayList<>());
            stoneList.add(i);
            stoneMap.put(aliceValues[i] + bobValues[i], stoneList);
            bobMap.put(i, bobValues[i]);
            sumArr[i] = aliceValues[i] + bobValues[i];
        }

        //sort arr desc order
        Arrays.sort(sumArr);
        int[] sumArrDesc = Arrays.stream(sumArr).boxed()
        .sorted(Collections.reverseOrder())
        .mapToInt(Integer::intValue)
        .toArray();

        int j = 0; //track whose turn it is
        int x = 0; //total number of stones that have been selected
        while (x < n) {
            List<Integer> stoneList = stoneMap.get(sumArrDesc[x]);
            for (int p = 0; p < stoneList.size(); p++) {
                if (!visited[stoneList.get(p)]) { //check if stone already chosen
                    visited[stoneList.get(p)] = true;
                    if (j % 2 == 0) { //alice turn
                        aliceScore += (sumArrDesc[x] - bobMap.get(stoneList.get(p)));
                    }
                    else { //bob turn
                        bobScore += bobMap.get(stoneList.get(p));
                    }
                    stoneList.remove(p);
                    stoneMap.put(sumArrDesc[x], stoneList);
                    j++;
                    break;
                }
            }
            x++;
        }

        if (aliceScore > bobScore) {
            return 1;
        }
        else if (aliceScore == bobScore) {
            return 0;
        }
        else {
            return -1;
        }

    }
}
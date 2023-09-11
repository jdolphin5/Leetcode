class Solution {
    public long dividePlayers(int[] skill) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int num : skill) {
            myMap.put(num, myMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> totalSet = new HashSet<>();

        for (int i = 1; i < skill.length; i++) {
            int total = skill[0] + skill[i];

            if (!totalSet.contains(total)) {
                Set<Integer> mySet = new HashSet<>();
                long ret = 0;

                for (int j = 0; j < skill.length; j++) {
                    if (!mySet.contains(skill[j])) {
                        int xCount = myMap.get(skill[j]);
                        int yCount = myMap.getOrDefault(total-skill[j], 0);

                        if (xCount != yCount) {
                            break;
                        }

                        if (skill[j] == total-skill[j]) {
                            if (xCount % 2 == 1) {
                                break;
                            }

                            ret += ((long)(xCount/2) * (skill[j] * skill[j]));
                        }
                        else {
                            ret += (long)xCount * (skill[j] * (total-skill[j]));
                        }

                        mySet.add(skill[j]);
                        mySet.add(total-skill[j]);
                    }
                }

                if (mySet.size() == myMap.size()) {
                    return ret;
                }
            }
            totalSet.add(total);
        }

        return -1;
    }
}
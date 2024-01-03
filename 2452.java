class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ret = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int j = 0;

            while (j < dictionary.length) {
                int ct = 0;

                for (int k = 0; k < dictionary[j].length(); k++) {
                    if (queries[i].charAt(k) != dictionary[j].charAt(k)) {
                        ct++;
                    }
                }

                if (ct <= 2) {
                    ret.add(queries[i]);
                    break;
                }

                j++;
            }
        }

        return ret;
    }
}
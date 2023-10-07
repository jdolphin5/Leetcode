class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = new HashMap<>();

        for (List<String> list : knowledge) {
            for (int i = 0; i < list.size(); i++) {
                knowledgeMap.put(list.get(0), list.get(1));
            }
        }

        int i = 0;
        boolean isKey = false;
        StringBuilder curKey = new StringBuilder();
        StringBuilder ret = new StringBuilder();

        while (i < s.length()) {
            char c = s.charAt(i);

            if (c == '(') {
                isKey = true;
                curKey = new StringBuilder();
            }
            else if (c == ')') {
                isKey = false;
                String toAdd = knowledgeMap.get(curKey.toString());

                if (toAdd == null) {
                    ret.append("?");
                }
                else {
                    ret.append(toAdd);
                }
            }
            else if (isKey) {
                curKey.append(c);
            }
            else {
                ret.append(c);
            }

            i++;
        }

        return new String(ret);
    }
}
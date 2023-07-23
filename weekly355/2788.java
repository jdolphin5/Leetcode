class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String word = "";
            for (int j = 0; j < words.get(i).length(); j++) {
                char c = words.get(i).charAt(j);
                if (c == separator) {
                    if (word != "") {
                        ret.add(word);
                    }
                    word = "";
                }
                else {
                    word += c;
                }
            }
            if (word != "") {
                ret.add(word);
            }
        }
        return ret;
    }
}
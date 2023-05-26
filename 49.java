class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        int[][] buckets = new int[strs.length][26];

        for (int i = 0; i < strs.length; i++) {
            int[] bucket = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                bucket[strs[i].charAt(j)-'a']++;
            }
            buckets[i] = bucket;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (strs[i] == "") continue;
            List<String> myList = new ArrayList<>();
            myList.add(strs[i]);
            for (int j = i+1; j < buckets.length; j++) {
                if (strs[j] == "") continue;
                if (Arrays.equals(buckets[i], buckets[j])) {
                    myList.add(strs[j]);
                    strs[j] = "";
                }
            }
            result.add(myList);
        }

        return result;
    }
}
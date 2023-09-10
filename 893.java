class Solution {
    public int numSpecialEquivGroups(String[] words) {
        List<int[]> myList1 = new ArrayList<>();
        List<int[]> myList2 = new ArrayList<>();
        int count = 0;

        for (String word : words) {
            int[] wordBucket1 = new int[26];
            int[] wordBucket2 = new int[26];
            boolean equivalentFound = false;

            for (int i = 0; i < word.length(); i++) {
                if (i % 2 == 0)
                    wordBucket1[word.charAt(i)-'a']++;
                else
                    wordBucket2[word.charAt(i)-'a']++;
            }

            for (int j = 0; j < myList1.size(); j++) {
                if (Arrays.equals(myList1.get(j), wordBucket1) && Arrays.equals(myList2.get(j), wordBucket2))
                    equivalentFound = true;
            }
            if (!equivalentFound) {
                count++;
                myList1.add(wordBucket1);
                myList2.add(wordBucket2);
            }
        }

        return count;
    }
}
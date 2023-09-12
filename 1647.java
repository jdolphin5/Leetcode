class Solution {
    public int minDeletions(String s) {
        Set<Integer> freqSet = new HashSet<>();
        int[] bucket = new int[26];
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] > 0) {
                int val = bucket[i];
                
                while (freqSet.contains(val)) {
                    val--;
                    count++;
                }

                if (val > 0)
                    freqSet.add(val);
            }
        }

        return count;
    }
}
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] charArr = new int[26];
        
        for (int i = 0; i < word.length(); i++) {
            charArr[word.charAt(i)-'a']++;
        }
        
        Arrays.sort(charArr);
        
        List<Integer> charCountList = new ArrayList<>();
        int total = 0;
        
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != 0) {
                charCountList.add(charArr[i]);
                total += charArr[i];
            }
        }
        
        int ret = Integer.MAX_VALUE;
        
        //System.out.println("q");
        
        for (int i = 0; i < charCountList.size(); i++) {
            int count = 0;
            int diff = 0;
            
            for (int j = i; j < charCountList.size(); j++) {
                count += charCountList.get(j);
                if (charCountList.get(j) - charCountList.get(i) >= k)
                    diff += (charCountList.get(j) - charCountList.get(i)) - k;
                
                ret = Math.min(ret, total - count + diff);
                //System.out.println("i: " + i + " j : " + j + " total: " + total + " count: " + count + " diff: " + diff + " ret: " + ret);
            }
        }
        
        return ret;
    }
}
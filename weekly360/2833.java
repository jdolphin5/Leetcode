class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int extra = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L')
                left++;
            if (moves.charAt(i) == 'R')
                right++;
            if (moves.charAt(i) == '_')
                extra++;
        }
        
        return Math.max(extra+left-right, extra+right-left);
    }
}
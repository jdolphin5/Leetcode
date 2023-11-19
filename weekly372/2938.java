class Solution {
    public long minimumSteps(String s) {
        long ret = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '1') {
                if (!q.isEmpty()) {
                    ret += q.poll()-i;
                    q.offer(i);
                }
            }
            else {
                q.offer(i);
            }
        }
        
        return ret;
    }
}
class Solution {
    public class LockState {
        int val;
        int turns;

        public LockState(int val, int turns) {
            this.val = val;
            this.turns = turns;
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<Integer> deadendSet = new HashSet<>();

        for (String s : deadends) {
            deadendSet.add(Integer.parseInt(s));
        }

        Queue<LockState> q = new LinkedList<>();
        boolean[] visited = new boolean[10000];

        q.offer(new LockState(0, 0));
        int ret = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            while(!q.isEmpty() && (visited[q.peek().val] || deadendSet.contains(q.peek().val))) {
                q.poll();
            }

            if (q.isEmpty()) {
                break;
            }

            LockState cur = q.poll();
            visited[cur.val] = true;

            if (cur.val == Integer.parseInt(target)) {
                ret = Math.min(ret, cur.turns);
            }

            int num = cur.val;

            for (int i = 0; i <= 3; i++) {
                int modNum = num % 10;

                int mult = 1;

                if (i >= 1) {
                    mult = (int)Math.pow(10, i);
                }

                if (modNum == 9) {
                    q.offer(new LockState(cur.val - 9*mult, cur.turns+1));
                    q.offer(new LockState(cur.val - 1*mult, cur.turns+1));
                }
                else if (modNum == 0) {
                    q.offer(new LockState(cur.val + 9*mult, cur.turns+1));
                    q.offer(new LockState(cur.val + 1*mult, cur.turns+1));
                }
                else {
                    q.offer(new LockState(cur.val + 1*mult, cur.turns+1));
                    q.offer(new LockState(cur.val - 1*mult, cur.turns+1));
                }

                num /= 10;
            }
        }

        return ret == Integer.MAX_VALUE ? -1 : ret;

    }
}
class Solution {
    public class Friend {
        int i;
        int arrivalTime;
        int leavingTime;
        int seat;

        public Friend(int i, int arrivalTime, int leavingTime) {
            this.i = i;
            this.arrivalTime = arrivalTime;
            this.leavingTime = leavingTime;
        }

        public void setSeat(int seat) {
            this.seat = seat;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        
        //unoccupied chairs TreeSet
        TreeSet<Integer> myTreeSet = new TreeSet<>();

        for (int i = 0; i < 100000; i++) {
            myTreeSet.add(i);
        }

        //arrival pq
        PriorityQueue<Friend> arrivalPq = new PriorityQueue<>((a, b) -> a.arrivalTime - b.arrivalTime);
        PriorityQueue<Friend> leavingPq = new PriorityQueue<>((a, b) -> a.leavingTime - b.leavingTime);
        Map<Integer, Integer> friendIndexToSeatMap = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];

            int arrival = time[0];
            int leaving = time[1];

            Friend f = new Friend(i, arrival, leaving);

            arrivalPq.offer(f);
            leavingPq.offer(f);
        }

        while (!arrivalPq.isEmpty() || !leavingPq.isEmpty()) {
            int arriv = Integer.MAX_VALUE;
            int leav = Integer.MAX_VALUE;

            if (!arrivalPq.isEmpty()) {
                arriv = arrivalPq.peek().arrivalTime;
            }
            if (!leavingPq.isEmpty()) {
                leav = leavingPq.peek().leavingTime;
            }

            if (arriv < leav) {
                if (arrivalPq.peek().i == targetFriend) {
                    return myTreeSet.first();
                }

                friendIndexToSeatMap.put(arrivalPq.peek().i, myTreeSet.first());
                myTreeSet.remove(myTreeSet.first());

                arrivalPq.poll();
            }
            else {
                myTreeSet.add(friendIndexToSeatMap.get(leavingPq.peek().i));

                leavingPq.poll();
            }
        }

        return -1;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        if (temperatures == null) return null;

        int[] result = new int[temperatures.length];

        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = temperatures.length-1; i >= 0; i--) {
            myMap.put(temperatures[i], i);
            while(!deque.isEmpty() && deque.peekLast() <= temperatures[i]) {
                deque.pollLast();
            }

            int val;
            if (!deque.isEmpty()) {
                val = deque.peekLast();
            }
            else {
                val = -1;
            }

            result[i] = myMap.getOrDefault(val, -1);
            if (result[i] >= 0) result[i] -= i;
            else result[i] = 0;

            deque.addLast(temperatures[i]);
            
        }

        return result;
    }
}
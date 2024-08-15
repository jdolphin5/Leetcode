class Solution {
    private class MemoryObject {
        int index;
        int memory;

        public MemoryObject(int index, int memory) {
            this.index = index;
            this.memory = memory;
        }
    }

    public int[] memLeak(int memory1, int memory2) {
        int[] ret = new int[3];
        int i = 1;

        PriorityQueue<MemoryObject> pq = new PriorityQueue<>((a, b) -> a.memory == b.memory ? a.index - b.index : b.memory - a.memory);
        pq.offer(new MemoryObject(0, memory1));
        pq.offer(new MemoryObject(1, memory2));

        while (true) {
            //System.out.println(pq.peek().memory);
            if (pq.peek().memory < i) {
                break;
            }

            MemoryObject x = pq.poll();
            pq.offer(new MemoryObject(x.index, x.memory-i));
            i++;
        }

        while (!pq.isEmpty()) {
            ret[pq.peek().index+1] = pq.peek().memory;
            pq.poll();
        }

        ret[0] = i;

        return ret;
    }
}
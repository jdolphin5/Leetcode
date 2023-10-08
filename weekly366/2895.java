class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks, Collections.reverseOrder());
        Collections.sort(processorTime);
        
        int taken = 0;
        int totalTime = 0;
        int curProcessor = 0;
        
        for (int i = 0; i < tasks.size(); i++) {
            if (taken < 4) {
                taken++;
            }
            else {
                taken = 1;
                curProcessor++;
            }
            
            totalTime = Math.max(totalTime, processorTime.get(curProcessor)+tasks.get(i));
        }
        
        return totalTime;
    }
}
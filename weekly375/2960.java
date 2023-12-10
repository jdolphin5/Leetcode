class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int ret = 0;
        
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                ret++;
                for (int j = i+1; j < batteryPercentages.length; j++) {
                    
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j]-1);
                }
            }
        }
        
        return ret;
    }
}
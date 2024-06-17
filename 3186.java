class Solution {
    public class FreqPower {
        int ct;
        int power;
        long mult;

        public FreqPower(int ct, int power) {
            this.ct = ct;
            this.power = power;
            this.mult = (long)ct * (long)power;
        }

        public String toString() {
            return "ct: " + ct + " power: " + power + " mult: " + mult;
        }
    }
    
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);

        List<FreqPower> myList = new ArrayList<>();

        int ct = 0;
        int last = 0;

        for (int i = 0; i < power.length; i++) {
            if (last == power[i]) {
                ct++;
            }
            else {
                if (ct != 0)
                    myList.add(new FreqPower(ct, last));
                last = power[i];
                ct = 1;
            }
        }

        myList.add(new FreqPower(ct, last));

        if (myList.size() == 1) return myList.get(0).mult;

        Long[] dp = new Long[myList.size()];
        
        //map to record the index of the next valid spell for each index
        Map<Integer, Integer> nextPosMap = new HashMap<>();
        
        for (int i = 0; i < myList.size(); i++) {
            long x = myList.get(i).power;
            int next = myList.size();
            
            for (int j = i+1; j < myList.size(); j++) {
                if (myList.get(j).power >= x+3) {
                    next = j;
                    break;
                }
            }
            
            nextPosMap.put(i, next);
        }

        long ret = 0;

        for (int i = 0; i < myList.size(); i++) {
            dp[i] = myList.get(i).mult;
            
            if (i >= 3 && nextPosMap.get(i-3) <= i) {
                dp[i] = Math.max(dp[i], myList.get(i).mult + dp[i-3]);
            }
            if (i >= 2 && nextPosMap.get(i-2) <= i) {
                dp[i] = Math.max(dp[i], myList.get(i).mult + dp[i-2]);
            }
            if (i >= 1 && nextPosMap.get(i-1) <= i) {
                dp[i] = Math.max(dp[i], myList.get(i).mult + dp[i-1]);
            }

            ret = Math.max(ret, dp[i]);

            if (i >= 3)
                dp[i-2] = Math.max(dp[i-3], dp[i-2]);
        }
        
        return ret;
    }
}
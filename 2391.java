class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int[] travelPrefixSum = new int[travel.length];
        int sum = 0;

        for (int i = 0; i < travel.length; i++) {
            sum += travel[i];
            travelPrefixSum[i] = sum;
        }

        int metalCount = 0;
        int lastMetalIndex = -1;
        int paperCount = 0;
        int lastPaperIndex = -1;
        int glassCount = 0;
        int lastGlassIndex = -1;

        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];

            int houseMetalCount = 0;
            int housePaperCount = 0;
            int houseGlassCount = 0;

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);

                if (c == 'M') {
                    houseMetalCount++;
                }
                else if (c == 'P') {
                    housePaperCount++;
                }
                else {
                    houseGlassCount++;
                }
            }

            if (houseMetalCount > 0) {
                lastMetalIndex = i;
            }
            if (housePaperCount > 0) {
                lastPaperIndex = i;
            }
            if (houseGlassCount > 0) {
                lastGlassIndex = i;
            }

            metalCount += houseMetalCount;
            paperCount += housePaperCount;
            glassCount += houseGlassCount;
        }

        int ret = 0;
        ret += metalCount;
        ret += paperCount;
        ret += glassCount;
        if (lastMetalIndex >= 1)
            ret += travelPrefixSum[lastMetalIndex-1];
        if (lastPaperIndex >= 1)
            ret += travelPrefixSum[lastPaperIndex-1];
        if (lastGlassIndex >= 1)
            ret += travelPrefixSum[lastGlassIndex-1];

        return ret;
    }
}
class Solution {
    public int numberOfBeams(String[] bank) {
        int prevDevices = 0;
        int ret = 0;

        for (int i = 0; i < bank.length; i++) {
            int curDevices = 0;

            for (int j = 0; j < bank[i].length(); j++) {
                char c = bank[i].charAt(j);

                if (c == '1') {
                    curDevices++;
                }
            }

            ret += curDevices * prevDevices;
            if (curDevices != 0)
                prevDevices = curDevices;
        }

        return ret;
    }
}
class Solution {
    public int convertTime(String current, String correct) {
        int res = 0;

        String curHours = current.substring(0, 2);
        String curMins = current.substring(3, 5);
        String corHours = correct.substring(0, 2);
        String corMins = correct.substring(3, 5);


        int curHoursInt = Integer.parseInt(curHours);
        int corHoursInt = Integer.parseInt(corHours);
        int curMinsInt = Integer.parseInt(curMins);
        int corMinsInt = Integer.parseInt(corMins);

        if (curMinsInt > corMinsInt) {
            res--;
            corMinsInt += 60;
        }
        res += Integer.parseInt(corHours) - Integer.parseInt(curHours);
        int minsDiff = corMinsInt - curMinsInt;

        if (minsDiff / 15 >= 1) {
            int val = minsDiff / 15;
            curMinsInt += val * 15;
            minsDiff -= val * 15;
            res += val;
        }
        if (minsDiff / 5 >= 1) {
            int val = minsDiff / 5;
            curMinsInt += val * 5;
            minsDiff -= val * 5;
            res += val;
        }
        int val = minsDiff;
        curMinsInt += val;
        res += val;

        return res;

    }
}
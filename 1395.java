class Solution {
    public int numTeams(int[] rating) {
        int[] ctGreaterThanCurToRight = new int[rating.length];
        int[] ctLesserThanCurToRight = new int[rating.length];

        for (int i = 0; i < rating.length; i++) {
            int x = rating[i];
            int ctGreater = 0;
            int ctLesser = 0;

            for (int j = i+1; j < rating.length; j++) {
                ctGreater += rating[j] > rating[i] ? 1 : 0;
                ctLesser += rating[j] < rating[i] ? 1 : 0;
            }

            ctGreaterThanCurToRight[i] = ctGreater;
            ctLesserThanCurToRight[i] = ctLesser;
        }

        int ret = 0;

        for (int i = 0; i < rating.length; i++) {
            int first = rating[i];

            for (int j = i+1; j < rating.length; j++) {
                int second = rating[j];

                if (first < second) {
                    ret += ctGreaterThanCurToRight[j];
                }
                else if (first > second) {
                    ret += ctLesserThanCurToRight[j];
                }
            }
        }

        return ret;
    }
}
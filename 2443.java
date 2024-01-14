class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            int numCopy = i;
            int reverse = 0;

            while (numCopy != 0) {
                reverse = (10 * reverse) + (numCopy % 10);
                numCopy /= 10;
            }

            //System.out.println("i : " + i + " reverse: " + reverse);

            if (i + reverse == num)
                return true;
        }

        return false;
    }
}
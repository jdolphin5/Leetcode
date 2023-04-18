class Solution {
    public boolean isHappy(int n) {
        
        //put result in hash table
        //if that number has been reached previously, return false
        List<Integer> previous = new ArrayList<Integer>();

        while (n != 1) {
            if (previous.contains(n)) {
                return false;
            }
            previous.add(n);
            /*
            String number = String.valueOf(n);
            char[] digits = number.toCharArray();
            int[] myNums = new int[digits.length];
            int runningSquaredSum = 0;

            for (int i = 0; i < digits.length; i++) {
                myNums[i] = Character.getNumericValue(digits[i]);
                runningSquaredSum += myNums[i] * myNums[i];
                System.out.println(myNums[i]);
            }
            */
            int runningSquaredSum = 0;
            while (n != 0) {
                int temp = n % 10;
                runningSquaredSum += temp * temp;
                n = n/10;
            }
            n = runningSquaredSum;
        }
    return true;
    }
}
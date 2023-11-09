class Solution {
    public int minimizeXor(int num1, int num2) {
        int numBitsSetNum2 = Integer.bitCount(num2);
        int numBitsSetNum1 = Integer.bitCount(num1);

        int tempNum1 = num1;
        int x = 0;
        int i = 1;

        while (tempNum1 > 0 && numBitsSetNum2 > 0) {
            int cur = tempNum1 & 1;
            tempNum1 = tempNum1 >> 1;

            if (cur == 1 && numBitsSetNum2 >= numBitsSetNum1) {
                System.out.println(i);
                numBitsSetNum2--;
                numBitsSetNum1--;
                x += cur << (i-1);
            }
            else if (cur == 1) {
                numBitsSetNum1--;
            }

            i++;
        }

        tempNum1 = num1;
        i = 1;

        while (numBitsSetNum2 > 0) {
            int cur = tempNum1 & 1;
            tempNum1 = tempNum1 >> 1;

            if (cur == 0) {
                numBitsSetNum2--;
                x += 1 << (i-1);
            }

            i++;
        }
        
        return x;
    }
}
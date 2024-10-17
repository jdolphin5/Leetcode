class Solution {
    public int maximumSwap(int num) {
        int[] numArr = new int[10];
        int i = 0;

        if (num == 0)
            return 0;

        while (num > 0) {
            numArr[i++] = num % 10;
            num /= 10;
        }

        int firstIndex = i-1;
        int x = firstIndex;

        while (x > 0) {
            int max = 0;
            int maxIndex = -1;
            
            for (int j = 0; j < x; j++) {
                if (numArr[j] > max) {
                    max = numArr[j];
                    maxIndex = j;
                }
            }

            if (max > numArr[x]) {
                int temp = numArr[maxIndex];
                numArr[maxIndex] = numArr[x];
                numArr[x] = temp;
                break;
            }

            x--;
        }

        int ret = 0;

        while (firstIndex >= 0) {
            ret *= 10;
            ret += numArr[firstIndex--];
        }

        return ret;
    }
}
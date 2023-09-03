class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ret = 0;
        for (int i = low; i <= high; i++) {
            int digits = 0;
            int x = i;
            List<Integer> digitsList = new ArrayList<>();
            while (x > 0) {
                digits++;
                digitsList.add(x % 10);
                x /= 10;
            }
            if (digits % 2 == 0) {
                int firstSum = 0;
                int lastSum = 0;
                for (int j = 0; j < digitsList.size()/2; j++) {
                    firstSum += digitsList.get(j);
                    lastSum += digitsList.get(digitsList.size()-1-j);
                }
                if (firstSum == lastSum) ret++;
            }
        }
        
        return ret;
    }
}
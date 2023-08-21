class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        int i = 1;

        while(true) {
            int[] curArr = arr.clone();
            boolean found = true;

            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    arr[j] = curArr[(j)/2];
                }
                else {
                    arr[j] = curArr[(n/2)+((j)/2)];
                }

                if (j != arr[j]) found = false;
            }

            if (found) break;
            
            i++;
        }

        return i;
    }
}
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int i = 0;
        int j = 0;
        int sum = 0;
        ArrayList<int[]> possibleFirstLen = new ArrayList<>();
        ArrayList<int[]> possibleSecondLen = new ArrayList<>();
        int maxLen = 0;

        while (j < firstLen) {
            sum += nums[j];
            j++;
        }
        possibleFirstLen.add(new int[] {i, j-1, sum});

        while (j < nums.length) {
            sum -= nums[i];
            sum += nums[j];
            i++;
            j++;
            possibleFirstLen.add(new int[] {i, j-1, sum});
        }

        i = 0;
        j = 0;
        sum = 0;

        while (j < secondLen) {
            sum += nums[j];
            j++;
        }
        possibleSecondLen.add(new int[] {i, j-1, sum});

        while (j < nums.length) {
            sum -= nums[i];
            sum += nums[j];
            i++;
            j++;
            possibleSecondLen.add(new int[] {i, j-1, sum});
        }

        for (i = 0; i < possibleFirstLen.size(); i++) {
            int[] arr1 = possibleFirstLen.get(i);
            for (j = 0; j < possibleSecondLen.size(); j++) {
                int[] arr2 = possibleSecondLen.get(j);
                if (arr1[0] > arr2[1] || arr2[0] > arr1[1]) {
                    if (arr1[2] + arr2[2] > maxLen) {
                        maxLen = arr1[2] + arr2[2];
                    }
                }
            }
        }

        return maxLen;

    }
}
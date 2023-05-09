class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length-1;

        int result = 0;
        int runningCapacityA = capacityA;
        int runningCapacityB = capacityB;

        while (i <= j) {
            if (i == j) {
                runningCapacityA = Math.max(runningCapacityA, runningCapacityB);
                if (plants[i] > runningCapacityA) result++;
                break;
            }
            if (runningCapacityA < plants[i]) {
                result++;
                runningCapacityA = capacityA - plants[i];
            }
            else {
                runningCapacityA -= plants[i];
            }
            i++;
            if (runningCapacityB < plants[j]) {
                result++;
                runningCapacityB = capacityB - plants[j];
            }
            else {
                runningCapacityB -= plants[j];
            }
            j--;
        }
        return result;
    }
}
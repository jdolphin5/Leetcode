/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
 class Solution {
    private int findPeak(MountainArray mountainArr, int lower, int upper, int len) {
        if (lower == upper) {
            return lower;
        }

        int mid = lower + (upper - lower) / 2;
        int val = mountainArr.get(mid);

        int left = -1;
        int right = -1;

        if (mid-1 >= 0) {
            left = mountainArr.get(mid-1);
        }
        if (mid+1 <= len-1) {
            right = mountainArr.get(mid+1);
        }

        if (left > val) {
            //go left
            return findPeak(mountainArr, lower, mid, len);
        }
        else if (right > val) {
            //go right
            return findPeak(mountainArr, mid+1, upper, len);
        }
        else if (left == right) {
            //try left and right and return greatest peak
            int leftPeak = findPeak(mountainArr, lower, mid, len);
            int rightPeak = findPeak(mountainArr, mid+1, upper, len);
            if (mountainArr.get(leftPeak) < mountainArr.get(rightPeak)) {
                return rightPeak;
            }
            else {
                return leftPeak;
            }
        }
        else {
            //peak has been found because both left and right of this index are smaller values
            return mid;
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();

        int lower = 0;
        int upper = len;

        int peak = findPeak(mountainArr, lower, upper, len);

        //left of peak
        upper = peak;
        lower = 0;
        int lastVal = 0;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int val = mountainArr.get(mid);
            if (val < target) {
                lower = mid+1;
            }
            else {
                lastVal = val;
                upper = mid;
            }
        }

        if (lastVal == target) {
            return lower;
        }

        //right of peak
        lower = peak;
        upper = len;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int val = mountainArr.get(mid);
            if (val > target) {
                lower = mid+1;
            }
            else if (val < target) {
                upper = mid;
            }
            else {
                upper = mid;
                lastVal = val;
            }
        }

        //return -1 if cannot find target in the left or right side of the peak
        if (lastVal != target) {
            return -1;
        }

        return lower;
    }
}
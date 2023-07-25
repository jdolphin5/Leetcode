class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int upper = arr.length-1;
        int lower = 0;
        int lowerMid = 0;
        int upperMid = 0;
    
        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            int midVal = arr[mid];
            lowerMid = lower + (mid - lower) / 2;
            upperMid = mid + (upper - mid) / 2;
            //System.out.println("mid: " + mid);
            //System.out.println("lower: " + lower + " upper: " + upper);
            //System.out.println("lowerMid: " + lowerMid + " upperMid: " + upperMid);
            if (arr[lowerMid] >= midVal) {
                upper = mid;
            }
            if (arr[upperMid] >= midVal) {
                lower = mid;
            }
            else if (arr[lowerMid] < midVal && arr[upperMid] < midVal) {
                lower++;
                upper--;
            }
        }
        return lower;
    }
}

//[1,2,3,4,5,4,3,1]
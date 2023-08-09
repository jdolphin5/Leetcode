class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lower = 0;
        int upper = arr.length-1;

        while (lower < upper) {
            int mid = lower + (upper - lower) / 2;
            if (arr[mid] < x) {
                lower = mid+1;
            }
            else {
                upper = mid;
            }
        }

        List<Integer> ret = new ArrayList<>();

        int i = lower-1;
        int j = lower;
        while (k > 0) {
            if (i >= 0 && j <= arr.length-1) {
                int a = Math.abs(x - arr[i]);
                int b = Math.abs(x - arr[j]);
                if (a < b) {
                    ret.add(arr[i]);
                    i--;
                }
                else if (b < a) {
                    ret.add(arr[j]);
                    j++;
                }
                else {
                    ret.add(arr[i]);
                    i--;
                }
            }
            else if (i >= 0) {
                ret.add(arr[i]);
                i--;
            }
            else if (j <= arr.length-1) {
                ret.add(arr[j]);
                j++;
            }
            k--;
        }
        Collections.sort(ret);
        return ret;
    }
}
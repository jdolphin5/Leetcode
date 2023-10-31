class Solution {
    /*
    
    pref[0] = arr[0];
    pref[1] = arr[0] ^ arr[1];
    pref[2] = arr[0] ^ arr[1] ^ arr[2];
    arr[0] = pref[0];
    arr[1] = pref[1] ^ arr[0];
    arr[2] = pref[2] ^ arr[1] ^ arr[0];
    arr[2] = pref[2] ^ pref[1] ^ arr[0] ^ arr[0];
           = pref[2] ^ pref[1];
    arr[3] = pref[3] ^ arr[2] ^ arr[1] ^ arr[0];
           = pref[3] ^ pref[2] ^ pref[1] ^ pref[1] ^ arr[0] ^ arr[0];
           = pref[3] ^ pref[2];

    (^ XOR on both sides to cancel as a XOR a == 0)
    */
    public int[] findArray(int[] pref) {
        int[] ret = new int[pref.length];

        ret[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            ret[i] = pref[i] ^ pref[i-1];
        }

        return ret;
    }
}
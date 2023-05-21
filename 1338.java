class Solution {
    private int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        return arr;
    }

    public int minSetSize(int[] arr) {
        int size = arr.length;
        int count = 0;
        int[] freq = new int[100001];

        for (int num : arr) {
            freq[num]++;
        }
        Arrays.sort(freq);
        freq = reverse(freq);
        int i = 0;
        while (i < freq.length && freq[i] > 0) {
            if (count < size/2) {
                count += freq[i];
                i++;
            } 
            else {
                break;
            }
        }
        return i;
    }
}
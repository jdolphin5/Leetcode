class Solution {
    private boolean meetsVowelCondition(int[] arr) {
        if (arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1 && arr[3] >= 1 && arr[4] >= 1) {
            return true;
        }

        return false;
    }

    private void alterArr(int[] arr, char c, int weight) {
        // a, e, i, o, u, consonant
        switch (c) {
            case 'a':
                arr[0] += weight;
                break;
            case 'e':
                arr[1] += weight;
                break;
            case 'i':
                arr[2] += weight;
                break;
            case 'o':
                arr[3] += weight;
                break;
            case 'u':
                arr[4] += weight;
                break;
            default:
                arr[5] += weight;
        }
    }

    public int countOfSubstrings(String word, int k) {
        int ret = 0;

        for (int i = 0; i < word.length(); i++) {
            int[] arr = new int[6];

            for (int j = i; j < word.length(); j++) {
                alterArr(arr, word.charAt(j), 1);

                if (meetsVowelCondition(arr) && arr[5] == k)
                    ret++;
            }
        }

        return ret;
    }
}
class Solution {
    private boolean checkEmployeeCounts(int[] arr) {
        for (int num : arr) {
            if (num < 0) return false;
        }

        return true;
    }

    private int recur(int n, int[] employeeCountArr, int[][] requests, int i) {
        if (i == requests.length) {
            if (checkEmployeeCounts(employeeCountArr))
                return 0;
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        for (int x = i; x < requests.length; x++) {
            employeeCountArr[requests[x][0]]--;
            employeeCountArr[requests[x][1]]++;
            ans = Math.max(ans, 1 + recur(n, employeeCountArr, requests, x+1));
            employeeCountArr[requests[x][0]]++;
            employeeCountArr[requests[x][1]]--;
        }

        ans = Math.max(ans, recur(n, employeeCountArr, requests, i+1));

        return ans;
    }

    public int maximumRequests(int n, int[][] requests) {
        int[] employeeCountArr = new int[n];

        return recur(n, employeeCountArr, requests, 0);
    }
}
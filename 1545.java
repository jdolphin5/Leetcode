class Solution {
    public char findKthBit(int n, int k) {


        StringBuilder res = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                res.append("0");
            }
            else {
                StringBuilder res2 = new StringBuilder();
                for (int j = 0; j < res.length(); j++) {
                    if (res.charAt(res.length()-j-1) == '1') {
                        res2.append("0");
                    }
                    else {
                        res2.append("1");
                    }
                }
                res.append("1");
                res.append(res2);

            }
        }
        //System.out.println(res);
        return res.charAt(k-1);
    }
}
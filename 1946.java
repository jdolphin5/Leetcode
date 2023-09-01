class Solution {
    public String maximumNumber(String num, int[] change) {
        boolean firstChange = false;
        int x = 0, j = 0; //change digits from index x to index j
        StringBuilder ret = new StringBuilder();
        
        for (int i = 0; i < num.length(); i++) {
            int cur = Character.getNumericValue(num.charAt(i));
            
            if (cur == change[cur] && firstChange) {
                j = i;
            }
            else if (cur < change[cur]) {
                j = i;
                firstChange = true;
            }
            else if (!firstChange) {
                x++;
            }
            else {
                break;
            }
        }

        //prefix of string that is same as num
        ret.append(num.substring(0, x));
        
        //part of num which will be changed to digits in change[]
        for (int i = x; i <= j; i++) {
            int c = Character.getNumericValue(num.charAt(i));
            ret.append(change[c]);
        }

        //suffix of string that is same as num - only need to include if there are some digits changed
        if (j >= x)
            ret.append(num.substring(j+1, num.length()));

        return new String(ret);
    }
}
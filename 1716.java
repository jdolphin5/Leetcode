class Solution {
    public int totalMoney(int n) {
        int i = 0;
        int count = 0;
        int base = 1;
        while (i < n) {
            if (i > 0 && i % 7 == 0) {
                base++;
            }
            count += (base+(i%7));
            i++;
            //System.out.println(count);
        }
        return count;
    }
}
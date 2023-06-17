class Solution {
    public int findComplement(int num) {
        int allOnes = (int)Math.floor(Math.log(num) / Math.log(2) + 1);
        int mask = (1 << allOnes) - 1;

        return ~num & mask;
    }
}
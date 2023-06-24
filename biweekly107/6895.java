class Solution {
    public int longestString(int x, int y, int z) {
        //x cant be before z
        //y cant be after z
        
        //if x is greater than or = y -> z,z,x,y,x,y,x,y
        //if x is less than y    -> y,x,y,x,y,x,z
        
        int ret = 0;
        
        ret += z*2;
        ret += Math.min(x,y)*4;
        if (x != y) ret += 2;
        
        return ret;
    }
}
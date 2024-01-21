private int gcd (int a, int b) {
    if (a % b == 0)
        return b;
    
    return gcd(b, a % b);
}

/*
 * To get Greatest Common Divisor of all elements of int[] nums
 *      
        int gcd = 0;
        
        for (int num : nums) {
            gcd = gcd(gcd, num);
        }
 * 
 */

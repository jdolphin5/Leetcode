class Solution {
    private double simplify(int a, int b) {
        double result = (double)a / (double)b;
        return result;
    }

    public List<String> simplifiedFractions(int n) {
        List<Double> visited = new ArrayList<>();
        List<String> result = new ArrayList<>();

        if (n == 1) return result;


        // i = denominator
        // j = numerator
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                double x = simplify(j, i);
                if (!visited.contains(x)) {
                    String res = "";
                    visited.add(x);
                    res += j + "/" + i;
                    result.add(res);
                }
            }
        }

        return result;
    }
}
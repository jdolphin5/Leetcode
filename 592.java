class Solution {
    private int gcd (int a, int b) {
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }

    private int[] addOrSubtract(boolean type, int[] total, int top, int bottom) {
        if (total[0] == 0 && total[1] == 0) {
            total[0] = top;
            total[1] = bottom;

            if (!type) {
                total[0] *= -1;
            }

            return total;
        }

        double num = 0;
        double denom = 0;

        int gcd = (gcd(total[1], bottom));
        int mul1 = total[1] / gcd;
        int mul2 = bottom / gcd;

        total[1] = total[1] * mul2;
        total[0] = total[0] * mul2;
        top = top * mul1;
        bottom = bottom * mul1;

        if (type) {
            //add
            total[0] += top;
        }
        else {
            total[0] -= top;
        }

        return total;
    }

    public String fractionAddition(String expression) {
        boolean numerator = true;
        boolean type = true;
        int[] total = new int[] {0, 0};
        int top = 0;
        int bottom = 0;
        boolean first = true;

        for (int i = 0; i < expression.length(); i++) {
            switch(expression.charAt(i)) {
                case '-':
                    total = addOrSubtract(type, total, top, bottom);
                    first = false;
                    type = false;
                    numerator = true;
                    top = 0;
                    bottom = 0;
                    break;
                case '+':
                    total = addOrSubtract(type, total, top, bottom);
                    first = false;
                    type = true;
                    numerator = true;
                    top = 0;
                    bottom = 0;
                    break;
                case '/':
                    numerator = false;
                    break;
                default:
                    if (numerator) {
                        top *= 10;
                        top += expression.charAt(i) - '0';
                    }
                    else {
                        bottom *= 10;
                        bottom += expression.charAt(i) - '0';
                    }
            }
        }

        total = addOrSubtract(type, total, top, bottom);

        //reduce to final fraction
        int gcd = gcd(Math.abs(total[0]), total[1]);
        total[0] /= gcd;
        total[1] /= gcd;

        return new String(String.valueOf(total[0]) + "/" + String.valueOf(total[1]));
    }
}
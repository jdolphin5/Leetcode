class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.charAt(0) == '#' && preorder.length() > 1) {
            return false;
        }

        boolean hasPassedComma = true;
        int toFill = 1;

        for (int i = 0; i < preorder.length(); i++) {
            if (preorder.charAt(i) == ',') {
                //comma
                hasPassedComma = true;
                continue;
            }

            //System.out.println(i + "toFill: " + toFill);

            toFill--;
            
            if (toFill < 0) {
                return false;
            }


            if (Character.isDigit(preorder.charAt(i))) {
                //digit
                toFill++; //to counter the dec every iteration
                if (hasPassedComma) {
                    toFill++;
                    hasPassedComma = false;
                }
            }
            else if (preorder.charAt(i) == '#') {
                //hash char
            }
        }

        return toFill == 0;
    }
}
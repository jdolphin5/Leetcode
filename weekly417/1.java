class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k + 1) {
            String newString = "";

            for (int i = 0; i < s.length(); i++) {
                int nextInt = s.charAt(i) - 'a' + 1;
                char nextChar = (char) (nextInt + 'a');

                if (s.charAt(i) == 'z') {
                    nextChar = 'a';
                }

                newString = newString + nextChar;
            }

            s = s + newString;
        }

        // System.out.println(s);

        return s.charAt(k - 1);
    }
}
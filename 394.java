class Solution {

    public String decodeString(String s) {

        Stack<Integer> counts = new Stack<Integer>();
        Stack<String> result = new Stack<String>();
        String res = "";
        int i = 0;

        while(i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int a = 0;
                while (Character.isDigit(s.charAt(i))) {
                    a = a * 10 + (s.charAt(i) - '0');
                    i++;
                }
                counts.push(a);
            } else if (s.charAt(i) == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                String temp = result.pop();
                int repeat = counts.pop();
                temp += res.repeat(repeat);
                res = temp;
                i++;
            } else { //letter
                res += s.charAt(i);
                i++;
            }
        }
        return res;

    }
}
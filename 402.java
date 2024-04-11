class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> myDeque = new ArrayDeque<>();
        char[] numArr = num.toCharArray();

        if (num.length() == 0) {
            return "";
        }

        for (int i = 0; i < numArr.length; i++) {
            char c = numArr[i];

            while (k > 0 && !myDeque.isEmpty() && c < myDeque.peekFirst()) {
                myDeque.removeFirst();
                k--;
            }

            myDeque.addFirst(c);
        }

        while (!myDeque.isEmpty() && k > 0) {
            myDeque.removeFirst();
            k--;
        }

        StringBuilder ret = new StringBuilder();

        while (!myDeque.isEmpty()) {
            ret.append(myDeque.removeLast());
        }

        while (ret.length() > 0 && ret.charAt(0) == '0') {
            ret.deleteCharAt(0);
        }

        return ret.length() == 0 ? "0" : ret.toString();
    }
}
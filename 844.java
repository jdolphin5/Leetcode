class Solution {
    public boolean backspaceCompare(String s, String t) {

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Stack<Character> sStack = new Stack<Character>();
        Stack<Character> tStack = new Stack<Character>();

        int i = 0;
        while (i < sArray.length) {
            if (sArray[i] == '#') {
                if (!sStack.isEmpty()) {
                    sStack.pop();
                }
            }
            else {
                sStack.push(sArray[i]);
            }
            i++;
        }

        int j = 0;
        while (j < tArray.length) {
            if (tArray[j] == '#') {
                if (!tStack.isEmpty()) {
                    tStack.pop();
                }
            }
            else {
                tStack.push(tArray[j]);
            }
            j++;
        }

        while(!sStack.isEmpty() && !tStack.isEmpty()) {
            if (sStack.peek() != tStack.peek()) return false;
            else {
                System.out.println(sStack.peek());
                System.out.println(tStack.peek());
                sStack.pop();
                tStack.pop();
            }
        }
        if (sStack.isEmpty() && tStack.isEmpty()) return true;
        return false;
    }
}
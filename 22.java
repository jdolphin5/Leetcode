class Solution {

    private void generate(int left, int right, List<String> myList, String myString, int n) {
        if (left+right == 2*n) {
            myList.add(myString);
            return;
        }

        if (left+1 <= n) {
            generate(left+1, right, myList, myString+"(", n);
        }
        if (right < left) {
            generate(left, right+1, myList, myString+")", n);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> myList = new ArrayList<>();
        generate(0, 0, myList, "", n);    
        return myList;    

    }
}
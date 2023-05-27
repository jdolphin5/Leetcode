class Solution {
    private void addPalToSet(String s, int i, int j, String curString, List<String> myList) {
        if (i < 0 || j < 0 || i >= s.length() || j >= s.length() || s.charAt(i) != s.charAt(j)) return;

        if (i == j) {
            curString += s.charAt(i);
        }
        else {
            curString = s.charAt(i) + curString + s.charAt(j);
        }

        myList.add(curString);
        addPalToSet(s, i-1, j+1, curString, myList);
        
    }

    public int countSubstrings(String s) {
        List<String> myList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            addPalToSet(s, i, i, "", myList);
            addPalToSet(s, i, i+1, "", myList);
        }

        return myList.size();
    }
}
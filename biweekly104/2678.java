class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (int i = 0; i < details.length; i++) {
            String myString = details[i].substring(11,13);
            System.out.println(myString);
            if (Integer.parseInt(myString) > 60) count++;
        }
        return count;
    }
}
class Solution {
    public int romanToInt(String s) {
        int count = 0;

        HashMap<Character,Integer> myMap = new HashMap();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        myMap.put('L', 50);
        myMap.put('C', 100);
        myMap.put('D', 500);
        myMap.put('M', 1000);

        char[] sArr = s.toCharArray();

        for (int i = 0; i < sArr.length; i++) {
            char next = '?';
            if (i+1 < sArr.length) {
                next = sArr[i+1];
            }
            if (sArr[i] == 'I' && (next == 'V' || next == 'X')) {
                count--;
            } else if (sArr[i] == 'X' && (next == 'L' || next == 'C')) count -= 10;
            else if (sArr[i] == 'C' && (next == 'D' || next == 'M')) count -= 100;
            else {
                count += myMap.get(sArr[i]);
            }
        }

        return count;
    }
}
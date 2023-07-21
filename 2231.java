class Solution {
    public int largestInteger(int num) {
        List<Integer> myList = new ArrayList<>();
        int ret = 0;
        int x = 0;
        int y = num;
        while (y != 0) {
            myList.add(y % 10);
            y /= 10;
        }
        Collections.reverse(myList);
        for (int i = 0; i < myList.size(); i++) {
            for (int j = i+1; j < myList.size(); j++) {
                int a = myList.get(i);
                int b = myList.get(j);
                if (b > a && (b - a) % 2 == 0) { //parity is equal (both odd or both even)
                    myList.remove(i);
                    myList.add(i, b);
                    myList.remove(j);
                    myList.add(j, a);
                }
            }
        }
        for (int i = myList.size()-1; i >= 0; i--) {
            ret += myList.get(i)*Math.pow(10, (myList.size()-1-i));
        }
        return ret;
    }
}
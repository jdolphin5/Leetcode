class Solution {
    public class Item {
        double val;
        int numerator;
        int denominator;

        public Item (double a, int b, int c) {
            this.val = a;
            this.numerator = b;
            this.denominator = c;
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<Item> arrList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                arrList.add(new Item((double)arr[i] / arr[j], arr[i], arr[j]));
            }
        }

        Collections.sort(arrList, (a, b) -> Double.compare(a.val, b.val));

        Item retItem = arrList.get(k-1);

        return new int[] { retItem.numerator, retItem.denominator };
    }
}
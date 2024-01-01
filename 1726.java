class Solution {

    public class Tuple {
        int a;
        int b;
        int prod;

        public Tuple(int a, int b, int prod) {
            this.a = a;
            this.b = b;
            this.prod = prod;
        }
    }

    public int tupleSameProduct(int[] nums) {
        List<Tuple> myList = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                myList.add(new Tuple(nums[i], nums[j], nums[i] * nums[j]));
            }
        }

        Collections.sort(myList, (a, b) -> a.prod - b.prod);
        int ret = 0;

        for (int i = 0; i < myList.size(); i++) {
            int j = i+1;
            Tuple x = myList.get(i);

            while (j < myList.size() && myList.get(j).prod == x.prod) {
                Tuple y = myList.get(j);
                if (x.a != x.b && x.a != y.a && x.a != y.b && x.b != y.a && x.b != y.b && y.a != y.b) {
                    ret += 8;
                }
                j++;
            }
        }

        return ret;
    }
}
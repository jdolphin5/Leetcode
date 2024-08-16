class Solution {
    class Value {
        int val;
        int arrIndex;

        public Value(int val, int arrIndex) {
            this.val = val;
            this.arrIndex = arrIndex;
        }
    }

    public int maxDistance(List<List<Integer>> arrays) {
        List<Value> myList = new ArrayList<>();

        for (int i = 0; i < arrays.size(); i++) {
            for (int x : arrays.get(i)) {
                myList.add(new Value(x, i));
            }
        }

        Value lowest = new Value(Integer.MAX_VALUE, -1);
        Value secondLowest = new Value(Integer.MAX_VALUE, -1);
        Value highest = new Value(Integer.MIN_VALUE, -1);
        Value secondHighest = new Value(Integer.MIN_VALUE, -1);

        for (int i = 0; i < myList.size(); i++) {
            Value v = myList.get(i);

            if (v.val < lowest.val) {
                if (lowest.val != Integer.MAX_VALUE && v.arrIndex != lowest.arrIndex) {
                    secondLowest = lowest;
                }

                lowest = v;
            }
            else if (v.arrIndex != lowest.arrIndex && (secondLowest.val == Integer.MAX_VALUE || v.val < secondLowest.val)) {
                secondLowest = v;
            }

            if (v.val > highest.val) {
                if (highest.val != Integer.MIN_VALUE && v.arrIndex != highest.arrIndex) {
                    secondHighest = highest;
                }

                highest = v;
            }
            else if (v.arrIndex != highest.arrIndex && (secondHighest.val == Integer.MIN_VALUE || v.val > secondHighest.val)) {
                secondHighest = v;
            }
        }

        int ret = 0;

        if (lowest.arrIndex == highest.arrIndex) {
            ret = Math.max(Math.abs(secondHighest.val - lowest.val), Math.abs(highest.val - secondLowest.val));
        }
        else {
            ret = Math.abs(highest.val - lowest.val);
        }

        return ret;
    }
}
class Solution {
    public class CustomerWhenGrumpy {
        int count;
        int index;

        public CustomerWhenGrumpy (int count, int index) {
            this.count = count;
            this.index = index;
        }

        public String toString() {
            return "count : " + count + " index: " + index;
        }
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int alwaysSatisfied = 0;
        List<CustomerWhenGrumpy> notSatisfied = new ArrayList<>();

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1 && customers[i] > 0) {
                notSatisfied.add(new CustomerWhenGrumpy(customers[i], i));
            }
            else if (grumpy[i] == 0) {
                alwaysSatisfied += customers[i];
            }
        }

        //System.out.println(notSatisfied.toString());

        int maxSatisfied = 0;

        for (int i = 0; i < notSatisfied.size(); i++) {
            int ct = 0;
            int index = notSatisfied.get(i).index;
            int j = i;

            while (j < notSatisfied.size()) {
                index = notSatisfied.get(j).index;
                if (index >= notSatisfied.get(i).index + minutes)
                    break;
                ct += notSatisfied.get(j).count;
                j++;
            }

            //System.out.println("I: " + i + " ct: " + ct);

            maxSatisfied = Math.max(maxSatisfied, ct);
        }

        return maxSatisfied + alwaysSatisfied;
    }
}
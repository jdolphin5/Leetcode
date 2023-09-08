class Solution {
    public class Element {
        int index;
        int value;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public long findScore(int[] nums) {
        Element[] eles = new Element[nums.length];
        boolean[] marked = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            eles[i] = new Element(i, nums[i]);
        }

        Arrays.sort(eles, (a, b) -> a.value == b.value ? a.index - b.index : a.value - b.value);

        int markedCount = 0;
        int i = 0;
        long ret = 0;

        while (markedCount < nums.length) {
            int elementIndex = eles[i].index;

            if (marked[elementIndex] == false) {
                marked[elementIndex] = true;
                markedCount++;
                ret += eles[i].value;

                if (elementIndex > 0 && marked[elementIndex-1] == false) {
                    marked[elementIndex-1] = true;
                    markedCount++;
                }
                if (elementIndex < nums.length-1 && marked[elementIndex+1] == false) {
                    marked[elementIndex+1] = true;
                    markedCount++;
                }
            }
            
            i++;
        }

        return ret;
    }
}
class Solution {
    public class OrderObj {
        char c;
        int weight;

        public OrderObj(char c, int weight) {
            this.c = c;
            this.weight = weight;
        }
    }

    public String customSortString(String order, String s) {
        Map<Character, Integer> orderMap = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        StringBuilder ret = new StringBuilder();
        OrderObj[] orderArr = new OrderObj[s.length()];

        for (int i = 0; i < s.length(); i++) {
            orderArr[i] = new OrderObj(s.charAt(i), orderMap.getOrDefault(s.charAt(i), -1));
        }

        Arrays.sort(orderArr, (a, b) -> a.weight - b.weight);

        for (int i = 0; i < orderArr.length; i++) {
            ret.append(orderArr[i].c);
        }

        return new String(ret);
    }
}
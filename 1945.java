class Solution {
    public int getLucky(String s, int k) {
        List<Integer> numsList = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            numsList.add(s.charAt(i)-'a'+1);
        }

        while (k-- > 0) {
            int num = 0;

            for (int number : numsList) {
                while (number != 0) {
                    num += number % 10;
                    number /= 10;
                }
            }

            if (k == 0) {
                return num;
            }

            numsList = new ArrayList<>();

            while (num != 0) {
                numsList.add(num % 10);
                num /= 10;
            }
        }

        return -1;
    }
}
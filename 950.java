class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> myDeque = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            myDeque.addFirst(i);
        }

        boolean reveal = true;
        int[] orderArr = new int[deck.length];
        int i = 0;

        while (!myDeque.isEmpty()) {
            if (reveal)
                orderArr[myDeque.removeFirst()] = i++;
            else
                myDeque.addLast(myDeque.removeFirst());
            reveal = !reveal;
        }

        int[] ret = new int[deck.length];

        for (int j = 0; j < deck.length; j++) {
            ret[j] = deck[orderArr[j]];
        }

        return ret;
    }
}
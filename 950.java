class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Map<Integer, Integer> indexToValMap = new HashMap<>();
        Arrays.sort(deck);
        //System.out.println(Arrays.toString(deck));

        for (int i = 0; i < deck.length; i++) {
            indexToValMap.put(i, deck[i]);
        }

        Deque<Integer> myDeque = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            myDeque.addFirst(i);
        }

        boolean reveal = true;
        Map<Integer, Integer> orderMap = new HashMap<>();

        int i = 0;

        while (!myDeque.isEmpty()) {
            if (reveal)
                orderMap.put(myDeque.removeFirst(), i++);
            else
                myDeque.addLast(myDeque.removeFirst());
            reveal = !reveal;
        }

        int[] ret = new int[deck.length];

        for (int j = 0; j < deck.length; j++) {
            ret[j] = indexToValMap.get(orderMap.get(j));
        }

        return ret;
    }
}
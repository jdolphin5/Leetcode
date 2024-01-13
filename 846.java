class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> cardValueCountTreeMap = new TreeMap<>();
        int cardCount = 0;

        for (int num : hand) {
            cardValueCountTreeMap.put(num, cardValueCountTreeMap.getOrDefault(num, 0) + 1);
            cardCount++;
        }

        if (cardCount % groupSize != 0) return false;

        while(true) {
            Integer minVal = cardValueCountTreeMap.firstKey();
            int minValCount = cardValueCountTreeMap.get(minVal);
            cardValueCountTreeMap.remove(minVal);

            for (int i = 1; i < groupSize; i++) {
                if (cardValueCountTreeMap.getOrDefault(minVal+i, 0) < minValCount)
                    return false;

                cardValueCountTreeMap.put(minVal+i, cardValueCountTreeMap.get(minVal+i) - minValCount);

                if (cardValueCountTreeMap.get(minVal+i) == 0)
                    cardValueCountTreeMap.remove(minVal+i);
            }

            if (cardValueCountTreeMap.size() == 0) return true;
        }
    }
}
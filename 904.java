class Solution {
    public int totalFruit(int[] fruits) {
        int fruitA = -1;
        int fruitB = -1;
        int lastFruitAIndex = 0;
        int lastFruitBIndex = 0;

        int i = 0;
        int j = 0;

        int ret = 0;

        while (j < fruits.length) {
            if (fruitA == -1) {
                fruitA = fruits[j];
            }
            else if (fruits[j] != fruitA && fruitB == -1) {
                fruitB = fruits[j];
            }

            if (fruitA == fruits[j]) {
                lastFruitAIndex = j;
            }
            else if (fruitB == fruits[j]) {
                lastFruitBIndex = j;
            }

            if (fruits[j] != fruitA && fruits[j] != fruitB) {
                if (lastFruitAIndex > lastFruitBIndex) {
                    i = lastFruitBIndex+1;
                    fruitB = fruits[j];
                    lastFruitBIndex = j;
                }
                else {
                    fruitA = fruitB;
                    i = lastFruitAIndex+1;
                    lastFruitAIndex = lastFruitBIndex;
                    lastFruitBIndex = j;
                    fruitB = fruits[j];
                }
            }
            else {
                ret = Math.max(ret, j - i + 1);
                j++;
            }
        }

        return ret;
    }
}
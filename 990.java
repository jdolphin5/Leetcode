class Solution {
    private int find(int i, int[] letters) {
        List<Integer> paths = new ArrayList<>();

        //walk up to parent
        while (letters[i] > 0) {
            paths.add(i);
            i = letters[i]; //will point to parent when break
        }

        //path compression
        for (Integer path : paths) {
            letters[path] = i;
        }

        return i;
    }

    private void union(int i, int j, int[] letters) {
        int iParent = find(i, letters);
        int jParent = find(j, letters);

        if (iParent != jParent)
            letters[iParent] = jParent;
    }

    public boolean equationsPossible(String[] equations) {
        
        int[] letters = new int[26];
        Arrays.fill(letters, -1);

        for (String s : equations) { //group the equal chars first
            char a = s.charAt(0);
            int x = a-'a';
            char b = s.charAt(3);
            int y = b-'a';

            char op = s.charAt(1);
            if (op == '=') {
                union(x, y, letters);
            }
        }
        for (String s : equations) { //check if unequal pairs are in the same group
            char a = s.charAt(0);
            int x = a-'a';
            char b = s.charAt(3);
            int y = b-'a';
            char op = s.charAt(1);

            if (op == '!') {
                if (find(x, letters) == find(y, letters)) {
                    return false;
                }
            }
        }

        return true;
    }
}
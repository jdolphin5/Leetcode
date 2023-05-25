class Solution {

    private int find(int i, int[] letters) {
        List<Integer> paths = new ArrayList();

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

        //System.out.println("i: " + i + " j: " + j + " iParent: " + iParent + " jParent: " + jParent);

        if (iParent < jParent)
            letters[iParent] = jParent;
        else if (iParent > jParent)
            letters[jParent] = iParent;
    }


    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] letters = new int[s.length()];
        boolean[] visited = new boolean[s.length()];
        Arrays.fill(letters, -1);
        StringBuilder res = new StringBuilder(s);

        for (List<Integer> myList : pairs) {
            union(myList.get(0), myList.get(1), letters);
        }

        Map<Integer, List<Integer>> parentMap = new HashMap<>();

        for (int i = 0; i < letters.length; i++) {
            int parent = find(i, letters);
            List<Integer> myList = parentMap.getOrDefault(parent, new ArrayList<>());
            myList.add(i);
            parentMap.put(parent, myList);
        }

        for (Map.Entry<Integer, List<Integer>> entry : parentMap.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            Collections.sort(value);
            PriorityQueue<Character> charQ = new PriorityQueue<>();
            for (Integer num : value) {
                charQ.offer(s.charAt(num));
            }

            for (Integer i = 0; i < value.size(); i++) {
                char c = charQ.poll();
                res.setCharAt(value.get(i), c);
            }
        }

        return res.toString();

    }
}
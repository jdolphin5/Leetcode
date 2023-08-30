class Solution {
    class IndexedString {
        int index;
        String str;

        IndexedString(int index, String str) {
            this.index = index;
            this.str = str;
        }
    }

    public String arrangeWords(String text) {
        PriorityQueue<IndexedString> pq = new PriorityQueue<>((a, b) -> a.str.length() == b.str.length() ? Integer.compare(a.index, b.index) : a.str.length() - b.str.length());

        StringBuilder word = new StringBuilder();
        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (i == 0) {
                c = Character.toLowerCase(c);
                word.append(c);
            }
            else if (c == ' ') {
                pq.offer(new IndexedString(i, new String(word)));
                word = new StringBuilder();
            }
            else {
                word.append(c);
            }
        }
        
        if (word.length() > 0) {
            pq.offer(new IndexedString(text.length(), new String(word)));
        }

        int i = 0;
        boolean last = false;
        
        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                last = true;
            }

            IndexedString indexedString = pq.poll();
            String wordToAdd = indexedString.str;

            if (i == 0) {
                wordToAdd = Character.toUpperCase(wordToAdd.charAt(0)) + wordToAdd.substring(1, wordToAdd.length());
                i++;
            }

            ret.append(wordToAdd);
            
            if (!last) {
                ret.append(" ");
            }
        }

        return new String(ret);
    }
}
class WordFilter {
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
     
    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        List<Integer> wordIndices = new ArrayList<>();
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
      
    static TrieNode rootForward;
    static TrieNode rootBackward;
     
    // If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node
    static void insert1(String key, int indexOfWord)
    {
        int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = rootForward;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
            pCrawl.wordIndices.add(indexOfWord);
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    static void insert2(String key, int indexOfWord)
    {
        int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = rootBackward;
      
        for (level = length-1; level >= 0; level--)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
            pCrawl.wordIndices.add(indexOfWord);
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
      
    // Returns true if key presents in trie, else false
    
    static int search(String key1, String key2)
    {
        int level;
        int length = key1.length();
        int index;
        TrieNode pCrawl = rootForward;
      
        for (level = 0; level < length; level++)
        {
            index = key1.charAt(level) - 'a';
      
            if (pCrawl.children[index] == null)
                return -1;
      
            pCrawl = pCrawl.children[index];
        }

        int level2;
        int length2 = key2.length();
        int index2;
        TrieNode pCrawl2 = rootBackward;
      
        for (level2 = length2-1; level2 >= 0; level2--)
        {
            index2 = key2.charAt(level2) - 'a';
      
            if (pCrawl2.children[index2] == null)
                return -1;
      
            pCrawl2 = pCrawl2.children[index2];
        }


        //System.out.println(pCrawl.wordIndices.toString());
        //System.out.println(pCrawl2.wordIndices);

        for (int i = 0; i < pCrawl.wordIndices.size(); i++) {
            if (pCrawl2.wordIndices.contains(pCrawl.wordIndices.get(i))) {
                return pCrawl.wordIndices.get(i);
            }
        }

        return -1;
    }

    public WordFilter(String[] words) {
        rootForward = new TrieNode();
        rootBackward = new TrieNode();

        Set<String> addedSet = new HashSet<>();

        for (int i = words.length-1; i >= 0; i--) {
            if (addedSet.contains(words[i]))
                continue;
            
            addedSet.add(words[i]); 
            insert1(words[i], i);
            insert2(words[i], i);
        }
    }
    
    public int f(String pref, String suff) {
        return search(pref, suff);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
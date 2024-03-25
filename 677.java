class MapSum {

    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
     
    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int weight;
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
                weight = 0;
            } 
        }
    };
      
    static TrieNode root; 
    static Map<String, Integer> myMap;
      
    // Returns true if key presents in trie, else false
    static int search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
      
            if (pCrawl.children[index] == null)
                return 0;
      
            pCrawl = pCrawl.children[index];
        }
      
        return pCrawl.weight;
    }

    public MapSum() {
        myMap = new HashMap<>();

        root = new TrieNode();
    }
    
// If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node
    static void insert(String key, int val)
    {

        int weight = val;

        if (myMap.get(key) != null) {
            weight -= myMap.get(key);
        }

        myMap.put(key, val);

        int level;
        int length = key.length();
        int index;
      
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();
      
            pCrawl = pCrawl.children[index];
            pCrawl.weight += weight;
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    public int sum(String prefix) {
        return search(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
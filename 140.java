class Solution {
    // Alphabet size (# of symbols)
    static final int ALPHABET_SIZE = 26;
     
    // trie node
    static class TrieNode
    {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
      
        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;
         
        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    };
     
    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node, 
    // just marks leaf node
    static void insert(String key)
    {
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
        }
      
        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }
      
    // Returns true if key presents in trie, else false
    static boolean search(String key)
    {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
      
        for (level = 0; level < length; level++)
        {
            index = key.charAt(level) - 'a';
      
            if (pCrawl.children[index] == null)
                return false;
      
            pCrawl = pCrawl.children[index];
        }
      
        return (pCrawl.isEndOfWord);
    }

    private boolean recur(String s, int i, List<String> ret, StringBuilder cur) {
        if (i == s.length()) {
            return true;
        }

        for (int j = i+1; j <= s.length(); j++) {
            if (search(s.substring(i, j))) {

                StringBuilder curCopy = new StringBuilder(cur);
                curCopy.append(s.substring(i, j));
                if (j < s.length())
                    curCopy.append(" ");

                if (recur(s, j, ret, curCopy)) {
                    ret.add(new String(curCopy));
                }

                //System.out.println("i: " + i + " j: " + j + " cur: " + curCopy);
            }
        }

        return false;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        
        root = new TrieNode(); 
        
        for (String a : wordDict) {
            insert(a);
        }

        List<String> ret = new ArrayList<>();

        recur(s, 0, ret, new StringBuilder());

        return ret;
    }
}
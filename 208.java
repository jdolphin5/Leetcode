class Trie {

    Map<Character, Trie> children;
    Character curr;
    boolean isWord = false;

    public Trie() {
        children = new HashMap<>();
        curr ='-';
    }
    
    public Trie(Character curr) {
        children = new HashMap<>();
        this.curr = curr;
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(char c : word.toCharArray()){
            temp.children.putIfAbsent(c, new Trie(c));
            temp = temp.children.get(c);
        }

        temp.isWord=true;
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for(char c : word.toCharArray()){
            if(!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }

        return temp.isWord;
    }
    
    public boolean startsWith(String prefix) {

        Trie temp = this;
        for(char c : prefix.toCharArray()) {
            if(!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
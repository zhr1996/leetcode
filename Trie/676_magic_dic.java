class MagicDictionary {
    //Initialize trie
    //loop to find out all the possibilities
    
    
    /** Initialize your data structure here. */
    TrieNode root;
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            TrieNode temp = root;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                char c = word.charAt(i);
                if (temp.children[c-'a'] == null) temp.children[c-'a'] = new TrieNode();
                temp = temp.children[c-'a'];
            }
            temp.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode temp = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            char c = word.charAt(i);
            for (int j = 0; j < 26; j++) {
                if ((char)(j+'a') == c || temp.children[j] == null) continue;
                if (helper(temp.children[j],word,i+1)) return true;
            }
            if(temp.children[c-'a'] == null) return false;
            temp = temp.children[c-'a'];
        }
        return false;
    } 
    
    public boolean helper(TrieNode temp, String word, int index) {
        int len = word.length();
        for (int i = index; i < len; i++) {
            char c = word.charAt(i);
            if (temp.children[c-'a'] == null) return false;
            temp = temp.children[c-'a'];
        }
        return temp.isWord;
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children;
    public TrieNode(){
        isWord = false;
        children = new TrieNode[26];
    }
}
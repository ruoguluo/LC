package leetcode.lrg;

/**
 * Created by programmer on 11/11/15.
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf;
    public TrieNode() {

    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        insert(root, word, 0);
    }

    void insert(TrieNode node, String word, int level){

        if (level==word.length()) {
            node.isLeaf=true;
            return;
        }
        char c = word.charAt(level);
        if (node.children[c-'a']==null) node.children[c-'a']=new TrieNode();
        insert(node.children[c-'a'],word,level+1);
    }


    // Returns if the word is in the trie.
    public boolean search(String word) {
        return search(root, word, 0);
    }

    boolean search(TrieNode node,String word, int level){
        if (level==word.length()){
            return node.isLeaf;
        }
        char c = word.charAt(level);
        if (node.children[c-'a']==null) return false;
        else return search(node.children[c-'a'], word, level+1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return startsWith(root, prefix, 0);
    }

    boolean startsWith(TrieNode node, String prefix, int level) {
        if (level==prefix.length()){
            return true;
        }
        char c = prefix.charAt(level);
        if (node.children[c-'a']==null) return false;
        else return startsWith(node.children[c-'a'], prefix, level+1);
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("ab");
        trie.startsWith("a");
    }

}
public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}


class PrefixTree {
    
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[c - 'a'] == null) {
                curr.children[i] = new TrieNode();
            }
            curr = curr.children[i];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[i];
        }

        return curr.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            int i = c - 'a';
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[i];
        }

        return true;
    }
}

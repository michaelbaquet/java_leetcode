package old;

class Trie {

    public static void main(String[] args) {
        Trie t = new Trie();

        t.insert("apple");
        System.out.println(t.search("apple"));
        System.out.println(t.startsWith("app"));
    }

    //use recursive implementation
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        insertHelper(word, 0, root);
    }

    private void insertHelper(String word, int index, TrieNode node) {

        if(word.length() == index) {
            node.end = true;
            return;
        }

        char currChar = word.charAt(index);
        int charNum = charToInt(currChar);

        if(node.children[charNum] == null) {
            TrieNode tempNode = new TrieNode(currChar);
            node.children[charNum] = tempNode;
        }

        insertHelper(word, index + 1, node.children[charNum]);
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index, TrieNode node) {

        if(index == word.length()) {
            return node.end;
        }

        int charNum = charToInt(word.charAt(index));

        if(node.children[charNum] == null) {
            return false;
        }

        return searchHelper(word, index + 1, node.children[charNum]);

    }

    public boolean startsWith(String prefix) {
        return startsWithHelper(prefix, 0, root);
    }

    public boolean startsWithHelper(String word, int index, TrieNode node) {

        if(index == word.length()) {
            return true;
        }

        int charNum = charToInt(word.charAt(index));

        if(node.children[charNum] == null) {
            return false;
        }

        return searchHelper(word, index + 1, node.children[charNum]);

    }

    public int charToInt(char c) {
        return c - 'a';
    }

}

class TrieNode {
    public char c;
    public TrieNode[] children = new TrieNode[26];
    public boolean end = false;

    TrieNode(){}

    TrieNode(char ch){
        this.c = ch;
    }
}

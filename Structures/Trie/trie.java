package Trie;

public class trie {
    private static class trieNode {
        trieNode[] children;
        boolean isEndOfWord;

        public trieNode() {
            this.children = new trieNode[26];
            this.isEndOfWord = false;
        }

        public trieNode insert(char ele) {
            int idx = ele - 'a';
            if (this.children[idx] == null) {
                this.children[idx] = new trieNode();
            }
            return this.children[idx];
        }

        public void setEnd(boolean flag) {
            this.isEndOfWord = flag;
        }

        public trieNode getNext(char ele) {
            int idx = ele - 'a';
            return this.children[idx];
        }

        public boolean getEnd() {
            return this.isEndOfWord;
        }
    }

    trieNode root;

    public trie() {
        this.root = new trieNode();
    }

    public void insert(String word) {
        trieNode ptr = this.root;
        for (char ele : word.toCharArray()) {
            ptr = ptr.insert(ele);
        }
        ptr.setEnd(true);
    }

    public boolean search(String word) {
        trieNode ptr = this.root;
        for (char ele : word.toCharArray()) {
            ptr = ptr.getNext(ele);
            if(ptr == null){
                return false;
            }
        }
        return ptr.getEnd();
    }

    public boolean startsWith(String prefix) {
        trieNode ptr = this.root;
        for (char ele : prefix.toCharArray()) {
            ptr = ptr.getNext(ele);
            if(ptr == null){
                return false;
            }
        }
        return true;
    }
}
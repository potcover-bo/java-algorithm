package tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 字典树
 */
public class Trie {

    private class Node{

        public boolean isWord;
        public Map<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new HashMap<>();
        }

        public Node(){
            this(false);
        }

    }

    // 根节点
    private Node root;
    // 单词数量
    private int size;


    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return this.size;
    }

    /**
     * 添加一个单词
     * @param word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            size++;
        }
        cur.isWord = true;

    }

    /**
     * 查询一个单词是否存在
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) != null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) != null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * '.' 可以匹配任意元素
     * @param word
     * @return
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node cur, String word, int index) {
        if (index == word.length() - 1) {
            // 递归到底
            return cur.isWord;
        }

        char c = word.charAt(index);

        // 不等于 . 的时候直接接着找就可以
        if (c != '.') {
            return search(cur.next.get(c), word, index + 1);
        }else {
            // 匹配当期节点的所有节点
            Set<Character> keySet = cur.next.keySet();
            for (Character ch : keySet) {
                if (search(cur.next.get(ch), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */

public class Trie {
    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;

        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            TrieNode node = trieNode.chars.get(ch);
            if (node == null) {
                node = new TrieNode();
                trieNode.chars.put(ch, node);
            }
            trieNode = node;
        }
        trieNode.bWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;

        TrieNode trieNode = root;
        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            TrieNode node = trieNode.chars.get(ch);
            if (node == null) return false;
            trieNode = node;
        }
        return trieNode.bWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;

        TrieNode trieNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            TrieNode node = trieNode.chars.get(ch);
            if (node == null) return false;
            trieNode = node;
        }
        return true;
    }

    class TrieNode {
        private Map<Character,TrieNode> chars;
        private boolean bWord;
        TrieNode() {
            chars = new HashMap<>();
            bWord = false;
        }
    }
}


/**
 * 执行用时 :202 ms, 在所有 Java 提交中击败了36.11%的用户
 * 内存消耗 :69.4 MB, 在所有 Java 提交中击败了36.21%的用户
 *
 * 利用HashMap 缩减空间，但是空间复杂度变化不大。
 */
//public class Trie {
//    /** Initialize your data structure here. */
//    private TrieNode root;
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || word.length() == 0) return;
//
//        TrieNode trieNode = root;
//        for (int i = 0; i < word.length(); i++) {
//            Character ch = word.charAt(i);
//            TrieNode node = trieNode.chars.get(ch);
//            if (node == null) {
//                node = new TrieNode();
//                trieNode.chars.put(ch, node);
//            }
//            trieNode = node;
//        }
//        trieNode.bWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        if (word == null || word.length() == 0) return false;
//
//        TrieNode trieNode = root;
//        for (int i = 0; i < word.length(); i++) {
//            Character ch = word.charAt(i);
//            TrieNode node = trieNode.chars.get(ch);
//            if (node == null) return false;
//            trieNode = node;
//        }
//        return trieNode.bWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        if (prefix == null || prefix.length() == 0) return false;
//
//        TrieNode trieNode = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            Character ch = prefix.charAt(i);
//            TrieNode node = trieNode.chars.get(ch);
//            if (node == null) return false;
//            trieNode = node;
//        }
//        return true;
//    }
//
//    class TrieNode {
//        private Map<Character,TrieNode> chars;
//        private boolean bWord;
//        TrieNode() {
//            chars = new HashMap<>();
//            bWord = false;
//        }
//    }
//}



/**
 * 使用递归调用是很耗内存的：
 * 执行用时 :235 ms, 在所有 Java 提交中击败了10.52%的用户
 * 内存消耗 :107.8 MB, 在所有 Java 提交中击败了5.01%的用户
 *
 * 改进成循环以后：
 * 执行用时 :197 ms, 在所有 Java 提交中击败了39.69%的用户
 * 内存消耗 :67.6 MB, 在所有 Java 提交中击败了46.14%的用户
 *
 * 耗时减少了一些，内存耗费减少了40%左右。
 *
 */
//public class Trie {
//    /** Initialize your data structure here. */
//    private Map<Character,Trie> chars;
//    private boolean bWord;
//
//    public Trie() {
//        chars = new HashMap<>();
//        bWord = false;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || word.length() == 0) return;
//
//        Trie trie = this;
//        for (int i = 0; i < word.length(); i++) {
//            Character ch = word.charAt(i);
//            Trie t = trie.chars.get(ch);
//            if (t == null) {
//                t = new Trie();
//                trie.chars.put(ch, t);
//            }
//            trie = t;
//        }
//        trie.bWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        if (word == null || word.length() == 0) return false;
//
//        Trie trie = this;
//        for (int i = 0; i < word.length(); i++) {
//            Character ch = word.charAt(i);
//            Trie t = trie.chars.get(ch);
//            if (t == null) return false;
//            trie = t;
//        }
//        return trie.bWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        if (prefix == null || prefix.length() == 0) return false;
//
//        Trie trie = this;
//        for (int i = 0; i < prefix.length(); i++) {
//            Character ch = prefix.charAt(i);
//            Trie t = trie.chars.get(ch);
//            if (t == null) return false;
//            trie = t;
//        }
//        return true;
//    }
//}

/**
 * 每个节点占用26个空间，当字符公共前缀很少时， 太浪费空间。
 *
 * LeetCode：
 * 执行用时 :212 ms, 在所有 Java 提交中击败了24.61%的用户
 * 内存消耗 :111.4 MB, 在所有 Java 提交中击败了5.01%的用户
 */

//class Trie {
//    /** Initialize your data structure here. */
//    private Trie[] chars;
//    private boolean bWord;
//
//    public Trie() {
//        chars = new Trie[26];
//        bWord = false;
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        if (word == null || word.length() == 0) return;
//
//        int index = word.charAt(0) - 'a';
//        Trie t = chars[index];
//        if (t == null) {
//            chars[index] = new Trie();
//            t = chars[index];
//        }
//        if (word.length() == 1) {
//            t.bWord = true;
//        } else {
//            t.insert(word.substring(1));
//        }
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        if (word == null || word.length() == 0) return false;
//
//        int index = word.charAt(0) - 'a';
//        Trie t = chars[index];
//        if (t != null) {
//            if (word.length() == 1) {
//                return t.bWord;
//            } else {
//                return t.search(word.substring(1));
//            }
//        }
//        return false;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        if (prefix == null || prefix.length() == 0) return false;
//
//        int index = prefix.charAt(0) - 'a';
//        Trie t = chars[index];
//        if (t != null) {
//            if (prefix.length() == 1) {
//                return true;
//            } else {
//                return t.startsWith(prefix.substring(1));
//            }
//        }
//        return false;
//    }
//}

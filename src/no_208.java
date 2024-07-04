import java.util.ArrayList;

/**
 * @author wjh
 * @date 2024/6/29 下午4:03
 */

public class no_208 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}

class Trie {
    boolean isEnd;
    ArrayList<Trie> next;

    public Trie() {
        this.isEnd = false;
        this.next = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            this.next.add(null);
        }
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            if (node.next.get(word.charAt(i) - 'a') != null)
                node = node.next.get(word.charAt(i) - 'a');
            else {
                node.next.set(word.charAt(i) - 'a', new Trie());
                node = node.next.get(word.charAt(i) - 'a');
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.next.get(index) != null)
                node = node.next.get(index);
            else
                return false;
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.next.get(index) != null)
                node = node.next.get(index);
            else
                return false;
        }
        return true;
    }
}
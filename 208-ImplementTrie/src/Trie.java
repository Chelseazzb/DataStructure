import java.util.TreeMap;

/**
 * @ClassName : Trie
 * @Author : Zhai Zhibin
 * @Date : 2021/8/27 15:42
 * @Description : 实现字典树
 * @Modified_by :
 * @Version : 1.0
 **/
class Trie {

    //字典树的节点内部类
    private class Node{

        char value; //存储字符
        boolean isWord; //存储是否为单词
        TreeMap<Character,Node> next; //存储节点之后的字符，有26种可能，可以使用hashmap或数组

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    //定义根节点
    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;

        //遍历整个单词
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                cur.next.put(c,new Node()); //创建新的节点加入
            }
            cur = cur.next.get(c); //走到下一个节点
        }

        //需要判断该单词是否已存在
        if (!cur.isWord){
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null){
                return false; //只要中间有一个字符没有，就代表不包含该单词
            }
            cur = cur.next.get(c); //走到下一个节点
        }

        return cur.isWord; //不一定到最后都是单词，可能只是前缀
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;

        //遍历整个前缀
        for (int i = 0; i < prefix.length(); i++) {

            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = cur.next.get(c);
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

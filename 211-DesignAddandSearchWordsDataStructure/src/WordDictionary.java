import java.util.TreeMap;

/**
 * @ClassName : WordDictionary
 * @Author : Zhai Zhibin
 * @Date : 2021/8/27 16:09
 * @Description : 支持添加新单词和查找字符串是否与任何先前添加的字符串匹配
 * @Modified_by :
 * @Version : 1.0
 **/
class WordDictionary {

    //字典树的节点内部类
    private class Node{

        char value; //存储字符
        boolean isWord; //是否为单词
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
    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {

        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }

        cur.isWord = true;
    }

    public boolean search(String word) {
        Node cur = root;

        return match(root,word,0);

    }

    //递归匹配函数
    private boolean match(Node cur, String word, int index) {

        //递归终止条件
        if (index == word.length())
            return cur.isWord;

        char c = word.charAt(index);
        if (c != '.'){
            if (cur.next.get(c) == null)
                return false;
            return match(cur.next.get(c),word,index+1);
        } else {
            for (char find : cur.next.keySet())
                if (match(cur.next.get(find),word,index+1))
                    return true;
            return false;

        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

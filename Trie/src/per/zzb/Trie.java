package per.zzb;

import java.util.TreeMap;

/**
 * @ClassName : Trie
 * @Author : Zhai Zhibin
 * @Date : 2021/8/27 14:30
 * @Description : 字典树的实现，不使用泛型类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Trie {

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

    //定义根节点和数量
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public void add(String word){
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
            size ++;
        }
    }

    public boolean contains(String word){
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

    public int getSize(){
        return size;
    }

    public void delete(String word){
        //首先需要判断word是否在Trie中存在
        if (!contains(word))
            throw new IllegalArgumentException("Delete failed. Word not exists");


    }

    public boolean isPrefix(String prefix){

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

import java.util.TreeMap;

/**
 * @ClassName : MapSum
 * @Author : Zhai Zhibin
 * @Date : 2021/8/27 23:05
 * @Description : 实现一个 MapSum 类，支持两个方法，insert 和 sum
 * @Modified_by :
 * @Version : 1.0
 **/
class MapSum {

    //字典树的节点内部类
    private class Node{

        int value; //存储字符
        TreeMap<Character,Node> next; //存储节点之后的字符，有26种可能，可以使用hashmap或数组

        public Node(int value){
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(){
            this(0);
        }
    }

    //定义根节点
    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;

        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c,new Node());
            cur = cur.next.get(c);
        }

        cur.value = val;
    }

    public int sum(String prefix) {

        //第一步，找到前缀的位置
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0; //不存在这个前缀
            cur = cur.next.get(c);
        }

        //找到前缀之后，进行递归求和
        return sum(cur);
    }

    //递归求和
    private int sum(Node cur) {
        //递归终止条件
        if (cur.next.size() == 0)
            return cur.value; //没有后续的节点了

        //记录当前节点的值
        int res = cur.value;
        for (char c : cur.next.keySet()){
            res += sum(cur.next.get(c)); //不断递归，找每一层的单词值value
        }

        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

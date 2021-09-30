package per.zzb;

/**
 * @ClassName : Main
 * @Author : Zhai Zhibin
 * @Date : 2021/8/27 14:30
 * @Description : Trie的测试类
 * @Modified_by :
 * @Version : 1.0
 **/
public class Main {

    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.add("cat");
        trie.add("dog");
        trie.add("deer");
        trie.add("door");

        System.out.println("Trie中是否包含单词dog: " + trie.contains("dog"));
        System.out.println("Trie中是否包含前缀ca: " + trie.isPrefix("ca"));
    }
}

import org.w3c.dom.ls.LSException;
import org.w3c.dom.ls.LSInput;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode cur = head;
        Set<ListNode> set = new LinkedHashSet<>(); // 记录节点是否出现过


        while (cur != null) {
            if (set.contains(cur))
                return cur;
            else {
                set.add(cur);
                cur = cur.next;
            }
        }
        return null;
    }
}

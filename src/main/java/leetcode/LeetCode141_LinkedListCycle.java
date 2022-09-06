package leetcode;

import java.util.List;

/**
 * 给你一个链表的头结点head,
 * 判断链表中是否有环
 * 如果链表中有某个节点
 * 可以通过连续跟踪next指针再次到达, 则链表中存在环
 * 为了表示给定链表中的环
 * 评测系统内部使用整数pos来表示链表尾连接到链表中的位置(索引从0开始)
 * 如果链表中存在环, 则返回true, 否则返回false
 */
public class LeetCode141_LinkedListCycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow.next != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode (int x) {
            val = x;
            next = null;
        }
    }
}

package leetcode;

/**
 * 给你一个链表的头结点head, 旋转链表
 * 将链表每个节点向右移动k个位置
 */
public class LeetCode61_RotateList {
    public static void main(String[] args) {
        System.out.println(4 % 3);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head.next == null) {
            return head;
        }
        // 计算链表长度同时获取尾节点
        int size = 1;
        ListNode tmpNode = head;
        while (tmpNode.next != null) {
            tmpNode = tmpNode.next;
            size++;
        }
        ListNode oldTail = tmpNode;

        if (k % size == 0) {
            return head;
        }

        tmpNode = head;
        int j = 1;
        k = k > size ? k % size : k;
        while (j < k+1) {
            tmpNode = tmpNode.next;
            j++;
        }
        ListNode preNode = head;
        while (j < size) {
            j++;
            preNode = preNode.next;
        }
        ListNode oldHead = head;
        head = preNode.next;
        preNode.next = null;
        oldTail.next = oldHead;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
    }
}

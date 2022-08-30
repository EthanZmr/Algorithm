package leetcode;
/**
 * 给定一个已排序的链表的头head, 删除原始链表中所有重复数字的节点
 * 只留下不同的数字
 * 返回已排序的链表
 *
 * 链表已按升序排列
 */
public class LeetCode82_RemoveDuplicatesFromSortedListii {
    public static void main(String[] args) {
        ListNode n2 = new ListNode();
        ListNode n1 = new ListNode(1, n2);
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }     
        if (head.next == null) {
            return head;
        }
        
        // 确定头节点的位置
        ListNode left = head;
        ListNode right = head.next;

        ListNode tmp = left.next;
        while (left.val == right.val) {
            right = right.next;
            if (right == null) {
                return null;
            }
            if (tmp.val != right.val) {
                left = right;
                tmp = left.next;
                right = right.next;
            }
        }
        head = left;
        right = left.next;       
        // 从头节点开始向后删除重复元素
        while (right.next != null) {
            if (right.next.val > right.val) {
                left.next = right;
                left = right;
            }
            right = right.next;
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}

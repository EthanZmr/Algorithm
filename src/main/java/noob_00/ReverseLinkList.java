package noob_00;

/**
 * 反转链表
 */
public class ReverseLinkList {
    /**
     * 单链表节点
     * */
    static class SingleNode {
        SingleNode next;
        int data;

        public SingleNode(int val) {
            this.data = val;
        }
    }

    /**
     * 双链表节点
     * */
    static class DoubleNode {
        DoubleNode prev;
        DoubleNode next;
        int data;

        public DoubleNode(int val) {
            this.data = val;
        }
    }

    public static void main(String[] args) {
        SingleNode node01 = new SingleNode(1);
        node01.next = new SingleNode(2);
        node01.next.next = new SingleNode(3);
        node01 = reverseSingleLinkedList(node01);
        while (node01 != null) {
            System.out.print(node01.data + ",");
            node01 = node01.next;
        }
        System.out.println();
        System.out.println("====================");
        
        DoubleNode node001 = new DoubleNode(1);
        DoubleNode node002 = new DoubleNode(2);
        DoubleNode node003 = new DoubleNode(3);
        node001.next = node002;
        node002.prev = node001;
        node002.next = node003;
        node003.prev = node002;
        node001 = reverseDoubleLinkedList(node001);
        while(node001 != null) {
            System.out.print(node001.data + ",");
            node001 = node001.next;
        }
        System.out.println();
    }

    // 1. 反转单链表
    // 3. 用单链表实现队列和栈
    // 4. 双链表实现双端队列
    public static SingleNode reverseSingleLinkedList(SingleNode head) {
        SingleNode prev = null;
        SingleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }


    // 2. 反转双链表
    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode prev = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            head.prev = next;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 单链表实现队列
     * */
    public static class implQueueByLinkedList {
        private SingleNode head;
        private SingleNode tail;
        private int size;

        public int size() {
            return this.size;
        }

        public boolean queue(SingleNode node) {
            return false;
        }

        public SingleNode dequeue() {
            return null;
        }
        
    }

    /**
     * 单链表实现栈
     * */
    public static class implStackByLinkedList {
        private SingleNode head;
        private int size;


        public int size() {
            return this.size;
        }

        public boolean push(SingleNode node) {
            return false;
        }

        public SingleNode pop() {
            return null;
        }
    }

    /**
     * 双向链表实现双端队列
     * */
    public static class implDoubleQueueByDoubleLinkedList {
        private DoubleNode head;
        private DoubleNode tail;
        private int size;
    }
    
}

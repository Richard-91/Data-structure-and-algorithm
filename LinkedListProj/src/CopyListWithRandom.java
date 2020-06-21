public class CopyListWithRandom {
    public static class Node {
        public int value;
        public Node next;
        public Node rand;

        public Node(int data) {
            this.value = data;
        }
    }

    //复杂链表的复制，节点中带有一个random指针
    public static Node copyListWithRand(Node head) {
        if(head == null){
            return null;
        }
        //1.在每个节点的后面复制一个一样的节点
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.value);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        //2.将复制的节点的random赋值
        cur = head;
        while (cur != null){
            cur.next.rand = cur.rand == null ? null : cur.rand.next;
            cur = cur.next.next;
        }
        //3.分离
        cur = head;
        Node newHead = null;
        Node newCur = null;
        while (cur != null){
            if(newHead == null){
                newHead = cur.next;
                newCur = cur.next;
            }else{
                newCur.next = cur.next;
                newCur = newCur.next;
            }
            cur.next = cur.next.next;
            cur = cur.next;
        }

        return newHead;
    }


    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res = null;
        printRandLinkedList(head);
        res = copyListWithRand(head);
        printRandLinkedList(res);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res = copyListWithRand(head);
        printRandLinkedList(res);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}

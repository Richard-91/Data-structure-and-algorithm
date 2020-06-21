public class SmallEqualBigger {
    public static class Node{
        public int value;
        public Node next;
        public Node(int v){
            this.value = v;
        }
    }

    //将单向链表按某值划分成左边小、中间相等、右边大的形式
    public static Node listPartition(Node head, int pivot) {
        if(head == null){
            return null;
        }
        Node sH = null;
        Node sE = null;
        Node eH = null;
        Node eE = null;
        Node bH = null;
        Node bE = null;
        Node cur = null;
        //1.遍历链表，将三中情况的值各自挂在应去的链表中
        while(head != null){
            cur = head;
            head = head.next;
            if(cur.value < pivot){
                cur.next = sH;
                sH = cur;
                sE = sE != null ? sE : cur;
            }else if(cur.value == pivot){
                cur.next = eH;
                eH = cur;
                eE = eE != null ? eE : cur;
            }else{
                cur.next = bH;
                bH = cur;
                bE = bE != null ? bE : cur;
            }
        }
        //2.将三个链表链接起来
        if(sH != null){
            sE.next = eH;
            eE = eE == null ? sE : eE;
        }
        if(eE != null){
            eE.next = bH;
        }
        return sH != null ? sH : (eH != null ? eH : bH);
    }


    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);


        printLinkedList(head1);
        head1 = listPartition(head1, 5);
        printLinkedList(head1);

    }
}

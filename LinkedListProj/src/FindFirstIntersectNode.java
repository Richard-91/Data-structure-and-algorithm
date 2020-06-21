public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    //给定两个可能有环也可能无环的单链表，头节点head1和head2。
    //请实现一个函数，如果两个链表相交，请返回相交的 第一个节点。如果不相交，返回null
    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        System.out.print("loop1:");
        System.out.println(loop1);
        System.out.print("loop2:");
        System.out.println(loop2);
        Node res = null;
        if(loop1 == null && loop2 == null){
            res = noLoop(head1, head2);
        }
        if(loop1 != null && loop2 != null){
            res = bothLoop(head1, loop1, head2, loop2);
        }
        return res;
    }

    // 找到链表第一个入环节点，如果无环，返回null
    public static Node getLoopNode(Node head) {
        System.out.println("getLoopNode:");
        if(head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast){
            if(fast == null || fast.next == null){
                System.out.println("没找到环，返回");
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        System.out.println(slow.value);
        return slow;
    }

    // 如果两个链表都无环，返回第一个相交节点，如果不想交，返回null
    public static Node noLoop(Node head1, Node head2) {
        System.out.println("进入noLoop:");
        Node cur1 = head1;
        Node cur2 = head2;
        int passBottom = 2;
        while (cur1 != null && cur2 != null){
            if(cur1 == cur2) {
                System.out.println("noLoop相交，返回cur1");
                return cur1;
            }
            if(passBottom != 0 && cur1.next == null){
                cur1 = head2;
                passBottom--;
            }else {
                cur1 = cur1.next;
            }
            if(passBottom != 0 && cur2.next == null){
                cur2 = head1;
                passBottom--;
            }else{
                cur2 = cur2.next;
            }
        }
        System.out.println("noLoop不相交，返回null");
        return null;
    }

    // 两个有环链表，返回第一个相交节点，如果不相交返回null
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        System.out.println("进入bothLoop:");
        Node cur1 = null;
        Node cur2 = null;
        if(loop1 == loop2){
            cur1 = head1;
            cur2 = head2;
            while (cur1 != cur2){
//                if(cur1 == loop1) cur1.next = head2;
//                if(cur2 == loop1) cur2.next = head1;
                cur1 = cur1.next;
                cur2 = cur2.next;
                cur1 = cur1 == loop1.next ? head2 : cur1;
                cur2 = cur2 == loop2.next ? head1 : cur2;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }


    public static void main(String[] args) {
        //1-1.两个无环链表相交
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        System.out.println("===================================================");

        //1-2.两个无环链表不相交
        // 1->2->3->4->5->6->7->null
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        //0->9->8->4->5->null
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = new Node(4);
        head2.next.next.next.next = new Node(5);
        System.out.println(getIntersectNode(head1, head2));

        System.out.println("===================================================");

        //2-1.两个都有环，但不相交
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        // 0->9->8->0...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head2; // 8->0
        System.out.println(getIntersectNode(head1, head2));

        System.out.println("===================================================");

        //2-2.两个有环链表，在环外相交
        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        System.out.println("===================================================");

        //2-3.两个有环链表，在环内相交
        // 0->9->8->6->7->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }
}

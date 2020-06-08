package stack_and_queue;

public class DoubleEndsQueueToStackAndQueue {
    public static class ListNode {
        Integer value;
        ListNode last;
        ListNode next;

        public ListNode(Integer data) {
            value = data;
        }
    }

    public static class DoubleEndsQueue {
        ListNode head;
        ListNode tail;

        public void addFromHead(Integer value) {
            ListNode cur = new ListNode(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(Integer value) {
            ListNode cur = new ListNode(value);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public Integer popFromHead() {
            if (head == null) {
                return null;
            }
            ListNode cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }

        public Integer popFromTail() {
            if (head == null) {
                return null;
            }
            ListNode cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public Integer head(){
            return head.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    public static class MyStack extends Stack{
        private DoubleEndsQueue queue;

        public MyStack() {
            queue = new DoubleEndsQueue();
        }

        public void push(Integer value) {
            queue.addFromHead(value);
        }

        public Integer pop() {
            return queue.popFromHead();
        }

        public Integer peek(){
            return queue.head();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static class MyQueue extends Queue{
        private DoubleEndsQueue queue;

        public MyQueue() {
            queue = new DoubleEndsQueue();
        }

        public void push(Integer value) {
            queue.addFromHead(value);
        }

        public Integer poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    //detector需要用到
    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }
}

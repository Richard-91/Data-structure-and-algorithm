package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;


public class TwoQueuesToStack {
    public static class TwoQueueStack extends Stack{
        public Queue<Integer> queue;
        public Queue<Integer> help;

        public TwoQueueStack() {
            queue = new LinkedList<Integer>();
            help = new LinkedList<Integer>();
        }

        public void push(Integer value) {
            queue.offer(value);
        }

        public Integer pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            Integer ans = queue.poll();
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public Integer peek() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            Integer ans = queue.poll();
            help.offer(ans);
            Queue<Integer> tmp = queue;
            queue = help;
            help = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

    }
}

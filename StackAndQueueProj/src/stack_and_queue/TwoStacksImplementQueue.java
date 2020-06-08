package stack_and_queue;

import java.util.Stack;

public class TwoStacksImplementQueue {
    public static class TwoStacksQueue extends Queue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;

        public TwoStacksQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        // push栈向pop栈倒入数据
        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void push(Integer pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public Integer poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

//        public int peek() {
//            if (stackPop.empty() && stackPush.empty()) {
//                throw new RuntimeException("Queue is empty!");
//            }
//            pushToPop();
//            return stackPop.peek();
//        }
    }
}

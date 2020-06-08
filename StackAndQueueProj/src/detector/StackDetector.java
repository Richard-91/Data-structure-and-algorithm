package detector;

import stack_and_queue.ArrayToStackAndQueue;
import stack_and_queue.DoubleEndsQueueToStackAndQueue;
import stack_and_queue.TwoQueuesToStack;

import java.util.Stack;

public class StackDetector {
    public static boolean detector(String s){
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            stack_and_queue.Stack myStack = null;
            if(s.equals("DoubleEndsQueueToStack")){
                myStack = new DoubleEndsQueueToStackAndQueue.MyStack();
            }else if(s.equals("ArrayToStack")){
                myStack = new ArrayToStackAndQueue.MyStack(8);
            }else if(s.equals("TwoQueueToStack")){
                myStack = new TwoQueuesToStack.TwoQueueStack();
            }

            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!DoubleEndsQueueToStackAndQueue.isEqual(myStack.pop(), stack.pop())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

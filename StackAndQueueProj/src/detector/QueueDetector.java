package detector;

import stack_and_queue.ArrayToStackAndQueue;
import stack_and_queue.DoubleEndsQueueToStackAndQueue;
import stack_and_queue.TwoStacksImplementQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueDetector {
    public static boolean detector(String s){
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            stack_and_queue.Queue myQueue = null;
            if(s.equals("DoubleEndsQueueToQueue")){
                myQueue = new DoubleEndsQueueToStackAndQueue.MyQueue();
            }else if(s.equals("ArrayToQueue")){
                myQueue = new ArrayToStackAndQueue.MyQueue(100);
            }else if(s.equals("TwoStacksToQueue")){
                myQueue = new TwoStacksImplementQueue.TwoStacksQueue();
            }

            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(nums);
                    queue.offer(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(nums);
                        queue.offer(nums);
                    } else {
                        if (!DoubleEndsQueueToStackAndQueue.isEqual(myQueue.poll(), queue.poll())) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

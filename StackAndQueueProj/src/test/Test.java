package test;

import detector.QueueDetector;
import detector.StackDetector;

public class Test {
    private static String whatStack = "TwoQueueToStack";//"DoubleEndsQueueToStack","ArrayToStack"
    private static String whatQueue = "TwoStacksToQueue";//""DoubleEndsQueueToQueue"","ArrayToQueue"

    public static void main(String[] args) {
        if(StackDetector.detector(whatStack)){
            System.out.println(whatStack + "Detector测试通过");
        }else{
            System.out.println(whatStack + "Detector测试不通过！！！");
        }

//        if(QueueDetector.detector(whatQueue)){
//            System.out.println(whatQueue + "QueueDetector测试通过");
//        }else{
//            System.out.println(whatQueue + "QueueDetector测试不通过！！！");
//        }
    }
}

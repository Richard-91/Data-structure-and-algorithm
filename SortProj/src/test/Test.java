package test;


import detector.Detector;
import sort.InsertSort;

public class Test {
    private static String sort = "insertSort";
    public static void main(String[] args) {
        if(Detector.detector(sort)){
            System.out.println(sort+"测试通过");
        }else{
            System.out.println(sort + "不通过");
        }
    }
}

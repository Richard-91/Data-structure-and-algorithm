package test;


import detector.Detector;
import sort.InsertSort;
import sort.QuickSort;

public class Test {
    private static String sort = "quickSort2";
    public static void main(String[] args) {
        if(Detector.detector(sort)){
            System.out.println(sort+"测试通过");
        }else{
            System.out.println(sort + "不通过");
        }
    }
}

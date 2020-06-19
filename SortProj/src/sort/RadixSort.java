package sort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        //1.先找出数组中最大的值，以确定该数组最大多少位
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }
        //2.确定数组最大值的位数
        int digit = 0;
        while((max / 10) != 0 || (max % 10) != 0){
            max /= 10;
            digit++;
        }
        //3.digit有多少位，就进行多少次排序
        final int radix = 10;
        int d;
        int[] help = new int[arr.length];
        for(int i=1; i<=digit; i++){
            //4.计算第digit位上有多少个数
            int[] count = new int[radix];
            for(int j = 0; j<arr.length; j++){
                d = getDigit(arr[j], i);
                count[d]++;
            }
            //5.在count_help上把第digit位上 >= k 的数累加起来
            for(int j = 1; j < count.length; j++){
                count[j] = count[j-1] + count[j];
            }
            //6.在digit位上进行排序,arr数组从右往左看
            for(int j = arr.length-1; j >= 0; j--){
                d = getDigit(arr[j], i);
                help[count[d]-1] = arr[j];
                count[d]--;
            }
            //7.把在help上排好的数组刷新到arr上
            for(int j = 0; j < arr.length; j++){
                arr[j] = help[j];
            }
        }
    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100000;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            radixSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        radixSort(arr);
        printArray(arr);

    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

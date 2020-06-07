package sort;

public class SelectSort {
    public static void selectSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=0; i<arr.length; i++){
            int minIdx = i;
            for(int j = i+1; j<arr.length; j++){
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            swap(arr, i, minIdx);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

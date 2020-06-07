package sort;

public class InsertSort {
    public static void insertSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        for(int i=1; i<arr.length; i++){
            for(int j = i; j>0; j--){
                if(arr[j] < arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

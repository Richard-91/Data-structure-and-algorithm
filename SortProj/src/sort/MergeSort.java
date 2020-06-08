package sort;

public class MergeSort {
    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int i, int j){
        if(i == j) return;
        int mid = i + ((j - i) >> 1);
        process(arr, i, mid);
        process(arr, mid+1, j);
        merge(arr, i, mid, j);
    }

    public static void merge(int[] arr, int i, int mid, int j){
        int[] temp = new int[j-i+1];
        int tempIdx = 0;
        int L = i;
        int R = mid + 1;
        while(L <= mid && R <= j){
            if(arr[L] <= arr[R]){
                temp[tempIdx++] = arr[L++];
            }else{
                temp[tempIdx++] = arr[R++];
            }
        }
        while(L <= mid){
            temp[tempIdx++] = arr[L++];
        }
        while (R <= j){
            temp[tempIdx++] = arr[R++];
        }
        for(int k=0; k<temp.length; k++){
            arr[i+k] = temp[k];
        }
    }
}

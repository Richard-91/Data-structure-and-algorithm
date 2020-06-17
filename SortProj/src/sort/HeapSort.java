package sort;

public class HeapSort {
    //堆排序空间复杂度为O(1)
    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        //O(N*logN) 经典堆排序，从上到下逐个建堆
//        for(int i=0; i<arr.length; i++){//O(N)
//            heapInsert(arr, i);//O(logN)
//        }

        //O(N)  优化后的堆排序，从下到上堆化
        for(int i=arr.length-1; i>=0; i--){
            heapify(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        //O(N*logN)
        while (heapSize > 0){         //O(N)
            heapify(arr, 0, heapSize); //O(logN)
            swap(arr, 0, --heapSize);
        }

    }

    public static  void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if(largest == index){
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

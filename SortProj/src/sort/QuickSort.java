package sort;

public class QuickSort {
    //快速排序第一版，算法复杂度有可能O(N²)
    public static void quickSort1(int[] arr){
        if(arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length-1);

    }

    public static void process1(int[] arr, int L, int R){
        if(L >= R) {
            return;
        }
        int mid = partition1(arr, L, R);
        process1(arr, L, mid-1);
        process1(arr, mid+1, R);
    }

    public static int partition1(int[] arr, int L, int R){
        int p=arr[L];
        int i=L;
        int j=R;
        while(i<j){
            // 先从右往左找比p小的元素
            while(i<j && arr[j]>=p) j--;
            if(i<j){
                arr[i]=arr[j];
                i++;
            }
            // 再从左往右找比p小的元素
            while(i<j && arr[i]<p) i++;
            if(i<j){
                arr[j]=arr[i];
                j--;
            }
        }
        arr[i]=p;
        return i;
    }



    //快速排序第二版，算法复杂度稳定在O(N*logN)，最差的情况也是
    public static void quickSort2(int[] arr){
        if(arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length-1);
    }

    public static void process2(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = partition2_netherlandsFlag(arr, L, R);
        process2(arr, L, equalArea[0]-1);
        process2(arr, equalArea[1]+1, R);
    }

    //以arr[R]为划分值
    public static int[] partition2_netherlandsFlag(int[] arr, int L, int R){
        if(L > R) {
            return new int[]{-1, -1};
        }
        if(L == R){
            return new int[]{L, R};
        }
        int p = arr[R];
        int less = L - 1;
        int more = R + 1;
        int index = L;
        while(index < more){
            if(arr[index] < p){
                swap(arr, ++less, index++);
            }else if(arr[index] > p){
                swap(arr, --more, index);
            }else{
                index++;
            }
        }
        return new int[]{less+1, more-1};
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

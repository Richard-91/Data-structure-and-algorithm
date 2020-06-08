package stack_and_queue;

public class ArrayToStackAndQueue {
    public static class MyStack extends Stack{
        private Integer[] arr;
        private int topIdx;
        private static int cap;

        public MyStack(int limit){
            cap = limit;
            topIdx = 0;
            arr = new Integer[cap];
        }

        public void push(Integer value){
            if(topIdx == cap){
                cap *= 2;
                Integer[] arr_new = new Integer[cap];
                for(int i=0; i<cap/2; i++){
                    arr_new[i] = arr[i];
                }
                arr = arr_new;
                arr[topIdx++] = value;
            }else{
                arr[topIdx++] = value;
            }
        }

        public Integer pop(){
            return arr[--topIdx];
        }

        public boolean isEmpty() {
            return topIdx == 0;
        }
    }

    public static class MyQueue extends Queue{
        private Integer[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new Integer[limit];
            pushi = 0;
            polli = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(Integer value) {
            if (size == limit) {
                throw new RuntimeException("队列满了，不能再加了");
            }
            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public Integer poll() {
            if (size == 0) {
                throw new RuntimeException("队列空了，不能再拿了");
            }
            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }

    }
}

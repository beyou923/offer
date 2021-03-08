import java.util.Arrays;

public class Solution {
    // 直接调API
//    public int[] getLeastNumbers(int[] arr,int k){
//        int[] res = new int[k];
//        Arrays.sort(arr);
//        for (int i = 0; i < k; i++) {
//            res[i] = arr[i];
//        }
//        return res;
//    }

    // 手撕快速排序
    public static int[] getLeastNumbers(int[] arr, int k){
        int[] res = new int[k];
        int len = arr.length;
        if (len == 0 || k >= len) return arr;
        quickSort(arr,0,len -1 );
        for (int i = 0; i < k; i++)
            res[i] = arr[i];
        return res;
    }

    public static void quickSort(int[] arr, int start, int end){
        if (arr.length <=0 || start >= end) return;
        int key = arr[start];
        int l = start, r = end;
        while (l < r) {
            while (l < r && key <= arr[r])
                r--;
            arr[l] = arr[r]; // 不能写成 arr[l++] = arr[r]
            while (l < r && key >= arr[l])
                l++;
            arr[r] = arr[l]; // 不能写成 arr[r--] = arr[l]
        }
        arr[l] = key;
        quickSort(arr,start,l - 1);// 基准值左边
        quickSort(arr,r + 1,end); // 基准值右边
    }

    static public void main(String[] args){
        int[] arr = new int[]{0,1,2,1};
        int res [] = getLeastNumbers(arr,2);
        for (int num:res) {
            System.out.println(num);
        }
    }
}

public class Solution {
    public int search(int[] nums, int target){
        int number = 0;
        int length = nums.length;
        if (length > 0){
            int first = frontBinarySearch(nums,0,length - 1,target);
            int last = backBinarySearch(nums,length,0,length - 1,target);
            if (first > -1 && last > -1)
                number = last - first + 1;
        }
        return number;
    }
    // 对前半段二分查找
    public int frontBinarySearch(int[] num, int start, int end,int target){
        if (start > end) return -1;
        int midIndex = (start + end) >> 1; // 右移1位相当于除以2
        if (num[midIndex] == target){ // 判断是不是第一个target
            if ((midIndex > 0 && num[midIndex - 1] != target) || midIndex == 0)
                return midIndex; // 是数组中第一个target
            else
                end = midIndex - 1; // 对前半段继续用二分查找
        } else if (num[midIndex] > target){
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return frontBinarySearch(num,start,end,target);// 递归查找数组中第一个target
    }
    // 对后半段二分查找
    public int backBinarySearch(int[] num,int length,int start,int end,int target){
        if (start > end) return -1;
        int midIndex = (start + end) >> 1; // 右移1位相当于除以2
        // 判断是不是最后一个target
        if (num[midIndex] == target){
            if ((midIndex < length -1 && num[midIndex + 1] != target) || midIndex == length - 1)
                return midIndex; // 是数组中最后一个target
            else
                start = midIndex + 1; // 对后半段继续用二分查找
        } else if (num[midIndex] > target){
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }
        return backBinarySearch(num,length,start,end,target);// 递归查找数组中最后一个target
    }
}

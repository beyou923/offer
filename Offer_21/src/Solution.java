/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 * 示例：
 *      输入：nums = [1,2,3,4]
 *      输出：[1,3,2,4]
 *      注：[3,1,2,4] 也是正确的答案之一。
 *
 * 提示：
 *      1 <= nums.length <= 50000
 *      1 <= nums[i] <= 10000
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * */
// TODO: 双指针法：2个指针分别指向数组头和数组尾部，分别判断元素是奇数还是偶数，分4中情况处理
class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length < 1)
            return new int[0];
        // 只有一个元素直接返回
        if (nums.length == 1)
            return nums;
        // 初始时left指向数组首元素， right指向数组最后一个元素
        int left = 0, right = nums.length - 1;
        while (left < right){
            // 左右元素都是奇数 ，只移动左指针
            if (isOdd(nums[left]) && isOdd(nums[right])) {
                left++;
            } else if (!isOdd(nums[left]) && isOdd(nums[right])){
                // 左偶右奇，交换元素，同时移动左右指针
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            } else if (isOdd(nums[left]) && !isOdd(nums[right])){
                // 左奇右偶，同时移动左右指针
                left++;
                right--;
            } else {
                // 左右都是偶数，只移动右指针
                right--;
            }
        }
        return nums;
    }
    // 判断 number是否是奇数，是奇数返回true，不是返回false
    boolean isOdd(int number){
        if (1 == (number & 0x1))
            return true;
        else
            return false;
    }
}
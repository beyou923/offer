/**
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，
 *  数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 *  示例 1：
 *      输入：[3,4,5,1,2]
 *      输出：1
 *
 *  示例 2：
 *      输入：[2,2,2,0,1]
 *      输出：0
 *
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 */
// TODO : 用二分查找，当中间元素位于右边递增序列就移动右指针到之间位置；之间元素位于左边指针就移动左边指针到中间位置
// TODO： 重读上述过程，当左后指针相邻时，右指针指向的元素就是最小值
public class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length < 1)
            return Integer.MAX_VALUE;
        if (numbers.length == 1) // 只有一个元素直接返回
            return numbers[0];

        int left = 0, right = numbers.length -1; // 左右指针
        int mid = left; // 一定要让中间位置等于第一个元素的索引，防止出现 [1,3]这种测试用例
        // 这个地方不能是索引的比较，一定要是元素的比较 防止出现 [1,3]这种测试用例
        while (numbers[left] >= numbers[right]) {
            if (left + 1 == right) {
                mid = right; // 左右指针相邻，返回右指针指向元素
                break;
            }
            mid = (left + right) / 2;
            // TODO 如果 left right 和 mid 指向的元素相等 例如序列 [10,1,10,10,10] 此时无法判断中间元素到底属于按个序列，需要顺序查找
            if (numbers[left] == numbers[right] && numbers[right] == numbers[mid])
                return oderSearch(numbers,left,right);
            // 一定要用if else结构，因为中间值不可能既属于左边序列又属于右边序列
            if (numbers[mid] >= numbers[left]){
                // 中间值在左边序列
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                // 中间值在右边序列
                right = mid;
            }
        }
        return numbers[mid];
    }

    public int oderSearch(int[] numbers,int left,int right) {
        int min = numbers[left];
        for (int i = left; i <= right; ++i ) {
            if (min > numbers[i])
                min = numbers[i];
        }
        return min;
    }
}

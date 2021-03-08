/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *      输入: n = 1
 *      输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *      用返回一个整数列表来代替打印
 *      n 为正整数
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * */
public class Solution {
    public int[] printNumbers(int n) {
        if (n < 1)
            return null;
        int maxNumber = (int)Math.pow(10,n) - 1;
        int result[] = new int[maxNumber];
        for (int i = 0; i < maxNumber; i++)
            result[i] = i + 1;
        return result;
    }
}

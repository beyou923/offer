/**
 *  给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 *  请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 *  示例 1：
 *      输入: 2
 *      输出: 1
 *      解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例 2:
 *      输入: 10
 *      输出: 36
 *      解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *      2 <= n <= 58
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * */
// TODO: 用贪心思想，尽量把绳子剪成长度为3的段，如果见到最后一段剩下长度为4，则剪成2段长度为2而不要剪成2段长度为1和3的段，因为 2 * 2 > 1 * 3
public class Solution {
    public int cuttingRope(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        // 1 , 2
        if (n == 3)  return 2;
        // 2, 2
        if (n == 4) return 4;

        int i = n % 3; // 余数取值可能 0,1,2
        int j = n / 3;
        // 余 1 则少少分一段长度为3的段，留下一段长度为4（因为3+1）在分成2段长度为2和2的段
        if (i == 1)
            return (int)Math.pow(3,j - 1) * 4;
        // 最后一段长度为 2
        else if (i == 2)
            return (int)Math.pow(3,j) * 2;
        // 绳子长度刚好是3的倍数
        else
            return (int)Math.pow(3,j);
    }
}

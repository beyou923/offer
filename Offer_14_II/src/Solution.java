/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *  输入: 2
 *  输出: 1
 *  解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 示例 2:
 *  输入: 10
 *  输出: 36
 *  解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 提示：
 *  2 <= n <= 1000
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof
 * */
// TODO:用贪心思想，尽量把绳子剪成长度为3的段，如果见到最后一段剩下长度为4，则剪成2段长度为2而不要剪成2段长度为1和3的段，因为 2 * 2 > 1 * 3
// TODO:最后一段剩2或者3直接乘不分了，如果剩4分不分结果都是4，所以也可以直接乘
public class Solution {
    /*
    public int cuttingRope(int n){
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;

        int i = n % 3;
        int j = n / 3;
        if (i == 2)
            return ((int)Math.pow(3,j) * 2) % 1000000007;
        else if (i == 1)
            return ((int)Math.pow(3,j - 1) *4) % 1000000007;
        else
            return ((int)Math.pow(3,j)) % 1000000007;
    }
    不能用这种方法：虽然思路是正确的，但是会内存溢出，int占4个字节 short占2个字节，long占8个字节
     */
    public int cuttingRope(int n){
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        long ans = 1; // 防止内存溢出
        // 退出循环的时候n只可能是2,3,4之一,因为要能进循环n最小得是5
        while (n > 4){
            ans *= 3;
            ans %= 1000000007;
            n -= 3;
        }
        return (int) (ans * n % 1000000007); // 别忘了取模
    }
}

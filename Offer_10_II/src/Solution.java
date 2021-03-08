/**
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *  答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 *  示例 1：
 *      输入：n = 2
 *      输出：2
 *
 *  示例 2：
 *      输入：n = 7
 *      输出：21
 *
 * 示例 3：
 *      输入：n = 0
 *      输出：1
 * 提示：
 *      0 <= n <= 100
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * **/

// TODO : 利用动态规划思想，记录中间结果递推最后结果
public class Solution {
    public int numWays(int n) {
        if (n <= 0)  // n 为0 时候 根据题目要求返回 1
            return 1;
        // 前第一和第二节台阶走法就是台阶数
        if ( n== 1 ||n == 2)
            return n;
        int stepOne = 1,stepTwo = 2; // 1节台阶和2节台阶走法
        int step = 0;
        for (int i = 3; i <= n; ++i){
            // 到达第 i 节台阶的走法 等于 到达第 i - 1 和第 i - 2节台阶的走法之和
            step = (stepTwo + stepOne) % 1000000007;
            // 更新转态
            stepOne = stepTwo;
            stepTwo = step;
        }
        return step;
    }
}

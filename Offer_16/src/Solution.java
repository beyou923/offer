/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/22 = 1/4 = 0.25
 *
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31,2^31 − 1] 。
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 */

public class Solution {
    public static double myPow(double x, int n) {
        if (n == 0) // FIXME: 2个判断顺序不能颠倒，下面if在前的时候 0^0输出 0 结果不对
            return 1;
        if (x == 0)
            return 0;
        // 指数大于 0 直接计算
        if (n > 0)
            return powerWithUnsignedExponent(x, n);
        else {
            // 指数小于 0 ，先把指数 取绝对值按照指数大于 0 计算，最后再取倒数
            // TODO:定义一个 long 类型的变量防止 n = -2^31 时候乘 -1 溢出
            long convertExponent = (long) n * -1;
            return 1 / powerWithUnsignedExponent(x, convertExponent);
        }

    }

    public static double powerWithUnsignedExponent(double base, long exponent) {
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        // 右移 1位 相当于 除以2  用位运算比乘除运算效率高
        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;
        // 如果exponent是奇数
        // 判断指数是奇数还是偶数 相当于取余操作 位运算比取余运算效率高
        if (1 == (exponent & 0x1))
            result *= base;

        return result;
    }
}

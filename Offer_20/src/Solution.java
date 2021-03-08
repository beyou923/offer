/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 *
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * **/
public class Solution {
    //TODO： Java没有指针概念，需要用一个全局遍历记录索引位置，充当指针的功能
    private static int currentIndex;
    private static boolean space;
    public boolean isNumber(String s) {
        char str[] = s.toCharArray();
        if (str == null || str.length == 0) {
            return false;
        }
        currentIndex = 0;
        //判断整数部分
        boolean isNumber = isSignedInteger(str);
        //整数部分后面有无空格
        // 只有整数部分
        if (currentIndex + 1 == str.length && str[currentIndex] == ' ' && isNumber){
            return true;
        } else if (currentIndex + 1 < str.length && str[currentIndex] == ' ' ){
            return false;
        }
        //判断小数部分
        if (currentIndex < str.length && str[currentIndex] == '.' && !space) {
            currentIndex++;
            //小数点前后至少有一个是整数就行  注意||的前后位置，短路或
            isNumber = isUnsignedInteger(str) || isNumber;
        }
        //判断指数部分
        if (currentIndex < str.length && (str[currentIndex] == 'e' || str[currentIndex] == 'E') && !space) {
            currentIndex++;
            //e或E前后都要有整数
            isNumber = isNumber && isSignedInteger(str);
        }
        return isNumber && (currentIndex == str.length);
    }

    //判断整数部分是不是数字
    private static boolean isSignedInteger(char[] chars) {
        // 过滤掉前面的空格
        while (currentIndex < chars.length && chars[currentIndex] == ' ')
            currentIndex++;

       if (currentIndex < chars.length && (chars[currentIndex] == '+' || chars[currentIndex] == '-')){
            currentIndex++;
        }
        return isUnsignedInteger(chars);
    }
    // 判断小数部分是不是无符号整数
    private static boolean isUnsignedInteger(char[] chars) {
        int before = currentIndex;
        while (currentIndex < chars.length && chars[currentIndex] >= '0' && chars[currentIndex] <= '9') {
            currentIndex++;
        }
        //至少存在一个数字
        return currentIndex > before;
    }
}

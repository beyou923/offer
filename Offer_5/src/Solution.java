import java.util.Arrays;

/**
 *  请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *  示例 1：
 *      输入：s = "We are happy."
 *      输出："We%20are%20happy."
 *  限制：
 *      0 <= s 的长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * **/
public class Solution {
    public  String replaceSpace(String s) {
        int space = 0;// 空格数
        char[] array = s.toCharArray();
        // 统计原字符串中空格个数
        for (int i = 0 ; i < array.length;i++){
            if (array[i] == ' ')
                space++;
        }
        // 新定义一个字符创数组 长度是原来长度加上替换空格后的长度
        char[] newString = new char[array.length + space * 2];
        int indexOfOld = array.length - 1; // 指向原字符串的末尾
        int indexOfNew = newString.length -1 ; // 指向新字符串的末尾
        while (indexOfOld >= 0 && 0 <= indexOfNew) {
            // 遍历原字符串 当前字符不是空格就从后往前复制到新字符创中
            if (array[indexOfOld] != ' '){
                newString[indexOfNew--] = array[indexOfOld];
            } else {
                // 否则，将原字符串的空格在新字符串中替换成 %20 新字符串的指针先前移动三个位置
                newString[indexOfNew--] = '0';
                newString[indexOfNew--] = '2';
                newString[indexOfNew--] = '%';
            }
            indexOfOld--;
        }
//        newString.toString(); // 这个方法返回的是 字符串的地址
//        return Arrays.toString(newString); // 不能用Arrays.toString()方法 该方法返回一个string 类型的 list 而题目要求字符串
        return String.valueOf(newString);
    }
}

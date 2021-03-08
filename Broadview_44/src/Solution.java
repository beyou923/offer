class Solution {
    public int findNthDigit(int n) {
        int digit = 1; // 位数
        long start = 1; // digit位数字段的起始数字
        long count = 9; // <=digit位数字的位数和
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}
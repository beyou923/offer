public class Solution {
    // 基于加减法
    public static void exchange1(int a, int b)
    {
        System.out.printf("old: a = %d \t b = %d\n",a,b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("new: a = %d \t b = %d\n",a,b);
    }

    // 基于异或运算
    public static void exchange2(int a, int b){
        System.out.printf("old: a = %d \t b = %d\n",a,b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("new: a = %d \t b = %d\n",a,b);
    }
    public static void main(String[] args){
        int a = 1, b = 2;
        exchange2(a,b);
    }
}

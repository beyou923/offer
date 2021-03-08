import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *      输入: n = 1
 *      输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *      n 为正整数
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * */
public class NewSolution {
    public void printNumbers(int n) {
        if (n < 1)
            return;

        char number[] = new char[n];
        Arrays.fill(number,'0');

        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfNDigits(number,n,0);
        }
    }
    public void printToMaxOfNDigits(char number[],int length,int index){
        if (index == length -1){
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char)(i + '0');
            printToMaxOfNDigits(number,length,index + 1);
        }
    }
    public void printNumber(char number[]) {
        boolean begin = true;
        //TODO: 过滤掉无用的 0
        for (int i = 0; i < number.length; ++i){
            if (begin && number[i] != '0'){
                begin = false;
            }
            if (!begin)
                System.out.printf("%c",number[i]);
        }
        System.out.println();
    }
    public static void main(String args[]){
        NewSolution main = new NewSolution();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数 n ：");
        int n = scanner.nextInt();
        main.printNumbers(n);
    }
}

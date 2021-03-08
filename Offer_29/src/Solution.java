import java.lang.module.FindException;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *      输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 *      输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 *      输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 *      输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 *      0 <= matrix.length <= 100
 *      0 <= matrix[i].length <= 100
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * */
// TODO: 把矩阵分解成若干个圆圈，从内到外依次打印 ，每一圈起点坐标为（0，0）、（1，1）...(i,i) 且
// TODO： rows > start * 2 && cols > start * 2 其中start为每一圈的起点坐标
public class Solution {
    public int[] spiralOrder(int[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        // 矩阵 行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        int oder[] = new int[rows * cols];
        Arrays.fill(oder,0);

        int start = 0;
        int counter = 0;
        // 循环条件很重要
        while (rows > start * 2 && cols > start * 2) {
            int endX = cols - start - 1;
            int endY = rows - start - 1;
            for (int index = start; index <= endX; index++)
                oder[counter++] = matrix[start][index];

            if (endY > start){
                for (int index = start + 1; index <= endY; index++)
                    oder[counter++] = matrix[index][endX];
            }

            if (endY > start && endX > start){
                for (int index = endX -1;index >= start; index--)
                    oder[counter++] = matrix[endY][index];
            }
            // 这个循环条件非常重要
            if (endX > start && endY - 1 > start){
                for (int index = endY - 1; index > start; index--)
                    oder[counter++] = matrix[index][start];
            }
            ++start;
        }
        return oder;
    }
}

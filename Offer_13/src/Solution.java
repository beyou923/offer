import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *  地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 *  它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *  例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *  示例 1：
 *      输入：m = 2, n = 3, k = 1
 *      输出：3
 *
 *  示例 2：
 *       输入：m = 3, n = 1, k = 0
 *      输出：1
 *
 *  提示：
 *      1 <= n,m <= 100
 *      0 <= k<= 20
 *
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 */
class Solution {
    public int movingCount(int m, int n, int k) {
        // 检测边界条件
       if (m <= 0 || n <= 0 || k < 0)
           return 0;
       // 标记数组 未访问的格子置 false
       boolean visited[][] = new boolean[m][n];
       for (int i = 0; i < m; ++i)
           Arrays.fill(visited[i],false);
        // 从坐标 [0,0]开始
       int count = movingCountCore(m,n,0,0,k,visited);
       return count;
    }

    int movingCountCore(int rows,int cols,int row,int col,int threshold,boolean visited[][]) {
        int count = 0;
        // 判断[row,col]位置能否到达
        if (check(rows,cols,row,col,visited,threshold)){
            visited[row][col] = true;
            // 从[row,col]位置依次尝试上下左右的格子看看能否到达
            count = 1 + movingCountCore(rows,cols,row + 1,col,threshold,visited)
                    + movingCountCore(rows,cols,row -1, col,threshold,visited)
                    + movingCountCore(rows,cols,row,col - 1,threshold,visited)
                    + movingCountCore(rows,cols,row,col + 1,threshold,visited);
        }
        return count;
    }

    boolean check(int rows,int cols, int row, int col, boolean visited[][], int threshold){
        if (row < rows && row >= 0 && col < cols && col >= 0 && getDigitSum(row) + getDigitSum(col) <= threshold && !visited[row][col])
            return true;
        return false;
    }

    private int getDigitSum(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10; // 取个位数
            x /= 10; // 右移一位
        }
        return sum;
    }
}

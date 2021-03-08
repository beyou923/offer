/** 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *  示例:
 *  现有矩阵 matrix 如下：

        [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
        ]
    给定 target =5，返回 true。给定 target = 20，返回 false。
    限制：
        0 <= n <= 1000
        0 <= m <= 1000
 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
**/
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 注意二维数组判定
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int row = matrix.length - 1; // 二维数组行索引
        int col = matrix[0].length -1 ; // 二维数组列索引最大值
        int i = 0;// 从第一行开始遍历
        // 注意行列边界条件
        while ( i <= row && col >= 0){
            // 右上角值恰好等于 目标值 直接退出
           if (matrix[i][col] == target){
               return true;
           } else if (matrix[i][col] > target) { // 右上角值大于 目标值，则舍弃最后一列
               col = col -1;
           }else { // 右上角值 小于 目标值，则舍弃最上面一行
               i++;
           }
        }
        return false;
    }
}

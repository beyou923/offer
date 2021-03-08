import java.util.Arrays;

/**
 *  请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 *  每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 *  例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 *      [["a","b","c","e"],
 *      ["s","f","c","s"],
 *      ["a","d","e","e"]]
 *  但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *  示例 1：
 *      输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 *      输出：true
 *
 *  示例 2：
 *      输入：board = [["a","b"],["c","d"]], word = "abcd"
 *      输出：false
 *
 *  提示：
 *      1 <= board.length <= 200
 *      1 <= board[i].length <= 200
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 */
// TODO：回溯法依次尝试二维数组的每个位置，如果这个位置在路径中就从这个位置的上下左右四个方向依次递归判断
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 二维数组每个位置都尝试一次
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (dfs(board,words,row,col,0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,char[] words,int row,int col,int index) {
        // 边界条件判断
        if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != words[index])
            return false;
        // 如果words的每个字符都检查完了，返回true 终止条件必须是 index == words.length - 1
        if (index == words.length - 1)
            return true;
        // 暂存当前位置的值 避免分支污染
        char tmp = board[row][col];
        // 表示当前位置已经搜索过  words中不能包含 '.'
        board[row][col] = '.';
        // 从当前位置的4个反向递归，只要有1个能走通返回true
        boolean res = dfs(board,words,row + 1,col,index + 1) || dfs(board,words,row -1,col,index + 1) ||
                dfs(board,words,row,col + 1,index + 1) || dfs(board,words,row,col - 1,index + 1);
        // 回溯状态
        board[row][col] = tmp;
        return res;
    }
}

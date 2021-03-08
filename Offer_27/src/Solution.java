/**
 *  请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 *  示例 1：
 *      输入：root = [4,2,7,1,3,6,9]
 *      输出：[4,7,2,9,6,3,1]
 *
 *  限制：
 *      0 <= 节点个数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x ;
    }
}
// TODO:只有存在子树就把左右子树交换
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        // 只有一个节点
        if (root.left == null && root.right == null)
            return root;
        // 交换根节点左右子树
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        // 递归交换左节点的子树
        if (root.left != null)
            mirrorTree(root.left);
        // 递归交换右节点的子树
        if (root.right != null)
            mirrorTree(root.right);

        return root;
    }
}

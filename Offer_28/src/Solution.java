/**
 *  请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *  限制：
 *      0 <= 节点个数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x;
    }
}
// TODO : 对称节点 L 和 R的值要相等，且 L.left.val=R.right.val ：即 LL 的 左子节点 和 RR 的 右子节点 对称；
// TODO： L.right.val = R.left.valL.right.val=R.left.val ：即 LL 的 右子节点 和 RR 的 左子节点 对称。

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // root为空 肯定是对称二叉树 直接返回
        return (root == null) ? true : recur(root.left,root.right);
    }

    public boolean recur(TreeNode L,TreeNode R){
        if (L == null && R == null)
            return true;
        if (L == null || R == null)
            return false;

        if (L.val != R.val)
            return false;
        // 对称节点的子树对称才算对称
        return recur(L.left,R.right) && recur(L.right,R.left);
    }
}

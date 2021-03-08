import java.util.HashMap;
import java.util.Map;

/**
 *  输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *  例如，给出
 *      前序遍历 preorder = [3,9,20,15,7]
 *      中序遍历 inorder = [9,3,15,20,7]
 *  返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  限制：
 *      0 <= 节点个数 <= 5000
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * **/


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        Map<Integer,Integer> indexOfNode = new HashMap<Integer,Integer>();
        int length = inorder.length;
        for (int i = 0; i < length; i++)
            indexOfNode.put(inorder[i],i);

        TreeNode root = build(preorder,0,length - 1,inorder,0,length -1,indexOfNode);
        return root;
    }
    public TreeNode build(int[] preorder,int preorderStart,int preorderEnd,int[] inorder,int inorderStart,int inorderEnd,Map<Integer,Integer> indexOfNode) {
        if (preorderStart > preorderEnd)
            return null;
        // 获取根节点小标
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart != preorderEnd) {
            // 根节点在中序遍历中的下标
            int rootIndex = indexOfNode.get(rootVal);
            // 左右子树节点个数
            int leftNodes = rootIndex - inorderStart;
            int rightNodes = inorderEnd - rootIndex;
            // 构建左子树
            TreeNode leftSubTree = build(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexOfNode);
            // 构建右子树
            TreeNode rightSubTree = build(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexOfNode);
            // 将左右子树插入根节点
            root.left = leftSubTree;
            root.right = rightSubTree;
        }
        return root;

    }
}


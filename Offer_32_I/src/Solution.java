import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  返回：[3,9,20,15,7]
 *
 *  提示：节点总数 <= 1000
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
// TODO : 层序遍历 (BFS)
public class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        Queue<TreeNode> node = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        node.add(root);// 先将根节点入队列
        while (!node.isEmpty()){
            TreeNode tmpNode = node.poll();
            ans.add(tmpNode.val);
            // 依次将当前节点左右孩子节点入队列
            if (tmpNode.left != null) node.add(tmpNode.left);
            if (tmpNode.right != null)  node.add(tmpNode.right);
        }
        int result[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); ++i)
            result[i] = ans.get(i);

        return result;
    }
}

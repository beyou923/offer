import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 *      给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 提示：
 *    节点总数 <= 1000
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x;
    }
}
//TODO : 层序遍历（BFS） 把每一层分别加入列表
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root){
        if (root == null)
            // 当根节点未null 时候不能返回null
            return new ArrayList<>(0);
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}

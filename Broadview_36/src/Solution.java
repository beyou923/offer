class Node{
    int val;
    Node left;
    Node right;
    public Node(int x){
        val = x;
    }
    public Node(int x,Node left,Node right){
        val = x;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    Node pre ,head;
    public Node treeToDoublyList(Node root){
        if (root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur){
        if (cur == null) return;
        dfs(cur.left);
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}

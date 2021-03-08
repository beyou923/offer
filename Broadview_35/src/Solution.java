class Node {
    int val;
    Node next;
    Node random;

    public Node(int x){
        val = x;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head){
        if (head == null) return null;
        Node cur = head;
        // 1. 复制各个节点并拼接链表
        while (cur != null){
            Node tmp = new Node(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 2. 构建各新节点的random指向
        cur = head;
        while (cur != null){
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 3. 拆分两个链表
        cur = head.next;
        Node pre = head,res = head.next;
        while (cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;// 单独处理原链表的尾节点
        return res;
    }
}

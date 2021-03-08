/**
 *  在 O(1)时间内删除链表节点。给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。
 *
 * 示例 1:
 *      输入: head = [4,5,1,9], val = 5
 *      输出: [4,1,9]
 *      解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * 示例 2:
 *      输入: head = [4,5,1,9], val = 1
 *      输出: [4,5,9]
 *      解释: 给定你链表中值为 1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 *
 * 链接：https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * */
// TODO: 欲删除节点 i ，可以把节点 i 的下一个节点（假设是 j），先把 j 的值复制到节点 i 中，再把节点 i 指向 节点 j 的下一个节点 ，删除节点 j
class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}

public class Solution {
    public static ListNode deleteNode(ListNode head, ListNode delNode) {
        if (head == null)
            return null;
        if (head.next == null && head == delNode)
            return null;

        delNode.val = delNode.next.val;
        delNode.next = delNode.next.next;

        return head;
    }
    public static void main(String args[]){
        ListNode list[] = new ListNode[10];
        ListNode head = new ListNode(1);
        list[0] = head;
        ListNode tmp = head;
        for (int i = 1 ; i < 10; i++){
            ListNode node = new ListNode(i + 1);
            list[i] = node;
            tmp.next = node;
            tmp = node;
        }

        ListNode newHead = deleteNode(head,list[3]);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

/**
 *  输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *  例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 *  示例：
 *      给定一个链表: 1->2->3->4->5, 和 k = 2.
 *      返回链表 4->5.
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * **/
// TODO：双指针法。让前后指针之间的距离相差 k  ，具体而言先让第一个指针（初始时指向第一个节点）走 k  步，再让第二个指针从第一个节点同第二指针
// TODO: 一同向后移动，当第一个指针指向指向空时，第二个指针恰好指向倒数第k个节点

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0)
            return null;
        // 头指针初始时指向头节点
        ListNode first = head;
        ListNode end = head;
        for (int i = 0;  i < k; ++i)
            // k > 链表长度
            if (first == null )
                return null;
            first = first.next;
        while (first != null){
            first = first.next;
            end = end.next;
        }
        return end;
    }
}

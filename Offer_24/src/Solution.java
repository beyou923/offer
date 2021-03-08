/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 *  限制：
 *       0 <= 节点个数 <= 5000
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * **/
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
// TODO ： 头插法
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = head;
        ListNode index = head.next;
        newHead.next = null;
        ListNode tmp;
        while (index != null){
            tmp = index; // 这2条语句位置不能换，也不能分开， 否则会段链
            index = index.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
}

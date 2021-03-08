/**
 *  输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 *  示例1：
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 *  限制：
 *      0 <= 链表长度 <= 1000
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * */

class ListNode {
    int val;
    ListNode next;
    public ListNode(int x){
        val = x;
    }
}
// TODO:归并排序
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode head; // 归并后链表头节点
        ListNode currentNode; // 新链表当前节点
        // 确定头节点
        if (l1.val <= l2.val){
            head = l1;
            l1 = l1.next;
        } else{
            head = l2;
            l2 = l2.next;
        }

        currentNode = head;
        // 遍历两个链表
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                currentNode.next = l1;
                currentNode = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                currentNode = l2;
                l2 = l2.next;
            }
        }
        // 把长链表剩余部分直接加到新链表末尾
        if (l1 == null)
            currentNode.next = l2;
        if (l2 == null)
            currentNode.next = l1;

        return head;
    }
}

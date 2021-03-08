/**
 *  给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 *  示例：
 *      输入：1->2->3->4->5->6->3
 *      输出：节点3
 *      解释：节点2指向节点同时节点6也指向节点3
 * */

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
/*:双指针法
    TODO： 1. 用双指针法判断链表中是否存在环。定义2个针值fast和slow，初始时候都指向头机节点，fast指针一次走2步，
            slow指针一次走1步，如果fast指针追上slow指针，则一定存在环。如果不存在环返回 null；如果存在环转到下一步；
           2. 如果存在环，让slow（或）沿着环移动，每移动一步计数器加cycleNumber1，当slow和fast再次相遇时，计数器cycleNumber的值就是环中节点个数。
           定义2个指针preNode和postNode， 初始时候都指向头机节点，先让preNode移动cycleNumber步，再让preNode和postNode一起移动，当他们相遇时候
           ，指向的节点就是入口节点
 */
public class Solution {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head,slow = head;
        int cycleNumber = 1;
        // 1. 判断没有有环
        while (fast != null && slow != null){
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            // 存在环
            if (fast == slow){
                // 统计环中节点个人
                while (slow.next != fast){
                    ++cycleNumber;
                    slow = slow.next;
                }

                ListNode preNode = head, postNode = head;
                // preNode指针先移动 cycleNumber 步
                for (int i = 0; i < cycleNumber; ++i)
                    preNode = preNode.next;
                // preNode和postNode一起移动。两个指针相遇处就是环入口
                while (preNode != postNode){
                    preNode = preNode.next;
                    postNode = postNode.next;
                }
                return postNode;
            }
        }
        return null;
    }
}

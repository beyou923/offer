/**
 *  判断一个链表中是否存在环，存在返回 true，不存在返回 false
 *  示例：
 *      输入：1->2->3->4->5->6->3
 *      输出：true
 *      解释：节点2指向节点同时节点6也指向节点3
 * */

class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
// TODO: 双指针法. 定义2个针值，初始时候都指向头机节点，一个指针一次走2步，一个指针一次走1步，如果走得快得指针追上走得慢得指针，则一定存在环
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head,slow = head;
        while (fast != null && slow != null){
            slow = slow.next; // slow指针一次走一步
            // TODO： 不能这样写 fast = fast.next.next 会报空指针异常
            fast = fast.next; // fast指针一次走2步
            if (fast != null)
                fast = fast.next;

            if (slow == fast){
                return true;
            }
        }
        return false;

    }
}

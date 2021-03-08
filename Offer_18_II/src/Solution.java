/**
 * 删除链表中重复的节点，在一个排序的链表中，如何删除重复节点？
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }
}

// TODO:记录3个指针，一个指向当前节点，一个指向前一个节点，最后一个指向下一个节点，如果三个指针指向的位置元素都不相等，则3个指针分别向后
// TODO:移动一个位置,如果当前位置元素等于下一个位置元素则只移动下一个位置指针，直到当前位置元素小于下一位置元素，并让前一个位置元素指向下一位置元素
public class Solution {
    public static ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode preNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            boolean needDelete = false;

            // 出现了重复节点
            if (nextNode != null && nextNode.val == curNode.val)
                needDelete = true;
            // 没有出现重复元素，同时移动当前指针和指向前一个节点指针
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                // 出现了重复节点
                int value = curNode.val;
                ListNode deleteNode = curNode;
                // 找出所有与当前节点重复的节点
                while (deleteNode != null && deleteNode.val == value) {
                    nextNode = deleteNode.next;
                    deleteNode = nextNode;
                }
                if (preNode == null)
                    head = nextNode;
                else
                    preNode.next = nextNode;
                curNode = nextNode;
            }
        }
        return head;
    }

    public static void main(String args[]) {
        int value[] = new int[]{2 ,3, 4, 4, 5, 5, 6, 7, 8};
        ListNode head = new ListNode(1);
        ListNode tmp = head;
        for (int i = 0; i < value.length; i++) {
            ListNode node = new ListNode(value[i]);
            tmp.next = node;
            tmp = node;
        }

        ListNode node = deleteDuplication(head);
        while (node != null) {
            System.out.printf("%d\t", node.val);
            node = node.next;
        }

    }
}

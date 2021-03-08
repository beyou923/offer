import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *  输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *  示例 1：
 *      输入：head = [1,3,2]
 *      输出：[2,3,1]
 *  限制：
 *      0 <= 链表长度 <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * **/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0] ; // 链表为空，则返回空数组
        Stack<Integer> stack = new Stack<>(); // 定义一个元素类型为整型的栈
        while (head != null) {
            // 将每个节点元素依次入栈
            stack.push(head.val);
            head = head.next;
        }
        int number = stack.size();// 获取链表节点个数
        int[] result = new int[number]; // 最终打印值
        for (int i = 0; i < number; i++){
            // 栈中元素依次存入 result中
            result[i] = stack.pop();
        }
        return result;
    }
}

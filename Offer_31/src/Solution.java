import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
 * 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 示例 1：
 *      输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 *      输出：true
 *      解释：我们可以按以下顺序执行：
 *          push(1), push(2), push(3), push(4), pop() -> 4,
 *          push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *      输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 *      输出：false
 *      解释：1 不能在 2 之前弹出。
 *
 * 提示：
 *      0 <= pushed.length == popped.length <= 1000
 *      0 <= pushed[i], popped[i] < 1000
 *      pushed 是 popped 的排列。
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * */
// TODO : 定义一个辅助队列，把第一个序列中的元素按照第二个序列中元素的顺序入栈，并且按照第二个序列的顺序依次弹出栈中元素。
// TODO： 如果下一个弹出的元素刚好是栈顶元素，直接弹出；如果下一个弹出的元素不在栈顶，则把压栈序列中还没有入栈的元素入栈直到把下一个需要弹出的元素压入
// TODO：栈顶为止；如果所有数字都压入栈中仍未遇到下一个弹出的元素，就可以肯定这个序列不可能是弹出序列
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null || pushed.length < 1 || popped.length < 1)
            return true;
        Stack<Integer> stackData = new Stack();
        int i = 0 , j = 0;
        while (i < popped.length){
            while (stackData.empty() || stackData.peek() != popped[i]){
                if (j >= pushed.length)
                    break;
                stackData.push(pushed[j++]);
            }
            if (stackData.peek() != popped[i])
                break;
            stackData.pop();
            i++;
        }
        if (stackData.empty() && i == popped.length)
            return true;
        else
            return false;
    }
}

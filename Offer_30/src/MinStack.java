import java.util.Stack;

/**
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *  示例:
 *      MinStack minStack = new MinStack();
 *      minStack.push(-2);
 *      minStack.push(0);
 *      minStack.push(-3);
 *      minStack.min();   --> 返回 -3.
 *      minStack.pop();
 *      minStack.top();      --> 返回 0.
 *      minStack.min();   --> 返回 -2.
 *
 *  提示：
 *      各函数的调用总次数不超过 20000 次

 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * */
// TODO : 用一个辅助栈 minStack，入栈时候每次都把最小元素压入 minStack，出栈时候2个栈都出
public class MinStack {
    Stack<Integer> dataStack,minStack;
    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 每次让 x与 minStack 栈顶元素比较，将较小的压入 minStack 中
        dataStack.push(x);
        if (minStack.empty() || minStack.peek() > x){
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 示例 1：
 *  输入：
 *      ["CQueue","appendTail","deleteHead","deleteHead"]
 *      [[],[3],[],[]]
 *  输出：[null,null,3,-1]
 * 示例 2：
 *  输入：
 *      ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 *      [[],[],[5],[2],[],[]]
 *  输出：[null,-1,null,null,5,2]
 * 提示：
 *      1 <= values <= 10000
 *      最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * **/

// TODO : stackEnqueue只做入栈操作，相当于队尾，出栈时候先将stackEnqueue中元素逐一弹出压入stackDequeue中(相当于队头)，
// TODO : 最后将stackDequeue栈顶元素弹出
public class CQueue {
    Stack<Integer> stackDequeue; // 队头
    Stack<Integer> stackEnqueue; // 队尾
    public CQueue() {
        stackDequeue = new Stack<>();
        stackEnqueue = new Stack<>();
    }

    public void appendTail(int val){
        // 队尾插入元素
        stackEnqueue.push(val);
    }
    public int deleteHead(){
        // stackDequeue栈中为空先把 stackEnqueue栈中元素出栈并逐一压入stackDequeue中 顺序变为先入先出
        if (stackDequeue.isEmpty()) {
            while (!stackEnqueue.isEmpty())
                stackDequeue.push(stackEnqueue.pop());
        }
        // 所有元素已出队列 根据题目要求返回-1
        if (stackDequeue.isEmpty()){
            return -1;
        } else{
            // 将stackDequeue栈顶元素弹出
            return stackDequeue.pop();
        }
    }
}

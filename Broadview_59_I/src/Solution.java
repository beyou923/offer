import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 1) return nums; // 处理 len = 0 ，k = 0的情况
        int[] maxInWindows = new int[len - k + 1]; // 长度为len的数组，滑动窗口为k，可以滑动 len - k + 1 次
        int index = 0;
        if (len >= k && k >= 1){
            Deque<Integer> deque = new LinkedList<>();
            // 向单调队列中填充最初的k个元素
            for (int i = 0; i < k; i++){
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                    deque.pollLast();
                deque.offerLast(i);
            }
            // 从第k个元素开始遍历
            for (int i = k; i < len; i++){
                maxInWindows[index++] = nums[deque.peekFirst()];
                // 去尾操作
                while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                    deque.pollLast();
                // 删头操作
                if (!deque.isEmpty() && deque.peekFirst() <= i - k)
                    deque.pollFirst();

                deque.offerLast(i);
            }
            maxInWindows[index++] = nums[deque.peekFirst()];
        }
        return maxInWindows;
    }
}
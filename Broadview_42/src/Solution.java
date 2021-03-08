public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len <= 0) return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE; //最大值初始值
        int[] sumWithIndex = new int[len];// 记录以索引i结尾的字串和的最大值
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sumWithIndex[i] = nums[i];
            } else {
                if (sumWithIndex[i - 1] < 0) {
                    sumWithIndex[i] = nums[i];
                } else sumWithIndex[i] = sumWithIndex[i - 1] + nums[i];
            }
        }
        for (int i = 0; i < len; i++) {
            if (sumWithIndex[i] > max) max = sumWithIndex[i];
        }
        return max;
    }
}

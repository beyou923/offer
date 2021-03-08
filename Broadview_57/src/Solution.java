public class Solution {
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        if (len < 2) return new int[0];
        int left = 0, right = len -1;
        while ( left < right){
            if (nums[left] + nums[right] == target){
               return new int[]{nums[left],nums[right]};
            }
            else if (nums[left] + nums[right] > target) right--;
            else left++;
        }
        return new int[0];
    }
}

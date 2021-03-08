public class Solution {
    public boolean isStraight(int[] nums){
        int len = nums.length;
        if (len < 5) return false;
        fastSort(nums,0,len - 1);

        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i = 0; i < len && nums[i] == 0; i++) // 统计大、小王数量 <= 2
            numberOfZero++;
        int small = numberOfZero;
        int big = small + 1;
        while (big < len){
            if (nums[small] == nums[big]) // 有顺子
                return false;
            numberOfGap += nums[big] - nums[small] - 1; // 统计坑位
            small = big;
            big++;
        }
        return (numberOfGap <= numberOfZero) ? true : false;
    }

    public void fastSort(int[] nums,int start,int end){
        if (start >= end) return; // 这句必须要有
        int left = start, right = end;
        int key = nums[left];
        while (left < right){
            while (left < right && nums[right] >= key)
                right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= key)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = key;
        fastSort(nums,start,left - 1);
        fastSort(nums,right + 1, end);
    }
}

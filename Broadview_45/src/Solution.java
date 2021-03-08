public class Solution {
    public String minNumber(int[] nums){
        // TODO：不能这样写，将数组转换成字符串 最后输出中包含 “[]”，而答案中不能有[]
//        if (nums.length == 1) return Arrays.toString(nums);// array changes to string
        if (nums.length == 1) return String.valueOf(nums[0]);
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            str[i] = String.valueOf(nums[i]);
        fastSort(str,0, str.length - 1);
        StringBuilder res = new StringBuilder();
        for ( String s: str) {
            res.append(s);
        }
        return res.toString();
    }
    public void fastSort(String[] str,int start,int end){
        if (start >= end) return;
        String key = str[start];
        int left = start,right = end;
        while (left < right){
            while ((str[right] + key).compareTo(key + str[right]) >= 0 && left < right) right--;
            str[left] = str[right];
            while ((str[left] + key).compareTo(key + str[left]) <= 0 && left < right) left++;
            str[right] = str[left];
        }
        str[left] = key;
        fastSort(str,start,left - 1);
        fastSort(str,right + 1,end);
    }
}

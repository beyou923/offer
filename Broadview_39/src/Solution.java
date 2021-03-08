import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums){
        int x = 0, votes = 0;
        for (int num: nums) {
            if (votes == 0) x = num;
            // x 等于当前元素num，票数为+1，否则为-1
            votes += x == num ? 1 : -1;
        }
        return x;
    }
}

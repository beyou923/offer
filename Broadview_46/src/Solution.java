public class Solution {
    public int translateNum(int num){
        String str = String.valueOf(num);
        int len = str.length();
        if (len < 2) return len;
        char[] charArray = str.toCharArray();
        int dp[] = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++){
            dp[i] = dp[i -1];
            int currentNum = 10 * (charArray[i -1] - '0') + (charArray[i] - '0');
            if (currentNum >= 10 && currentNum <= 25){
                if (i - 2 < 0) dp[i]++; // 只有2位数
                else dp[i] += dp[i -2];
            }
        }
        return dp[len - 1];
    }
}

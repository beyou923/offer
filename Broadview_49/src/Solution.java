public class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int a = 0, b = 0, c = 0;
        int dp[] = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2,n3 = dp[b] * 3,n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3),n5);
            if (dp[i] == dp[a] * 2) a++;
            if (dp[i] == dp[b] * 3) b++;
            if (dp[i] == dp[c] * 5) c++;
        }
        return dp[n - 1];
    }
}

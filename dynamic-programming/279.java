class Solution {
    //dynamic programming
    //最终的最优结果取决于前面步骤的最优结果
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp , n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 1;j * j <= i;j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
    
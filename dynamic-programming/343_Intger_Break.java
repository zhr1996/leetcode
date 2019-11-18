class Solution {
    //DP solution
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            //Consider breaking a product into two parts, 8 : 1 * 7, 2 * 6, 3 * 5
            //But both the left and right number can be further break down, so we need to check if 
            //after break down, the product is greater than the original.
            //This is done by Math.max(j, dp[j]), Math.max(i-j, dp[i-j])
            //Math.max(dp[i],...) maintains the best solution got so fr
            for(int j = 1; j < i; j ++) {
                //
               dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
       return dp[n];
    }
}
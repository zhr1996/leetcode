class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int j = 0; j <= n - 1 ; j++){
            if(matrix[0][j] == '1'){
                dp[0][j] = 1;
                max = 1;
            }
        }
        for(int i = 0; i <= m - 1; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                max = 1;
            }
        }
       
        for(int i = 1; i <= m - 1; i++){
            
            for(int j = 1;j <= n - 1; j++){
                if(matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
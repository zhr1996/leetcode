class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        result[0][0] = 1;
        //initial first row 注意这个地方一旦有obstacle，就必须把之后的都设置为0
        for(int j = 0;j <= n - 1;j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }
            result[0][j] = 1;
        }
        for(int i = 0;i <= m - 1;i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            result[i][0] = 1;
        }
        for(int i = 1;i <= m - 1;i++){
            for(int j = 1;j <= n -1;j++){
                if(obstacleGrid[i][j] != 1){
                    result[i][j] = result[i-1][j] + result[i][j-1];
                }
            }
        }
        
        return result[m-1][n-1];
    }
}